package subway.constant;

public enum ExceptionMessage {

    INVALID_OPTION("존재하지 않는 기능입니다."),
    INVALID_LENGTH("2글자 이상 입력만 가능합니다."),
    DUPLICATE_STATION("이미 존재하는 역입니다."),
    NOT_EXISTENT_STATION("존재하지 않는 역입니다."),
    DUPLICATE_LAST_STATION("상행 종점 역과 하행 종점역인 다른 역으로 입력되어야 합니다."),
    DUPLICATE_LINE("이미 존재하는 노선입니다."),
    NOT_EXISTENT_LINE("존재하지 않는 노선입니다."),
    EXISTING_SECTION("해당 노선에 이미 존재하는 역입니다."),
    OUT_OF_RANGE("해당 순서에 역을 추가할 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
