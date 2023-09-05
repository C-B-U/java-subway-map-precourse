package subway.controller;

import subway.domain.InformationMessage;
import subway.domain.Line;
import subway.domain.ProcessMessage;
import subway.domain.Station;
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
        outputView.printProcess(ProcessMessage.INPUT_REGISTER_LINE);
        try {
            Line line = inputView.inputLineName();
            lineService.registerLine(line);
            executeStationOfLineRegistration(line);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
        }
    }

    private void executeStationOfLineRegistration(Line line) {
        try {
            executeFirstStationOfLineRegistration(line);
            executeLastStationOfLineRegistration(line);
            outputView.printInformation(InformationMessage.REGISTER_LINE);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
        }
    }

    private void executeFirstStationOfLineRegistration(Line line) {
        outputView.printProcess(ProcessMessage.REGISTER_FIRST_STATION_OF_LINE);
        Station firstStation = inputView.inputStationOfLineName();
        lineService.addStation(line, firstStation);
    }

    private void executeLastStationOfLineRegistration(Line line) {
        outputView.printProcess(ProcessMessage.REGISTER_LAST_STATION_OF_LINE);
        Station lastStation = inputView.inputStationOfLineName();
        lineService.addStation(line, lastStation);
    }

    private void executeDeletion(LineFeatures lineFeatures) {
        if(lineFeatures == LineFeatures.DELETE) {
            executeLineDeletion();
        }
    }

    private void executeLineDeletion() {
        outputView.printProcess(ProcessMessage.INPUT_DELETE_LINE);
        try {
            lineService.deleteLine(inputView.inputLineName());
            outputView.printInformation(InformationMessage.DELETE_STATION);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
        }
    }

    private void executeLineView(LineFeatures lineFeatures) {
        if(lineFeatures == LineFeatures.VIEW) {
            outputView.printProcess(ProcessMessage.VIEW_LINE);
            lineService.viewLine();
        }
    }
}
