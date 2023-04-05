package lv.javaguru.travel.insurance.corev2.validations;

import lv.javaguru.travel.insurance.corev2.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.corev2.api.dto.ValidationErrorDTO;

import java.util.List;
import java.util.Optional;

public interface TravelPersonFieldValidation {

    Optional<ValidationErrorDTO> validate(PersonDTO person);

    List<ValidationErrorDTO> validateList(PersonDTO person);

}
