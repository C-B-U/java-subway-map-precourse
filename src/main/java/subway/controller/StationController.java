package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class StationController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    public void start() {
        outputView.printStationManagementScreen();
    }
}
