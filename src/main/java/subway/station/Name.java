package subway.station;

import subway.constant.ExceptionMessage;

public class Name {

    private static final int MIN_LENGTH = 2;
    private final String value;

    public Name(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String value) {
        if (value.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LENGTH.toString());
        }
    }

    public boolean equals(Name name) {
        return value.equals(name.value);
    }

    @Override
    public String toString() {
        return value;
    }
}
