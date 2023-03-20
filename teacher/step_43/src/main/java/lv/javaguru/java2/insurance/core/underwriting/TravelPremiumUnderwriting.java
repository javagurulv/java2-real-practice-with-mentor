package lv.javaguru.java2.insurance.core.underwriting;

import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;

import java.math.BigDecimal;

public interface TravelPremiumUnderwriting {

    BigDecimal calculatePremium(TravelCalculatePremiumRequest request);

}
