package subway.domain.message;

public enum ProcessMessage {
    MAIN_SCREEN("메인 화면"),
    STATION_MANAGEMENT_SCREEN("역 관리 화면"),
    LINE_MANAGEMENT_SCREEN("노선 관리 화면"),
    SELECT_WANTED_FEATURE("원하는 기능을 선택하세요."),
    INPUT_REGISTER_STATION("등록할 역 이름을 입력하세요."),
    INPUT_REGISTER_LINE("등록할 노선 이름을 입력하세요."),
    REGISTER_FIRST_STATION_OF_LINE("등록할 노선의 상행 종점역 이름을 입력하세요."),
    REGISTER_LAST_STATION_OF_LINE("등록할 노선의 하행 종점역 이름을 입력하세요."),
    INPUT_DELETE_STATION("삭제할 역 이름을 입력하세요."),
    INPUT_DELETE_LINE("삭제할 노선 이름을 입력하세요."),
    VIEW_STATION("역 목록"),
    VIEW_LINE("노선 목록"),
    SUBWAY_MAP("지하철 노선도");

    private static final String PREFIX = "## ";
    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
