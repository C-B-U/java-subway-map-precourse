package subway.main;

import subway.line.LineController;
import subway.section.SectionController;
import subway.station.StationController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {

    private final OutputView outputView;
    private final InputView inputView;
    private final StationController stationController;
    private final LineController lineController;
    private final SectionController sectionController;

    public SubwayController(Scanner scanner) {
        this.outputView = new OutputView();
        this.inputView = new InputView(scanner);
        this.stationController = new StationController(outputView, inputView);
        this.lineController = new LineController(scanner);
        this.sectionController = new SectionController(scanner);
    }

    public void start() {
        Initialization.init();
        outputView.printMainOptions();
        MainOption option = inputView.readOption();
        link(option);
    }

    private void link(MainOption option) {
        linkToStationManagement(option);
        linkToLineManagement(option);
        linkToSectionManagement(option);
    }

    private void linkToStationManagement(MainOption option) {
        if (option.isStationManagement()) {
            stationController.start();
        }
    }

    private void linkToLineManagement(MainOption option) {
        if (option.isLineManagement()) {
            lineController.start();
        }
    }

    private void linkToSectionManagement(MainOption option) {
        if (option.isSectionManagement()) {
            sectionController.start();
        }
    }
}
