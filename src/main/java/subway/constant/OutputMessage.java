package subway.constant;

public enum OutputMessage {

    MAIN_MESSAGE("메인 화면");

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
