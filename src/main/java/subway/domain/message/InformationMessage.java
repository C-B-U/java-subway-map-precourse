package subway.domain.message;

public enum InformationMessage {
    REGISTER_STATION("지하철 역이 등록되었습니다."),
    DELETE_STATION("지하철 역이 삭제되었습니다."),
    REGISTER_LINE("지하철 노선이 등록되었습니다.");

    private static final String PREFIX = "[INFO] ";
    private final String message;

    InformationMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
