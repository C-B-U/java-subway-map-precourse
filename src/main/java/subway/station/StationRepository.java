package subway.station;

import subway.constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Name name) {
        validateStation(name);
        stations.add(new Station(name));
    }

    private static void validateStation(Name name) {
        if (isDuplicateName(name)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_STATION.toString());
        }
    }

    private static boolean isDuplicateName(Name name) {
        return stations().stream()
                .anyMatch(station -> station.isSame(name));
    }

    public static void deleteStation(Name name) {
        Station station = findByName(name);
        stations.remove(station);
    }

    public static Station findByName(Name name) {
        return stations.stream()
                .filter(station -> station.isSame(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_EXISTENT_STATION.toString()));
    }
}
