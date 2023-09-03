package subway.section;

import subway.view.section.SectionInputView;
import subway.view.section.SectionOutputView;

import java.util.Scanner;

public class SectionController {

    private final SectionInputView inputView;
    private final SectionOutputView outputView;

    public SectionController(Scanner scanner) {
        this.inputView = new SectionInputView(scanner);
        this.outputView = new SectionOutputView();
    }

    public void start() {
    }
}
