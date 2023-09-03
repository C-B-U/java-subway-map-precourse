package subway.domain.features;

import java.util.Arrays;

public enum MainFeatures {
    STATION_MANAGEMENT(1, "역 관리"),
    LINE_MANAGEMENT(2, "노선 관리"),
    SECTION_MANAGEMENT(3, "구간 관리"),
    PRINT_SUBWAY_MAP(4, "지하철 노선도 출력"),
    QUIT(0, "종료");

    private static final String DOT = ". ";
    private final int number;
    private final String name;

    MainFeatures(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static MainFeatures convert(String number) {
        return Arrays.stream(values())
                .filter(value -> value.number == Integer.parseInt(number))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return number + DOT + name;
    }
}
