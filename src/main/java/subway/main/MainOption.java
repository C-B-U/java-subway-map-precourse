package subway.main;

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

    public String getOption() {
        return option;
    }

    public String getTitle() {
        return title;
    }
}
