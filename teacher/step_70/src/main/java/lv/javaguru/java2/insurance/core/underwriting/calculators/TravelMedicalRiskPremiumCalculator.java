package lv.javaguru.java2.insurance.core.underwriting.calculators;

import lv.javaguru.java2.insurance.core.domain.CountryDefaultDayRate;
import lv.javaguru.java2.insurance.core.repositories.CountryDefaultDayRateRepository;
import lv.javaguru.java2.insurance.core.underwriting.TravelRiskPremiumCalculator;
import lv.javaguru.java2.insurance.core.util.DateTimeUtil;
import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
class TravelMedicalRiskPremiumCalculator implements TravelRiskPremiumCalculator {

    @Autowired private DateTimeUtil dateTimeUtil;
    @Autowired private CountryDefaultDayRateRepository countryDefaultDayRateRepository;
    @Autowired private TravelMedicalPersonAgeCoefficientCalculator ageCoefficientCalculator;

    @Override
    public BigDecimal calculatePremium(TravelCalculatePremiumRequest request) {
        var daysCount = calculateDayCount(request);
        var countryDefaultRate = findCountryDefaultDayRate(request);
        var ageCoefficient = ageCoefficientCalculator.findCoefficient(request);
        return countryDefaultRate
                .multiply(daysCount)
                .multiply(ageCoefficient)
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateDayCount(TravelCalculatePremiumRequest request) {
        var daysBetween = dateTimeUtil.getDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo());
        return new BigDecimal(daysBetween);
    }

    private BigDecimal findCountryDefaultDayRate(TravelCalculatePremiumRequest request) {
        return countryDefaultDayRateRepository.findByCountryIc(request.getCountry())
                .map(CountryDefaultDayRate::getDefaultDayRate)
                .orElseThrow(() -> new RuntimeException("Country day rate not found by country id = " + request.getCountry()));
    }

    @Override
    public String getRiskIc() {
        return "TRAVEL_MEDICAL";
    }

}
