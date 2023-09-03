package subway.controller;

import subway.domain.features.LineFeatures;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    public void start() {
        outputView.printLineManagementScreen();
        LineFeatures lineFeatures = inputView.inputWantedLineFeature();
        if(lineFeatures != LineFeatures.RETURN) {
            execute(lineFeatures);
        }
    }

    public void execute(LineFeatures lineFeatures) {
        executeLineRegistration(lineFeatures);
    }

    private void executeLineRegistration(LineFeatures lineFeatures) {
    }
}
