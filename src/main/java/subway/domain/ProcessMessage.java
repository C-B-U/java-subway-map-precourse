package subway.domain;

public enum ProcessMessage {
    MAIN_SCREEN("메인 화면"),
    STATION_MANAGEMENT_SCREEN("역 관리 화면"),
    SELECT_WANTED_FEATURE("원하는 기능을 선택하세요."),
    INPUT_REGISTER_STATION("등록할 역 이름을 입력하세요."),
    INPUT_DELETE_STATION("삭제할 역 이름을 입력하세요."),

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
