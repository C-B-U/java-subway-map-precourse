package subway.main;

import subway.line.Line;
import subway.line.LineRepository;
import subway.line.StopStations;
import subway.station.Name;
import subway.station.Station;
import subway.station.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Initialization {

    private static final String STATIONS = "교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역";
    private static final String LINE_TWO = "2호선";
    private static final String LINE_TWO_STATIONS = "교대역, 강남역, 역삼역";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_THREE_STATIONS = "교대역, 남부터미널역, 양재역, 매봉역";
    private static final String LINE_DX = "신분당선";
    private static final String LINE_DX_STATIONS = "강남역, 양재역, 양재시민의숲역";

    private static final String REGEX = ", ";

    public static void init() {
        initStation();
        initLineTwo();
        initLineThree();
        initLineDX();
    }

    private static void initStation() {
        Arrays.stream(STATIONS.split(REGEX))
                .forEach(name -> StationRepository.addStation(new Name(name)));
    }

    private static void initLineTwo() {
        List<Station> stopStation = Arrays.stream(LINE_TWO_STATIONS.split(REGEX))
                .map(name -> StationRepository.findByName(new Name(name)))
                .collect(Collectors.toList());
        Line line = new Line(LINE_TWO, new StopStations(stopStation));
        LineRepository.addLine(line);
    }

    private static void initLineThree() {
        List<Station> stopStation = Arrays.stream(LINE_THREE_STATIONS.split(REGEX))
                .map(name -> StationRepository.findByName(new Name(name)))
                .collect(Collectors.toList());
        Line line = new Line(LINE_THREE, new StopStations(stopStation));
        LineRepository.addLine(line);
    }

    private static void initLineDX() {
        List<Station> stopStation = Arrays.stream(LINE_DX_STATIONS.split(REGEX))
                .map(name -> StationRepository.findByName(new Name(name)))
                .collect(Collectors.toList());
        Line line = new Line(LINE_DX, new StopStations(stopStation));
        LineRepository.addLine(line);
    }
}
