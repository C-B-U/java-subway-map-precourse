package subway.view.section;

import subway.section.SectionOption;

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
}
