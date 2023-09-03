package subway.constant;

public enum OutputMessage {

    MAIN_MESSAGE("메인 화면"),
    OPTION_SELECT("원하는 기능을 선택하세요."),
    STATION_OPTION_SELECT("역 관리 화면"),
    CREATE_STATION("등록할 역 이름을 입력하세요."),
    DELETE_STATION("삭제할 역 이름을 입력하세요."),
    READ_STATION("역 목록"),
    LINE_MANAGEMENT_SCREEN("노선 관리 화면"),
    CREATE_LINE("등록할 노선 이름을 입력하세요."),
    UP_BOUND_STATION("등록할 노선의 상행 종점역 이름을 입력하세요."),
    DESCENDING_STATION("등록할 노선의 하행 종점역 이름을 입력하세요."),
    DELETE_LINE("삭제할 노선 이름을 입력하세요."),
    READ_LINE("노선 목록");

    private static final String PREFIX = "## ";
    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
