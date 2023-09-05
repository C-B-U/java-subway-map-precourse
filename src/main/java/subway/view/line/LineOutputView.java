package subway.view.line;

import subway.constant.InformationMessage;
import subway.constant.OutputMessage;
import subway.constant.PrintElement;
import subway.line.Line;
import subway.line.LineOption;
import subway.line.LineRepository;

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

    public void printDescendingStation() {
        System.out.println(OutputMessage.DESCENDING_STATION);
    }

    public void printCreateLine() {
        System.out.println(InformationMessage.COMPLETE_CREATE_STATION);
    }

    public void printReadDeleteLine() {
        System.out.println(OutputMessage.DELETE_LINE);
    }

    public void printDeleteLine() {
        System.out.println(InformationMessage.DELETE_LINE);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printLines() {
        StringBuilder stringBuilder = new StringBuilder();
        LineRepository.lines()
                .forEach(line -> appendStations(stringBuilder, line));
        System.out.println(OutputMessage.READ_LINE);
        System.out.println(stringBuilder);
    }

    private void appendStations(StringBuilder stringBuilder, Line line) {
        stringBuilder.append(line);
    }

    public void printExceptionMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }
}
