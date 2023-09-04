package subway.view;

import subway.constant.OutputMessage;
import subway.constant.PrintElement;
import subway.main.MainOption;

import java.util.Arrays;

public class OutputView {

    public void printMainOptions() {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(MainOption.values())
                .forEach(value ->
                        stringBuilder.append(value.getOption())
                                .append(PrintElement.COMMA)
                                .append(value.getTitle())
                                .append(PrintElement.NEW_LINE)
                );
        System.out.println(OutputMessage.MAIN_MESSAGE);
        System.out.println(stringBuilder);
    }

    public void printOptions() {
        System.out.println(OutputMessage.OPTION_SELECT);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printExceptionMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }
}
