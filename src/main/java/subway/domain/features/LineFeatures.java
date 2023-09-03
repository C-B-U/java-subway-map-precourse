package subway.domain.features;

import subway.domain.ErrorMessage;

import java.util.Arrays;

public enum LineFeatures {
    REGISTER("1", "노선 등록"),
    RETURN("B", "돌아가기");


    private static final String DOT = ". ";
    private final String number;
    private final String name;

    LineFeatures(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public static LineFeatures convert(String number) {
        return Arrays.stream(values())
                .filter(value -> value.number.equals(number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.WRONG_FEATURE_NUMBER.toString()));
    }

    @Override
    public String toString() {
        return number + DOT + name;
    }
}
