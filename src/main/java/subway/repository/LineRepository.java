package subway.repository;

import subway.domain.message.ErrorMessage;
import subway.domain.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    private LineRepository () {}

    static {
        Line lineTwo = new Line("2호선");
        lineTwo.addStation(StationRepository.getStation("교대역"));
        lineTwo.addStation(StationRepository.getStation("강남역"));
        lineTwo.addStation(StationRepository.getStation("역삼역"));
        addLine(lineTwo);

        Line lineThree = new Line("3호선");
        lineThree.addStation(StationRepository.getStation("교대역"));
        lineThree.addStation(StationRepository.getStation("남부터미널역"));
        lineThree.addStation(StationRepository.getStation("양재역"));
        lineThree.addStation(StationRepository.getStation("매봉역"));
        addLine(lineThree);

        Line lineSinBoonDang = new Line("신분당선");
        lineSinBoonDang.addStation(StationRepository.getStation("강남역"));
        lineSinBoonDang.addStation(StationRepository.getStation("양재역"));
        lineSinBoonDang.addStation(StationRepository.getStation("양재시민의숲역"));
        addLine(lineSinBoonDang);
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        validateNotExistLine(line.getName());
        lines.add(line);
    }

    public static void deleteLine(Line line) {
        validateExistLine(line.getName());
        lines.removeIf(value -> Objects.equals(value.getName(), line.getName()));
    }

    public static void validateNotExistLine(String name) {
        if (lines.stream().anyMatch(value -> value.getName().equals(name))) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_LINE.toString());
        }
    }

    private static void validateExistLine(String name) {
        if (lines.stream().noneMatch(value -> value.getName().equals(name))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_LINE.toString());
        }
    }
}
