package subway.line;

import subway.station.Name;
import subway.station.Station;
import subway.view.LineView.LineInputView;
import subway.view.LineView.LineOutputView;

import java.util.Scanner;

public class LineController {

    private final LineInputView inputView;
    private final LineOutputView outputView;

    public LineController(Scanner scanner) {
        this.inputView = new LineInputView(scanner);
        this.outputView = new LineOutputView();
    }

    public void start() {
        outputView.printLineOption();
        LineOption option = inputView.readOption();
        createLine(option);
    }

    public void createLine(LineOption option) {
        if (option.isCreate()) {
           Name name = inputView.readLineName();
            Station upBoundStation = inputView.readUpBoundStation();
        }
    }
}
