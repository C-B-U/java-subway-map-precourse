package subway.controller;

import subway.domain.features.MainFeatures;
import subway.view.InputView;
import subway.view.OutputView;

public class Controller {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final StationController stationController = new StationController();
    private static final LineController lineController = new LineController();

    public void start() {
        while (true) {
            outputView.printMainScreen();
            MainFeatures mainFeatures = inputView.inputWantedFeature();
            if (mainFeatures == MainFeatures.QUIT) {
                break;
            }
            execute(mainFeatures);
        }
    }

    public void execute(MainFeatures mainFeatures) {
        executeStationManagement(mainFeatures);
        executeLineManagement(mainFeatures);
    }

    private void executeStationManagement(MainFeatures mainFeatures) {
        if(mainFeatures == MainFeatures.STATION_MANAGEMENT) {
            stationController.start();
        }
    }

    private void executeLineManagement(MainFeatures mainFeatures) {
        if(mainFeatures == MainFeatures.LINE_MANAGEMENT) {
            lineController.start();
        }
    }
}
