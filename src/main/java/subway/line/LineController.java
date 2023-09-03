package subway.line;

import subway.view.LineView.LineInputView;
import subway.view.LineView.LineOutputView;

import java.util.Scanner;

public class LineController {

    private final LineInputView inputView;
    private final LineOutputView outputView;

    public LineController(Scanner scanner) {
        this.inputView = new LineInputView(scanner);
        this.outputView = new LineOutputView();
    }

    public void start() {
        outputView.printLineOption();
    }
}
