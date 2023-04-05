package lv.javaguru.travel.insurance.corev2.validations.person;

import lv.javaguru.travel.insurance.corev2.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.corev2.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.corev2.validations.ValidationErrorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class PersonLastNameValidation extends TravelPersonFieldValidationImpl {

    @Autowired private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationErrorDTO> validate(PersonDTO person) {
        return (person.getPersonLastName() == null || person.getPersonLastName().isEmpty())
                ? Optional.of(errorFactory.buildError("ERROR_CODE_8"))
                : Optional.empty();
    }

}
