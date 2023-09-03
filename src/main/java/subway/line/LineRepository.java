package subway.line;

import subway.constant.ExceptionMessage;
import subway.station.Name;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line, name));
    }
}
