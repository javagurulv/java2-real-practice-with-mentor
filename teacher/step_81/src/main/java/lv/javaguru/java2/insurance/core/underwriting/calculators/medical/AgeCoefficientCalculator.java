package lv.javaguru.java2.insurance.core.underwriting.calculators.medical;

import lv.javaguru.java2.insurance.core.domain.AgeCoefficient;
import lv.javaguru.java2.insurance.core.repositories.AgeCoefficientRepository;
import lv.javaguru.java2.insurance.core.util.DateTimeUtil;
import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Component
class AgeCoefficientCalculator {

    @Value( "${medical.risk.age.coefficient.enabled:false}" )
    private Boolean medicalRiskAgeCoefficientEnabled;

    @Autowired private DateTimeUtil dateTimeUtil;
    @Autowired private AgeCoefficientRepository ageCoefficientRepository;

    BigDecimal calculate(TravelCalculatePremiumRequest request) {
        return medicalRiskAgeCoefficientEnabled
                ? getCoefficient(request)
                : getDefaultValue();
    }

    private BigDecimal getCoefficient(TravelCalculatePremiumRequest request) {
        int age = calculateAge(request);
        return ageCoefficientRepository.findCoefficient(age)
                .map(AgeCoefficient::getCoefficient)
                .orElseThrow(() -> new RuntimeException("Age coefficient not found for age = " + age));
    }

    private Integer calculateAge(TravelCalculatePremiumRequest request) {
        LocalDate personBirthDate = toLocalDate(request.getPersonBirthDate());
        LocalDate currentDate = toLocalDate(dateTimeUtil.getCurrentDateTime());
        return Period.between(personBirthDate, currentDate).getYears();
    }

    private LocalDate toLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    private static BigDecimal getDefaultValue() {
        return BigDecimal.ONE;
    }

}
