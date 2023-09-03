package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.view.OutputView;

public class StationService {
    private static final OutputView outputView = new OutputView();

    public void registerStation(Station station) {
        try {
            StationRepository.addStation(station);
            StationRepository.stations().forEach(value -> System.out.println(value.getName()));
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
        }
    }
}
