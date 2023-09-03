package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class Controller {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    public void start() {
        outputView.printMainScreen();
        inputView.inputWantedFeature();
    }
}
