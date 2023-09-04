package subway.line;

import subway.station.Name;
import subway.station.Station;
import subway.view.LineView.LineInputView;
import subway.view.LineView.LineOutputView;

import java.util.Scanner;

public class LineController {

    private final LineInputView inputView;
    private final LineOutputView outputView;
    private final LineService lineService;

    public LineController(Scanner scanner) {
        this.inputView = new LineInputView(scanner);
        this.outputView = new LineOutputView();
        this.lineService = new LineService();
    }

    public void start() {
        while (true) {
            outputView.printLineOption();
            LineOption option = inputView.readOption();
            if (option.isBack()) {
                break;
            }
            createLine(option);
            deleteLine(option);
            printLines(option);
        }
    }

    public void createLine(LineOption option) {
        if (option.isCreate()) {
            Name name = inputView.readLineName();
            Station upBoundStation = inputView.readUpBoundStation();
            Station descendingStation = inputView.readDescendingStation();
            lineService.create(name, upBoundStation, descendingStation);
            outputView.printCreateLine();
        }
    }

    public void deleteLine(LineOption option) {
        if (option.isDelete()) {
            lineService.delete(inputView.readDeleteStation());
            outputView.printDeleteLine();
        }
    }

    public void printLines(LineOption option) {
        if (option.isRead()) {
            outputView.printLines();
        }
    }
}
