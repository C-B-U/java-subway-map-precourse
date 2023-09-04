package subway.line;

import subway.station.Name;
import subway.station.Station;
import subway.view.line.LineInputView;
import subway.view.line.LineOutputView;

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
            LineOption option = readOption();
            if (option.isBack()) {
                break;
            }
            createLine(option);
            deleteLine(option);
            printLines(option);
        }
    }

    private LineOption readOption() {
        outputView.printLineOption();
        outputView.printOptions();
        LineOption option = inputView.readOption();
        outputView.printNewLine();
        return option;
    }

    public void createLine(LineOption option) {
        if (option.isCreate()) {
            Name name = readName();
            Station upBoundStation = readUpBoundStation();
            Station descendingStation = readDescendingStation();
            lineService.create(name, upBoundStation, descendingStation);
            outputView.printCreateLine();
            outputView.printNewLine();
        }
    }

    private Name readName() {
        outputView.printReadLineName();
        Name name = inputView.readLineName();
        outputView.printNewLine();
        return name;
    }

    private Station readUpBoundStation() {
        outputView.printUpBoundStation();
        Station station = inputView.readUpBoundStation();
        outputView.printNewLine();
        return station;
    }

    private Station readDescendingStation() {
        outputView.printDescendingStation();
        Station station = inputView.readDescendingStation();
        outputView.printNewLine();
        return station;
    }

    public void deleteLine(LineOption option) {
        if (option.isDelete()) {
            lineService.delete(readDeleteStation());
            outputView.printDeleteLine();
            outputView.printNewLine();
        }
    }

    private Name readDeleteStation() {
        outputView.printReadDeleteLine();
        Name name = inputView.readDeleteStation();
        outputView.printNewLine();
        return name;
    }

    public void printLines(LineOption option) {
        if (option.isRead()) {
            outputView.printLines();
        }
    }
}
