package lv.javaguru.travel.insurance.corev2.validations.person;

import lv.javaguru.travel.insurance.corev2.api.dto.PersonDTO;
import lv.javaguru.travel.insurance.corev2.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.corev2.validations.ValidationErrorFactory;
import lv.javaguru.travel.insurance.dto.ValidationError;
import lv.javaguru.travel.insurance.dto.v1.TravelCalculatePremiumRequestV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class EmptyPersonBirthDateValidation extends TravelPersonFieldValidationImpl {

    @Autowired private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationErrorDTO> validate(PersonDTO person) {
        return (personBirthDateIsNull(person))
                ? Optional.of(errorFactory.buildError("ERROR_CODE_11"))
                : Optional.empty();
    }

    private boolean personBirthDateIsNull(PersonDTO person) {
        return person.getPersonBirthDate() == null;
    }

}
