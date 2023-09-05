package subway.line;

import subway.station.Name;
import subway.station.Station;

import java.util.List;

public class LineService {

    public void create(Name name, Station upBoundStation, Station descendingStation) {
        LineRepository.addLine(name, new StopStations(List.of(upBoundStation, descendingStation)));
    }

    public void delete(Name name) {
        LineRepository.deleteLineByName(name);
    }
}