package subway.view;

import subway.constant.InformationMessage;
import subway.constant.OutputMessage;
import subway.constant.PrintElement;
import subway.main.MainOption;
import subway.station.Station;
import subway.station.StationOption;
import subway.station.StationRepository;

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

    public void printStationCreation() {
        System.out.println(OutputMessage.CREATE_STATION);
    }

    public void printCreated() {
        System.out.println(InformationMessage.COMPLETE_CREATE_STATION);
    }

    public void printDeleteStation() {
        System.out.println(OutputMessage.DELETE_STATION);
    }

    public void printDeleted() {
        System.out.println(InformationMessage.COMPLETE_DELETE_STATION);
    }

    public void printStations() {
        StringBuilder stringBuilder = new StringBuilder();
        StationRepository.stations()
                .forEach(station -> appendStations(stringBuilder, station));
        System.out.println(OutputMessage.READ_STATION);
        System.out.println(stringBuilder);
    }

    private void appendStations(StringBuilder stringBuilder, Station station) {
        stringBuilder.append(station);
    }

    public void printNewLine() {
        System.out.println();
    }
}
