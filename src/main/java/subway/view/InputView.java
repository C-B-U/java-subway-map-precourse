package subway.view;

import subway.main.MainOption;
import subway.station.Name;
import subway.station.StationOption;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final OutputView outputView = new OutputView();

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainOption readOption() {
        outputView.printOptions();
        MainOption option = MainOption.getMainOption(scanner.nextLine());
        outputView.printNewLine();
        return option;
    }

    public StationOption readStationOption() {
        outputView.printOptions();
        StationOption option = StationOption.getStationOption(scanner.nextLine());
        outputView.printNewLine();
        return option;
    }

    public Name readStationName() {
        outputView.printStationCreation();
        String name = scanner.nextLine();
        outputView.printNewLine();
        return new Name(name);
    }
}
