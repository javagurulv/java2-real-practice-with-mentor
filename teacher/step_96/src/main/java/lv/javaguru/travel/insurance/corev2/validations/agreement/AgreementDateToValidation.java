package lv.javaguru.travel.insurance.corev2.validations.agreement;

import lv.javaguru.travel.insurance.corev2.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.corev2.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.corev2.validations.ValidationErrorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class AgreementDateToValidation extends TravelAgreementFieldValidationImpl {

    @Autowired private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationErrorDTO> validate(AgreementDTO agreement) {
        return (agreement.getAgreementDateTo() == null)
                ? Optional.of(errorFactory.buildError("ERROR_CODE_4"))
                : Optional.empty();
    }

}
