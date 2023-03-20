package lv.javaguru.java2.insurance.core.validations;

import lv.javaguru.java2.insurance.core.util.ErrorCodeUtil;
import lv.javaguru.java2.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ValidationErrorFactory {

    @Autowired private ErrorCodeUtil errorCodeUtil;

    ValidationError buildError(String errorCode) {
        String errorDescription = errorCodeUtil.getErrorDescription(errorCode);
        return new ValidationError(errorCode, errorDescription);
    }

}
