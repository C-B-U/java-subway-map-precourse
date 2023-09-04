package subway.main;

import subway.line.LineController;
import subway.section.SectionController;
import subway.station.StationController;
import subway.subwaymap.SubwayMapController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {

    private final OutputView outputView;
    private final InputView inputView;
    private final StationController stationController;
    private final LineController lineController;
    private final SectionController sectionController;
    private final SubwayMapController subwayMapController;

    public SubwayController(Scanner scanner) {
        this.outputView = new OutputView();
        this.inputView = new InputView(scanner);
        this.stationController = new StationController(scanner);
        this.lineController = new LineController(scanner);
        this.sectionController = new SectionController(scanner);
        this.subwayMapController = new SubwayMapController();
    }

    public void start() {
        Initialization.init();
        while (true) {
            MainOption option = readOption();
            if (option.isQuit()) {
                break;
            }
            link(option);
        }
    }

    private MainOption readOption() {
        outputView.printMainOptions();
        outputView.printOptions();
        MainOption option = inputView.readOption();
        outputView.printNewLine();
        return option;
    }

    private void link(MainOption option) {
        linkToStationManagement(option);
        linkToLineManagement(option);
        linkToSectionManagement(option);
        linkToSubwayMap(option);
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

    private void linkToSubwayMap(MainOption option) {
        if (option.isSubwayMap()) {
            subwayMapController.start();
        }
    }
}
