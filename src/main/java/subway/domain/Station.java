package subway.domain;

import subway.domain.message.ErrorMessage;

public class Station {
    private static final String STATION_UNIT = "역";
    private static final int MINIMUM_LENGTH = 2;

    private final String name;

    public Station(String name) {
        validateStationName(name);
        this.name = name;
    }

    private void validateStationName(String name) {
        validateStationNameLength(name);
        validateStationNameComponent(name);
    }

    private void validateStationNameComponent(String name) {
        if(!name.endsWith(STATION_UNIT)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NAME_COMPONENT.toString());
        }
    }

    private void validateStationNameLength(String name) {
        if (name.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_STATION_NAME_LENGTH.toString());
        }
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
