package subway.view.line;

import subway.line.LineOption;
import subway.station.Name;
import subway.station.Station;
import subway.station.StationRepository;

import java.util.Scanner;

public class LineInputView {

    private final Scanner scanner;

    public LineInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public LineOption readOption() {
        return LineOption.getOption(scanner.nextLine());
    }

    public Name readLineName() {
        return new Name(scanner.nextLine());
    }

    public Station readUpBoundStation() {
        return StationRepository.findByName(new Name(scanner.nextLine()));
    }

    public Station readDescendingStation() {
        return StationRepository.findByName(new Name(scanner.nextLine()));
    }

    public Name readDeleteStation() {
        return new Name(scanner.nextLine());
    }
}
