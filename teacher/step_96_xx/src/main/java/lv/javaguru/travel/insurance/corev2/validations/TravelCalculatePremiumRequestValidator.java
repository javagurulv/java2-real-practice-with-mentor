package lv.javaguru.travel.insurance.corev2.validations;

import lv.javaguru.travel.insurance.corev2.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.corev2.api.dto.ValidationErrorDTO;

import java.util.List;

public interface TravelCalculatePremiumRequestValidator {

    List<ValidationErrorDTO> validate(AgreementDTO agreement);

}
