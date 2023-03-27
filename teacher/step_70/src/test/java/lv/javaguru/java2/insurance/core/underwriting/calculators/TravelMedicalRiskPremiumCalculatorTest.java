package lv.javaguru.java2.insurance.core.underwriting.calculators;

import lv.javaguru.java2.insurance.core.domain.CountryDefaultDayRate;
import lv.javaguru.java2.insurance.core.repositories.CountryDefaultDayRateRepository;
import lv.javaguru.java2.insurance.core.util.DateTimeUtil;
import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelMedicalRiskPremiumCalculatorTest {

    @Mock private DateTimeUtil dateTimeUtil;
    @Mock private CountryDefaultDayRateRepository countryDefaultDayRateRepository;
    @Mock private TravelMedicalPersonAgeCoefficientCalculator ageCoefficientCalculator;

    @InjectMocks
    private TravelMedicalRiskPremiumCalculator calculator;

    @Test
    public void shouldCalculatePremium() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getCountry()).thenReturn("SPAIN");
        when(dateTimeUtil.getDaysBetween(any(), any())).thenReturn(2L);
        CountryDefaultDayRate countryDefaultDayRate = mock(CountryDefaultDayRate.class);
        when(countryDefaultDayRate.getDefaultDayRate()).thenReturn(BigDecimal.TEN);
        when(countryDefaultDayRateRepository.findByCountryIc("SPAIN")).thenReturn(Optional.of(countryDefaultDayRate));
        when(ageCoefficientCalculator.findCoefficient(request)).thenReturn(BigDecimal.ONE);
        BigDecimal premium = calculator.calculatePremium(request);
        assertEquals(premium.stripTrailingZeros(),
                new BigDecimal("20").stripTrailingZeros());
    }

}