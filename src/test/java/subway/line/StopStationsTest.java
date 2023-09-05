package subway.line;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.station.Name;
import subway.station.Station;
import subway.station.StationRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StopStationsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeAll
    public static void initStations() {
        StationRepository.addStation(new Name("남부터미널역"));
        StationRepository.addStation(new Name("양재역"));
        StationRepository.addStation(new Name("매봉역"));
    }

    @DisplayName("하행 종점역과 상행 종점역이 같을 경우 예외가 발생한다.")
    @Test
    void sameTerminalException() {
        Station upBoundStation = StationRepository.findByName(new Name("양재역"));
        Station descendingStation = StationRepository.findByName(new Name("양재역"));

        assertThatThrownBy(() -> new StopStations(List.of(upBoundStation, descendingStation)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("구간에 이미 존재하는 역을 추가하면 예외가 발생한다.")
    @Test
    void duplicateException() {
        Station upBoundStation = StationRepository.findByName(new Name("양재역"));
        Station descendingStation = StationRepository.findByName(new Name("매봉역"));
        StopStations stopStations = new StopStations(List.of(upBoundStation, descendingStation));

        Station duplicateStation = StationRepository.findByName(new Name("양재역"));
        int index = 1;

        assertThatThrownBy(() -> stopStations.addStation(duplicateStation, index))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("범위 밖의 순서를 입력하면 예외가 발생한다.")
    @Test
    void rangeException() {
        Station upBoundStation = StationRepository.findByName(new Name("양재역"));
        Station descendingStation = StationRepository.findByName(new Name("매봉역"));
        StopStations stopStations = new StopStations(List.of(upBoundStation, descendingStation));

        Station duplicateStation = StationRepository.findByName(new Name("남부터미널역"));
        int index = 100;

        assertThatThrownBy(() -> stopStations.addStation(duplicateStation, index))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("구간 삭제 시 존재하지 않는 역을 삭제하면 예외가 발생한다.")
    @Test
    void deleteException() {
        Station upBoundStation = StationRepository.findByName(new Name("양재역"));
        Station descendingStation = StationRepository.findByName(new Name("매봉역"));
        StopStations stopStations = new StopStations(List.of(upBoundStation, descendingStation));

        Station station = StationRepository.findByName(new Name("남부터미널역"));

        assertThatThrownBy(() -> stopStations.deleteStation(station))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력받은 역이 구간 안에 존재하는 경우 True를 반환한다.")
    @Test
    void containStation() {
        Station upBoundStation = StationRepository.findByName(new Name("양재역"));
        Station descendingStation = StationRepository.findByName(new Name("매봉역"));
        StopStations stopStations = new StopStations(List.of(upBoundStation, descendingStation));

        Station station = StationRepository.findByName(new Name("양재역"));

        assertThat(stopStations.contain(station)).isTrue();
    }
}
