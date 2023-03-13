package lv.javaguru.java2.insurance.core.validations;

import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.java2.insurance.dto.ValidationError;

import java.util.Optional;

interface TravelRequestValidation {

    Optional<ValidationError> execute(TravelCalculatePremiumRequest request);

}
