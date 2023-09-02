package subway.main;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {

    private final OutputView outputView;
    private final InputView inputView;

    public SubwayController(Scanner scanner) {
        this.outputView = new OutputView();
        this.inputView = new InputView(scanner);
    }

    public void start() {
        Initialization.init();
        outputView.printMainOptions();
        MainOption option = inputView.readOption();
    }
}
