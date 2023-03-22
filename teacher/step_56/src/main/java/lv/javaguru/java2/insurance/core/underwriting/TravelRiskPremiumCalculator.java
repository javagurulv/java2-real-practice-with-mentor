package lv.javaguru.java2.insurance.core.underwriting;

import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;

import java.math.BigDecimal;

interface TravelRiskPremiumCalculator {

    BigDecimal calculatePremium(TravelCalculatePremiumRequest request);

    String getRiskIc();

}
