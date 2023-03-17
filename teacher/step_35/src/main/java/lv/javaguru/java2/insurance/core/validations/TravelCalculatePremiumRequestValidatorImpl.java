package lv.javaguru.java2.insurance.core.validations;

import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.java2.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
class TravelCalculatePremiumRequestValidatorImpl
    implements TravelCalculatePremiumRequestValidator {

    @Autowired
    private List<TravelRequestValidation> travelValidations;

    @Override
    public List<ValidationError> validate(TravelCalculatePremiumRequest request) {
        return travelValidations.stream()
                .map(validation -> validation.execute(request))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

}
