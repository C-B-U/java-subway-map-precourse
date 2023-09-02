package subway.view;

import subway.main.MainOption;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final OutputView outputView = new OutputView();

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainOption readOption() {
        outputView.printOptions();
        MainOption option = MainOption.getMainOption(scanner.nextLine());
        outputView.printNewLine();
        return option;
    }
}
