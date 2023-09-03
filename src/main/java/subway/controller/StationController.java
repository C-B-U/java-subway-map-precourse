package subway.controller;

import subway.domain.ProcessMessage;
import subway.domain.features.StationFeatures;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {
    private static final StationService stationService = new StationService();
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
        executeStationRegistration(stationFeatures);
        executeStationDeletion(stationFeatures);
    }

    private void executeStationRegistration(StationFeatures stationFeatures) {
        if(stationFeatures == StationFeatures.REGISTER) {
            outputView.printWantedStationForRegister();
            try {
                stationService.registerStation(inputView.inputStationName());
                outputView.printInformation(InformationMessage.REGISTER_STATION);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private void executeStationDeletion(StationFeatures stationFeatures) {
        if(stationFeatures == StationFeatures.DELETE) {
            outputView.printWantedStationForDelete();
            try {
                stationService.deleteStation(inputView.inputStationName());
                outputView.printInformation(InformationMessage.DELETE_STATION);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }
}
