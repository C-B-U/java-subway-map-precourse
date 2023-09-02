package subway.main;

import subway.view.OutputView;

public class SubwayController {

    OutputView outputView = new OutputView();

    public void start() {
        Initialization.init();
        outputView.printMainOptions();
    }
}
