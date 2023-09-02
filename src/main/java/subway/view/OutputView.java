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
}
