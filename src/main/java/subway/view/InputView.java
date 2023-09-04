package subway.view;

import subway.main.MainOption;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainOption readOption() {
        return MainOption.getMainOption(scanner.nextLine());
    }
}
