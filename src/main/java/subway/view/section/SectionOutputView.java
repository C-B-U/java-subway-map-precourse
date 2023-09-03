package subway.view.section;

import subway.constant.OutputMessage;
import subway.constant.PrintElement;
import subway.section.SectionOption;
import subway.station.StationOption;

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
}
