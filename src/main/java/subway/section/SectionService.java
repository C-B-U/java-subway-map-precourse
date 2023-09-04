package subway.section;

import subway.line.LineRepository;
import subway.station.Name;
import subway.station.StationRepository;

public class SectionService {

    public void create(Name lineName, Name stationName, int index) {
        LineRepository.addStopStation(lineName, StationRepository.findByName(stationName), index);
    }
}