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
        outputView.printSectionOption();
        SectionOption option = inputView.readOption();
        createSection(option);
        deleteSection(option);
    }

    private void createSection(SectionOption option) {
        if (option.isCreate()) {
            Name lineName = inputView.readLineName();
            Name stationName = inputView.readStationName();
            int index = inputView.readIndex();
            sectionService.create(lineName, stationName, index);
            outputView.printCreateSection();
        }
    }

    private void deleteSection(SectionOption option) {
        if (option.isDelete()) {
            Name lineName = inputView.readDeleteLine();
            Name stationName = inputView.readDeleteStation();
            sectionService.delete(lineName, stationName);
            outputView.printDeleteSection();
        }
    }
}
