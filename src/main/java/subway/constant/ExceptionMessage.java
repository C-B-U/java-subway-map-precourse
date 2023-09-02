package subway.constant;

public enum ExceptionMessage {

    INVALID_OPTION("존재하지 않는 기능입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
