package subway.main;

import subway.station.StationController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {

    private final OutputView outputView;
    private final InputView inputView;
    private final StationController stationController;

    public SubwayController(Scanner scanner) {
        this.outputView = new OutputView();
        this.inputView = new InputView(scanner);
        this.stationController = new StationController(outputView, inputView);
    }

    public void start() {
        Initialization.init();
        outputView.printMainOptions();
        MainOption option = inputView.readOption();
        link(option);
    }

    private void link(MainOption option) {
        if (option.isStationManagement()) {
            stationController.start();
        }
    }
}
