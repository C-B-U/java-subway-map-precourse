package subway.station;

import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    private final OutputView outputView;
    private final InputView inputView;
    private final StationService stationService;

    public StationController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.stationService = new StationService();
    }

    public void start() {
        while (true) {
            outputView.printStationOption();
            StationOption option = inputView.readStationOption();
            if (option.isBack()) {
                break;
            }
            createStation(option);
            deleteStation(option);
            printStation(option);
        }

    }

    private void createStation(StationOption option) {
        if (option.isCreate()) {
            stationService.create(inputView.readStationName());
            outputView.printCreated();
        }
    }

    private void deleteStation(StationOption option) {
        if (option.isDelete()) {
            stationService.delete(inputView.readDeleteStationName());
            outputView.printDeleted();
        }
    }

    private void printStation(StationOption option) {
        if (option.isRead()) {
            outputView.printStations();
        }
    }
}
