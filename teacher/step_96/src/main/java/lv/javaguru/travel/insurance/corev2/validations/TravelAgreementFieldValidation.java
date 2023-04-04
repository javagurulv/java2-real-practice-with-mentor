package lv.javaguru.travel.insurance.corev2.validations;

import lv.javaguru.travel.insurance.corev2.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.corev2.api.dto.ValidationErrorDTO;

import java.util.List;
import java.util.Optional;

public interface TravelAgreementFieldValidation {

    Optional<ValidationErrorDTO> validate(AgreementDTO agreement);

    List<ValidationErrorDTO> validateList(AgreementDTO agreement);

}
