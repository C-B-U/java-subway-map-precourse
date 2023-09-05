package subway.domain;

public enum ErrorMessage {
    WRONG_STATION_NAME_LENGTH("지하철 역 이름은 2글자 이상만 가능합니다. 다시 입력해 주세요."),
    WRONG_LINE_NAME_LENGTH("지하철 노선 이름은 2글자 이상만 가능합니다. 다시 입력해 주세요."),
    DUPLICATE_STATION("이미 등록된 역 이름입니다."),
    WRONG_FEATURE_NUMBER("선택할 수 없는 기능입니다. 다시 입력해 주세요."),
    WRONG_NAME_COMPONENT("올바르지 않은 이름입니다. 다시 입력해 주세요."),
    NOT_EXIST_STATION("존재하지 않는 역입니다."),
    NOT_EXIST_LINE("존재하지 않는 노선입니다.");

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
