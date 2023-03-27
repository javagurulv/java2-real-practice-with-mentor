package lv.javaguru.java2.insurance.core.underwriting.calculators;

import lv.javaguru.java2.insurance.core.domain.AgeCoefficient;
import lv.javaguru.java2.insurance.core.repositories.AgeCoefficientRepository;
import lv.javaguru.java2.insurance.core.util.DateTimeUtil;
import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelMedicalPersonAgeCoefficientCalculatorTest {

    @Mock private DateTimeUtil dateTimeUtil;
    @Mock private AgeCoefficientRepository ageCoefficientRepository;

    @InjectMocks
    private TravelMedicalPersonAgeCoefficientCalculator calculator;

    private TravelCalculatePremiumRequest request;

    @BeforeEach
    void setUp() {
        request = new TravelCalculatePremiumRequest();
        request.setPersonBirthDate(Date.from(LocalDate.of(1990, 1, 1)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    @Test
    void shouldFindCoefficientWhenAgeCoefficientExists() {
        LocalDate currentDate = LocalDate.of(2023, 3, 27);
        int age = 33;
        BigDecimal expectedCoefficient = BigDecimal.valueOf(1.2);

        when(dateTimeUtil.getCurrentDateTime()).thenReturn(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        AgeCoefficient ageCoefficient = mock(AgeCoefficient.class);
        when(ageCoefficient.getCoefficient()).thenReturn(expectedCoefficient);
        when(ageCoefficientRepository.findCoefficient(age)).thenReturn(Optional.of(ageCoefficient));

        BigDecimal result = calculator.findCoefficient(request);

        assertEquals(expectedCoefficient, result);
    }

    @Test
    void shouldThrowExceptionWhenAgeCoefficientNotFound() {
        LocalDate currentDate = LocalDate.of(2023, 3, 27);
        int age = 33;

        when(dateTimeUtil.getCurrentDateTime()).thenReturn(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        when(ageCoefficientRepository.findCoefficient(age)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.findCoefficient(request));

        assertEquals("Age coefficient not found for age = " + age, exception.getMessage());
    }

}