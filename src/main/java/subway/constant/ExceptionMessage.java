package subway.constant;

public enum ExceptionMessage {

    INVALID_OPTION("존재하지 않는 기능입니다."),
    INVALID_LENGTH("2글자 이상 입력만 가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
