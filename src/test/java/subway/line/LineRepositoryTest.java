package subway.line;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.station.Name;
import subway.station.Station;
import subway.station.StationRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineRepositoryTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeAll
    public static void initStations() {
        StationRepository.addStation(new Name("강남역"));
        StationRepository.addStation(new Name("교대역"));
    }

    @DisplayName("이미 존재하는 노선을 다시 생성할 경우 예외 발생")
    @Test
    void validateDuplicateStation() {
        Name lineName = new Name("2호선");
        Station upBoundStation = StationRepository.findByName(new Name("강남역"));
        Station descendingStation = StationRepository.findByName(new Name("교대역"));
        StopStations stopStations = new StopStations(List.of(upBoundStation, descendingStation));

        LineRepository.addLine(lineName, stopStations);

        assertThatThrownBy(() -> LineRepository.addLine(lineName, stopStations))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("존재하지 않는 노선을 삭제할 경우 예외 발생")
    @Test
    void deleteLineException() {
        Name name = new Name("14호선");

        assertThatThrownBy(() -> LineRepository.deleteLineByName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("존재하지 않는 노선에 구간을 추가할 경우 예외 발생")
    @Test
    void addStopStationException() {
        Name name = new Name("14호선");
        Station station = StationRepository.findByName(new Name("강남역"));

        assertThatThrownBy(() -> LineRepository.addStopStation(name, station, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
