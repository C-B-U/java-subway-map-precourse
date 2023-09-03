package subway.domain;

public enum ErrorMessage {
    WRONG_STATION_NAME_LENGTH("지하철 역 이름은 2글자 이상만 가능합니다. 다시 입력해 주세요."),
    DUPLICATE_STATION("이미 등록된 역 이름입니다."),
    WRONG_MAIN_FEATURE("선택할 수 없는 기능입니다. 다시 입력해 주세요."),
    WRONG_STATION_NAME_COMPONENT("올바르지 않은 역 이름입니다. 다시 입력해 주세요.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
