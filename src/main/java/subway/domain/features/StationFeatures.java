package subway.domain.features;

import subway.domain.ErrorMessage;

import java.util.Arrays;

public enum StationFeatures {
    MANAGEMENT("1", "역 등록"),
    DELETE("2", "역 삭제"),
    VIEW("3", "역 조회"),
    RETURN("B", "돌아가기");


    private static final String DOT = ". ";
    private final String number;
    private final String name;

    StationFeatures(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public static StationFeatures convert(String number) {
        return Arrays.stream(values())
                .filter(value -> value.number.equals(number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.WRONG_MAIN_FEATURE.toString()));
    }

    @Override
    public String toString() {
        return number + DOT + name;
    }
}
