package subway.station;

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

    public String getOption() {
        return option;
    }

    public String getTitle() {
        return title;
    }
}
