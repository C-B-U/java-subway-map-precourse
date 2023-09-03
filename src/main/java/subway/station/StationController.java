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
        outputView.printStationOption();
        StationOption option = inputView.readStationOption();
        createStation(option);
    }

    private void createStation(StationOption option) {
        if (option.isCreate()) {
            stationService.create(inputView.readStationName());
            outputView.printCompleteStationCreate();
        }
    }
}
