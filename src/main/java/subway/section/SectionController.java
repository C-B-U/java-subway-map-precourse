package subway.section;

import subway.station.Name;
import subway.view.section.SectionInputView;
import subway.view.section.SectionOutputView;

import java.util.Scanner;

public class SectionController {

    private final SectionInputView inputView;
    private final SectionOutputView outputView;
    private final SectionService sectionService;

    public SectionController(Scanner scanner) {
        this.inputView = new SectionInputView(scanner);
        this.outputView = new SectionOutputView();
        this.sectionService = new SectionService();
    }

    public void start() {
        while (true) {
            try {
                SectionOption option = readOption();
                if (option.isBack()) {
                    break;
                }
                createSection(option);
                deleteSection(option);
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception.getMessage());
            }
        }
    }

    private SectionOption readOption() {
        outputView.printSectionOption();
        outputView.printOptions();
        SectionOption option = inputView.readOption();
        outputView.printNewLine();
        return option;
    }

    private void createSection(SectionOption option) {
        if (option.isCreate()) {
            Name lineName = readLineName();
            Name stationName = readStationName();
            int index = readIndex();
            sectionService.create(lineName, stationName, index);
            outputView.printCreateSection();
            outputView.printNewLine();
        }
    }

    private Name readLineName() {
        outputView.printReadLineName();
        Name name = inputView.readLineName();
        outputView.printNewLine();
        return name;
    }

    private Name readStationName() {
        outputView.printReadStationName();
        Name name = inputView.readStationName();
        outputView.printNewLine();
        return name;
    }

    private int readIndex() {
        outputView.printReadIndex();
        int index = inputView.readIndex();
        outputView.printNewLine();
        return index;
    }

    private void deleteSection(SectionOption option) {
        if (option.isDelete()) {
            sectionService.delete(readDeleteLine(), readDeleteStation());
            outputView.printDeleteSection();
            outputView.printNewLine();
        }
    }

    public Name readDeleteLine() {
        outputView.printDeleteSectionLine();
        Name name = inputView.readDeleteLine();
        outputView.printNewLine();
        return name;
    }

    public Name readDeleteStation() {
        outputView.printDeleteSectionStation();
        Name name = inputView.readDeleteStation();
        outputView.printNewLine();
        return name;
    }
}
