package lv.javaguru.java2.insurance.core.validations;

import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.java2.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class AgreementDateToValidation implements TravelRequestValidation {

    @Autowired private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationError> execute(TravelCalculatePremiumRequest request) {
        return (request.getAgreementDateTo() == null)
                ? Optional.of(errorFactory.buildError("ERROR_CODE_4"))
                : Optional.empty();
    }

}
