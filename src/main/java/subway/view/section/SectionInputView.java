package subway.view.section;

import subway.section.SectionOption;
import subway.station.Name;

import java.util.Scanner;

public class SectionInputView {

    private final Scanner scanner;

    public SectionInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public SectionOption readOption() {
        return SectionOption.getOption(scanner.nextLine());
    }

    public Name readLineName() {
        return new Name(scanner.nextLine());
    }

    public Name readStationName() {
        return new Name(scanner.nextLine());
    }

    public int readIndex() {
        return scanner.nextInt();
    }

    public Name readDeleteLine() {
        return new Name(scanner.nextLine());
    }

    public Name readDeleteStation() {
        return new Name(scanner.nextLine());
    }
}
