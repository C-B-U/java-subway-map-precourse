package subway.repository;

import subway.domain.ErrorMessage;
import subway.domain.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        addLine(new Line("2호선"));
        addLine(new Line("3호선"));
        addLine(new Line("신분당선"));
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        validateNotExistLine(line);
        lines.add(line);
    }

    public static void deleteLine(Line line) {
        validateExistLine(line);
        lines.removeIf(value -> Objects.equals(value.getName(), line.getName()));
    }

    private static void validateNotExistLine(Line line) {
        if (lines.stream().anyMatch(value -> value.getName().equals(line.getName()))) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_LINE.toString());
        }
    }

    private static void validateExistLine(Line line) {
        if (lines.stream().noneMatch(value -> value.getName().equals(line.getName()))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_LINE.toString());
        }
    }
}
