package subway.view;

import subway.constant.OutputMessage;
import subway.constant.PrintElement;
import subway.main.MainOption;
import subway.station.StationOption;

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

    public void printStationOption() {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(StationOption.values())
                .forEach(value ->
                        stringBuilder.append(value.getOption())
                                .append(PrintElement.COMMA)
                                .append(value.getTitle())
                                .append(PrintElement.NEW_LINE)
                );
        System.out.println(OutputMessage.MAIN_MESSAGE);
        System.out.println(stringBuilder);
    }

    public void printNewLine() {
        System.out.println();
    }
}
