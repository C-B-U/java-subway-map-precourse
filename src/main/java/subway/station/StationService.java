package subway.station;

public class StationService {

    public void create(Name name) {
        StationRepository.addStation(name);
    }

    public void delete(Name name) {
        StationRepository.deleteStation(name);
    }
}
