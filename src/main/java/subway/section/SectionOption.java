package subway.section;

import subway.constant.ExceptionMessage;

import java.util.Arrays;

public enum SectionOption {

    CREATE("1", "구간 등록"),
    DELETE("2", "구간 삭제"),

    BACK("B", "돌아가기");

    private final String option;
    private final String title;

    SectionOption(String option, String title) {
        this.option = option;
        this.title = title;
    }

    public static SectionOption getOption(String option) {
        return Arrays.stream(SectionOption.values())
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
