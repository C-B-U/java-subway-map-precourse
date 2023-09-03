package subway.station;

import subway.constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station findByName(Name name) {
        return stations.stream()
                .filter(station -> station.isSame(name))
                .findAny()
                .orElseThrow();
    }
}
