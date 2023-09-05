package subway.domain;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private static final String LINE_UNIT = "선";
    private static final int MINIMUM_LENGTH = 2;

    private final String name;
    private final List<Station> stationList = new LinkedList<>();

    public Line(String name) {
        validateLinenName(name);
        this.name = name;
    }

    public void addStation(Station station) {
        validateIsExist(station);
        stationList.add(station);
    }

    private void validateIsExist(Station station) {
        if (stationList.stream().anyMatch(value -> value.getName().equals(station.getName()))) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_STATION.toString());
        }
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

    public List<Station> getStationList() {
        return new LinkedList<>(stationList);
    }
}
