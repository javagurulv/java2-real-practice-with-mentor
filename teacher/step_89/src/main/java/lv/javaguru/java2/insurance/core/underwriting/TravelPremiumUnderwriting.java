package lv.javaguru.java2.insurance.core.underwriting;

import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;

public interface TravelPremiumUnderwriting {

    TravelPremiumCalculationResult calculatePremium(TravelCalculatePremiumRequest request);

}
