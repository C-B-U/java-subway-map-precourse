package subway.repository;

import subway.domain.message.ErrorMessage;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    private StationRepository() {}

    static {
        addStation(new Station("교대역"));
        addStation(new Station("강남역"));
        addStation(new Station("역삼역"));
        addStation(new Station("남부터미널역"));
        addStation(new Station("양재역"));
        addStation(new Station("양재시민의숲역"));
        addStation(new Station("매봉역"));
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateDuplicateStation(station);
        stations.add(station);
    }

    private static void validateDuplicateStation(Station station) {
        if (stations.stream().anyMatch(value -> value.getName().equals(station.getName()))) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_STATION.toString());
        }
    }

    public static void deleteStation(Station station) {
        validateExistStation(station.getName());
        stations.removeIf(value -> Objects.equals(value.getName(), station.getName()));
    }

    public static void validateExistStation(String name) {
        if (stations.stream().noneMatch(value -> value.getName().equals(name))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_STATION.toString());
        }
    }

    public static Station getStation(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .orElseThrow();
    }
}
