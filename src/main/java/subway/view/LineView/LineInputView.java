package subway.view.LineView;

import subway.line.LineOption;
import subway.station.Name;
import subway.station.Station;
import subway.station.StationRepository;

import java.util.Scanner;

public class LineInputView {

    private final Scanner scanner;
    private final LineOutputView outputView = new LineOutputView();

    public LineInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public LineOption readOption() {
        outputView.printOptions();
        LineOption option = LineOption.getOption(scanner.nextLine());
        outputView.printNewLine();
        return option;
    }

    public Name readLineName() {
        outputView.printReadLineName();
        String name = scanner.nextLine();
        outputView.printNewLine();
        return new Name(name);
    }

    public Station readUpBoundStation() {
        outputView.printUpBoundStation();
        Station station = StationRepository.findByName(new Name(scanner.nextLine()));
        outputView.printNewLine();
        return station;
    }

    public Station readDescendingStation() {
        outputView.printDescendingStation();
        Station station = StationRepository.findByName(new Name(scanner.nextLine()));
        outputView.printNewLine();
        return station;
    }

    public Name readDeleteStation() {
        outputView.printReadDeleteLine();
        Name name = new Name(scanner.nextLine());
        outputView.printNewLine();
        return name;
    }
}
