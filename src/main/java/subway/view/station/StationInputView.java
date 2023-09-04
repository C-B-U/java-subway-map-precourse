package subway.view.station;

import subway.station.Name;
import subway.station.StationOption;

import java.util.Scanner;

public class StationInputView {

    private final Scanner scanner;

    public StationInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public StationOption readStationOption() {
        return StationOption.getStationOption(scanner.nextLine());
    }

    public Name readStationName() {
        return new Name(scanner.nextLine());
    }

    public Name readDeleteStationName() {
        return new Name(scanner.nextLine());
    }
}
