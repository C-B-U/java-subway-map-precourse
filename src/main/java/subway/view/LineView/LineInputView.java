package subway.view.LineView;

import subway.line.LineOption;

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
}
