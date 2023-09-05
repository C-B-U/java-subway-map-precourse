package subway.controller;

import subway.domain.InformationMessage;
import subway.domain.features.LineFeatures;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final LineService lineService = new LineService();

    public void start() {
        outputView.printLineManagementScreen();
        LineFeatures lineFeatures = inputView.inputWantedLineFeature();
        if(lineFeatures != LineFeatures.RETURN) {
            execute(lineFeatures);
        }
    }

    public void execute(LineFeatures lineFeatures) {
        executeRegistration(lineFeatures);
        executeDeletion(lineFeatures);
        executeLineView(lineFeatures);
    }

    private void executeRegistration(LineFeatures lineFeatures) {
        if(lineFeatures == LineFeatures.REGISTER) {
            executeLineRegistration();
        }
    }

    private void executeLineRegistration() {
        outputView.printWantedLineForRegister();
        try {
            lineService.registerLine(inputView.inputLineName());
            outputView.printInformation(InformationMessage.REGISTER_LINE);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
        }
    }

    private void executeDeletion(LineFeatures lineFeatures) {
        if(lineFeatures == LineFeatures.DELETE) {
            executeLineDeletion();
        }
    }

    private void executeLineDeletion() {
        outputView.printWantedLineForDelete();
        try {
            lineService.deleteLine(inputView.inputLineName());
            outputView.printInformation(InformationMessage.DELETE_STATION);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
        }
    }

    private void executeLineView(LineFeatures lineFeatures) {
        if(lineFeatures == LineFeatures.VIEW) {
            outputView.printWantedLineForView();
            lineService.viewLine();
        }
    }
}
