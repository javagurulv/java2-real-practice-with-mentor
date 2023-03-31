package lv.javaguru.java2.insurance.core.underwriting.calculators;

import lv.javaguru.java2.insurance.core.underwriting.TravelRiskPremiumCalculator;
import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class TravelSportActivitiesRiskPremiumCalculator implements TravelRiskPremiumCalculator {

    @Override
    public BigDecimal calculatePremium(TravelCalculatePremiumRequest request) {
        return BigDecimal.ZERO;
    }

    @Override
    public String getRiskIc() {
        return "TRAVEL_SPORT_ACTIVITIES";
    }

}
