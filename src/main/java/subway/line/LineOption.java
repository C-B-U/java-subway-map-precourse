package subway.line;

import subway.constant.ExceptionMessage;

import java.util.Arrays;

public enum LineOption {

    CREATE("1", "노선 등록"),
    DELETE("2", "노선 삭제"),
    READ("3", "노선 조회"),
    BACK("B", "돌아가기");

    private final String option;
    private final String title;

    LineOption(String option, String title) {
        this.option = option;
        this.title = title;
    }

    public static LineOption getOption(String option) {
        return Arrays.stream(LineOption.values())
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
        return  this == READ;
    }

    public String getOption() {
        return option;
    }

    public String getTitle() {
        return title;
    }
}
