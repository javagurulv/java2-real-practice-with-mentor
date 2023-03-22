package lv.javaguru.java2.insurance.core.underwriting.calculators;

import lv.javaguru.java2.insurance.core.underwriting.TravelRiskPremiumCalculator;
import lv.javaguru.java2.insurance.core.util.DateTimeUtil;
import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class TravelMedicalRiskPremiumCalculator implements TravelRiskPremiumCalculator {

    @Autowired private DateTimeUtil dateTimeUtil;

    @Override
    public BigDecimal calculatePremium(TravelCalculatePremiumRequest request) {
        var daysBetween = dateTimeUtil.getDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo());
        return new BigDecimal(daysBetween);
    }

    @Override
    public String getRiskIc() {
        return "TRAVEL_MEDICAL";
    }

}
