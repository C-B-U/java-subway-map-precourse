package subway.view.LineView;

import subway.constant.OutputMessage;
import subway.constant.PrintElement;
import subway.line.LineOption;

import java.util.Arrays;

public class LineOutputView {

    public void printLineOption() {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(LineOption.values())
                .forEach(value ->
                        stringBuilder.append(value.getOption())
                                .append(PrintElement.COMMA)
                                .append(value.getTitle())
                                .append(PrintElement.NEW_LINE)
                );
        System.out.println(OutputMessage.LINE_MANAGEMENT_SCREEN);
        System.out.println(stringBuilder);
    }

    public void printOptions() {
        System.out.println(OutputMessage.OPTION_SELECT);
    }

    public void printReadLineName() {
        System.out.println(OutputMessage.CREATE_LINE);
    }

    public void printUpBoundStation() {
        System.out.println(OutputMessage.UP_BOUND_STATION);
    }

    public void printNewLine() {
        System.out.println();
    }
}
