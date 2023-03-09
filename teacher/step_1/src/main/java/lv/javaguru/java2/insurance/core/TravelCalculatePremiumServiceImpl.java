package lv.javaguru.java2.insurance.core;

import lv.javaguru.java2.insurance.rest.TravelCalculatePremiumRequest;
import lv.javaguru.java2.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        return new TravelCalculatePremiumResponse();
    }

}
