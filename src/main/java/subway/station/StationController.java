package subway.station;

import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    private final OutputView outputView;
    private final InputView inputView;

    public StationController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        outputView.printStationOption();
        StationOption option = inputView.readStationOption();
    }
}
