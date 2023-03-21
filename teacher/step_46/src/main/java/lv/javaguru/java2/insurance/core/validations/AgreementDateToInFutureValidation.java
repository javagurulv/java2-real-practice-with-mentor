package lv.javaguru.java2.insurance.core.validations;

import lv.javaguru.java2.insurance.core.util.DateTimeUtil;
import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.java2.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
class AgreementDateToInFutureValidation implements TravelRequestValidation {

    @Autowired private DateTimeUtil dateTimeUtil;
    @Autowired private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationError> execute(TravelCalculatePremiumRequest request) {
        Date dateTo = request.getAgreementDateTo();
        Date currentDateTime = dateTimeUtil.getCurrentDateTime();
        return (dateTo != null && dateTo.before(currentDateTime))
                ? Optional.of(errorFactory.buildError("ERROR_CODE_3"))
                : Optional.empty();
    }

}