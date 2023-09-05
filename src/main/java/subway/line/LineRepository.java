package subway.line;

import subway.constant.ExceptionMessage;
import subway.station.Name;
import subway.station.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Name name, StopStations stations) {
        validateStation(name);
        lines.add(new Line(name, stations));
    }

    private static void validateStation(Name name) {
        if (isDuplicateName(name)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LINE.toString());
        }
    }

    private static boolean isDuplicateName(Name name) {
        return lines.stream()
                .anyMatch(line -> line.isSame(name));
    }

    public static void deleteStopStation(Station station) {
        lines.stream()
                .filter(line -> line.isContainStation(station))
                .forEach(lines -> lines.deleteStopStation(station));
    }

    public static void deleteLineByName(Name name) {
        Line line = findLineByName(name);
        lines.remove(line);
    }

    public static void addStopStation(Name lineName, Station station, int index) {
        Line line = findLineByName(lineName);
        line.addStopStation(station, index);
    }

    public static void deleteStopStation(Name lineName, Station station) {
        Line line = findLineByName(lineName);
        line.deleteStopStation(station);
    }

    private static Line findLineByName(Name name) {
        return lines.stream()
                .filter(line -> line.isSame(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_EXISTENT_LINE.toString()));
    }
}
