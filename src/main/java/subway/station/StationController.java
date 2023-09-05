package subway.station;

import subway.view.station.StationInputView;
import subway.view.station.StationOutputView;

import java.util.Scanner;

public class StationController {

    private final StationOutputView outputView;
    private final StationInputView inputView;
    private final StationService stationService;

    public StationController(Scanner scanner) {
        this.outputView = new StationOutputView();
        this.inputView = new StationInputView(scanner);
        this.stationService = new StationService();
    }

    public void start() {
        while (true) {
            try {
                StationOption option = readStationOption();
                if (option.isBack()) {
                    break;
                }
                createStation(option);
                deleteStation(option);
                printStation(option);
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception.getMessage());
            }
        }
    }

    private StationOption readStationOption() {
        outputView.printStationOption();
        outputView.printOptions();
        StationOption option = inputView.readStationOption();
        outputView.printNewLine();
        return option;
    }

    private void createStation(StationOption option) {
        if (option.isCreate()) {
            stationService.create(readStationName());
            outputView.printCreated();
            outputView.printNewLine();
        }
    }

    private Name readStationName() {
        outputView.printStationCreation();
        Name name = inputView.readStationName();
        outputView.printNewLine();
        return name;
    }

    private void deleteStation(StationOption option) {
        if (option.isDelete()) {
            stationService.delete(readDeleteStationName());
            outputView.printDeleted();
            outputView.printNewLine();
        }
    }

    private Name readDeleteStationName() {
        outputView.printDeleteStation();
        Name name = inputView.readDeleteStationName();
        outputView.printNewLine();
        return name;
    }

    private void printStation(StationOption option) {
        if (option.isRead()) {
            outputView.printStations();
        }
    }
}
