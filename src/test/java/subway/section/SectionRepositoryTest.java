package subway.section;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.line.Line;
import subway.line.LineRepository;
import subway.line.StopStations;
import subway.station.Name;
import subway.station.Station;
import subway.station.StationRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SectionRepositoryTest {

    @BeforeAll
    public static void initStations() {
        StationRepository.addStation(new Name("범계역"));
        StationRepository.addStation(new Name("금정역"));
        StationRepository.addStation(new Name("산본역"));

        Station upBound = StationRepository.findByName(new Name("범계역"));
        Station descending = StationRepository.findByName(new Name("금정역"));
        StopStations stopStations = new StopStations(List.of(upBound, descending));

        LineRepository.addLine(new Name("4호선"), stopStations);
    }

    @DisplayName("구간을 추가한다.")
    @Test
    void addSection() {
        Name lineName = new Name("4호선");
        Name stationName = new Name("산본역");
        int index = 2;

        SectionService sectionService = new SectionService();
        sectionService.create(lineName, stationName, index);

        assertThat(LineRepository.lines().size()).isEqualTo(1);
    }

    @DisplayName("구간을 삭제한다.")
    @Test
    void deleteSection() {
        Name lineName = new Name("4호선");
        Name stationName = new Name("범계역");
        SectionService sectionService = new SectionService();

        sectionService.delete(lineName, stationName);
        Station station = StationRepository.findByName(stationName);

        assertThat(LineRepository.findLineByName(lineName).isContainStation(station)).isFalse();
    }
}
