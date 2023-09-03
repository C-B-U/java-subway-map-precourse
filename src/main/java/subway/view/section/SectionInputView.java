package subway.view.section;

import subway.section.SectionOption;
import subway.station.Name;
import subway.station.Station;
import subway.station.StationRepository;

import java.util.Scanner;

public class SectionInputView {

    private final Scanner scanner;
    private final SectionOutputView outputView = new SectionOutputView();

    public SectionInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public SectionOption readOption() {
        outputView.printOptions();
        SectionOption option = SectionOption.getOption(scanner.nextLine());
        outputView.printNewLine();
        return option;
    }

    public Name readLineName() {
        outputView.printReadLineName();
        String name = scanner.nextLine();
        outputView.printNewLine();
        return new Name(name);
    }

    public Station readStationName() {
        outputView.printReadStationName();
        Name name = new Name(scanner.nextLine());
        outputView.printNewLine();
        return StationRepository.findByName(name);
    }

    public int readIndex() {
        outputView.printReadIndex();
        int index = scanner.nextInt();
        outputView.printNewLine();
        return index;
    }
}
