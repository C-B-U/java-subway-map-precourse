package subway.line;

import subway.constant.ExceptionMessage;
import subway.station.Station;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StopStations {

    private static final int START_INDEX = 1;

    private final List<Station> element;

    public StopStations(List<Station> stations) {
        validateDuplicate(stations);
        this.element = new ArrayList<>(stations);
    }

    private void validateDuplicate(List<Station> stations) {
        Set<Station> checkStation = new HashSet<>(stations);
        if (checkStation.size() != stations.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LAST_STATION.toString());
        }
    }

    public void addStation(Station station, int index) {
        validateStation(station, index);
        element.add(index - START_INDEX, station);
    }

    private void validateStation(Station station , int index) {
        validateDuplicateStation(station);
        validateRange(index);
    }

    private void validateDuplicateStation(Station station) {
        if (element.contains(station)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_SECTION_STATION.toString());
        }
    }

    private void validateRange(int index) {
        if (!(1 <= index && index <= element.size())) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.toString());
        }
    }

    public void deleteStation(Station station) {
        validateExistingStation(station);
        element.remove(station);
    }

    private void validateExistingStation(Station station) {
        if (!element.contains(station)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXISTING_STATION.toString());
        }
    }
}
