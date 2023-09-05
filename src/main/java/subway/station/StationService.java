package subway.station;

import subway.line.LineRepository;

public class StationService {

    public void create(Name name) {
        StationRepository.addStation(name);
    }

    public void delete(Name name) {
        Station station = StationRepository.findByName(name);
        LineRepository.deleteStopStation(station);
        StationRepository.deleteStation(station);
    }
}
