package subway.domain;

public class Line {
    private static final String LINE_UNIT = "선";
    private static final int MINIMUM_LENGTH = 2;

    private final String name;

    public Line(String name) {
        validateLinenName(name);
        this.name = name;
    }

    private void validateLinenName(String name) {
        validateLinenNameLength(name);
        validateLineNameComponent(name);
    }

    private void validateLinenNameLength(String name) {
        if(!name.endsWith(LINE_UNIT)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NAME_COMPONENT.toString());
        }
    }

    private void validateLineNameComponent(String name) {
        if (name.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LINE_NAME_LENGTH.toString());
        }
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
