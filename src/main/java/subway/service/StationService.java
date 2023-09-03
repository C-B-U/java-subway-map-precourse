package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.view.OutputView;

public class StationService {
    private static final OutputView outputView = new OutputView();

    public void registerStation(Station station) {
        StationRepository.addStation(station);
    }

    public void deleteStation(Station station) {
        StationRepository.deleteStation(station);
    }
