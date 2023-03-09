package lv.javaguru.java2.insurance.core;

import lv.javaguru.java2.insurance.rest.TravelCalculatePremiumRequest;
import lv.javaguru.java2.insurance.rest.TravelCalculatePremiumResponse;

public interface TravelCalculatePremiumService {

    TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request);

}
