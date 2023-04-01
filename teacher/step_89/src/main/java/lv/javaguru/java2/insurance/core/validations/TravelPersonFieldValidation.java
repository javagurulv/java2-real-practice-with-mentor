package lv.javaguru.java2.insurance.core.validations;

import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.java2.insurance.dto.ValidationError;

import java.util.List;
import java.util.Optional;

public interface TravelPersonFieldValidation {

    Optional<ValidationError> validate(TravelCalculatePremiumRequest request);

    List<ValidationError> validateList(TravelCalculatePremiumRequest request);

}
