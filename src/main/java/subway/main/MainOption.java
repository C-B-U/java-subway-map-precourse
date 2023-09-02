package subway.main;

import subway.constant.ExceptionMessage;

import java.util.Arrays;

public enum MainOption {
    STATION_MANAGEMENT("1", "역 관리"),
    LINE_MANAGEMENT("2", "노선 관리"),
    SECTION_MANAGEMENT("3", "구간 관리"),
    SUBWAY_MAP("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");


    private final String option;
    private final String title;

    MainOption(String option, String title) {
        this.option = option;
        this.title = title;
    }

    public static MainOption getMainOption(String option) {
        return Arrays.stream(MainOption.values())
                .filter(value -> option.equals(value.option))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_OPTION.toString()));
    }

    public boolean isStationManagement() {
        return this == MainOption.STATION_MANAGEMENT;
    }

    public String getOption() {
        return option;
    }

    public String getTitle() {
        return title;
    }
}
