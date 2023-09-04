package subway.station;

import subway.constant.ExceptionMessage;

import java.util.Arrays;

public enum StationOption {

    CREATE("1", "역 등록"),
    DELETE("2", "역 삭제"),
    READ("3", "역 조회"),
    BACK("B", "돌아가기");


    private final String option;
    private final String title;

    StationOption(String option, String title) {
        this.option = option;
        this.title = title;
    }

    public static StationOption getStationOption(String option) {
        return Arrays.stream(StationOption.values())
                .filter(value -> option.equals(value.option))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_OPTION.toString()));
    }

    public boolean isCreate() {
        return this == CREATE;
    }

    public boolean isDelete() {
        return this == DELETE;
    }

    public boolean isRead() {
        return this == READ;
    }

    public boolean isBack() {
        return this == BACK;
    }

    public String getOption() {
        return option;
    }

    public String getTitle() {
        return title;
    }
}
