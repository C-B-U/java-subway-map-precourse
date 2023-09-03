package subway.controller;

import subway.domain.ProcessMessage;
import subway.domain.features.StationFeatures;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    public void start() {
        outputView.printStationManagementScreen();
        StationFeatures stationFeatures = inputView.inputWantedStationFeature();
        if(stationFeatures != StationFeatures.RETURN) {
            execute(stationFeatures);
        }
    }

    public void execute(StationFeatures stationFeatures) {

    }
}
