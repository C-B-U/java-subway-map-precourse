package subway.view.section;

import subway.constant.InformationMessage;
import subway.constant.OutputMessage;
import subway.constant.PrintElement;
import subway.section.SectionOption;

import java.util.Arrays;

public class SectionOutputView {

    public void printSectionOption() {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(SectionOption.values())
                .forEach(value -> appendValue(stringBuilder, value));
        System.out.println(OutputMessage.STATION_OPTION_SELECT);
        System.out.println(stringBuilder);
    }

    private void appendValue(StringBuilder stringBuilder, SectionOption option) {
        stringBuilder.append(option.getOption())
            .append(PrintElement.COMMA)
            .append(option.getTitle())
            .append(PrintElement.NEW_LINE);
    }

    public void printOptions() {
        System.out.println(OutputMessage.OPTION_SELECT);
    }

    public void printReadLineName() {
        System.out.println(OutputMessage.SECTION_LINE);
    }

    public void printReadStationName() {
        System.out.println(OutputMessage.SECTION_STATION);
    }

    public void printReadIndex() {
        System.out.println(OutputMessage.SECTION_INDEX);
    }

    public void printCreateSection() {
        System.out.println(InformationMessage.CREATE_SECTION);
    }

    public void printDeleteSectionLine() {
        System.out.println(OutputMessage.DELETE_SECTION_LINE);
    }

    public void printDeleteSectionStation() {
        System.out.println(OutputMessage.DELETE_LINE);
    }

    public void printDeleteSection() {
        System.out.println(InformationMessage.DELETE_SECTION);
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