package subway.validator;

import subway.domain.ErrorMessage;

public class Inputvalidator {
    private static final String REGEX = "^[0-9]+$";

    public void validateIsDigit(String number) {
        if(!number.matches(REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_MAIN_FEATURE.toString());
        }
    }
}
