package subway.view;

import subway.domain.message.InformationMessage;
import subway.domain.Line;
import subway.domain.message.ProcessMessage;
import subway.domain.Station;
import subway.domain.features.LineFeatures;
import subway.domain.features.MainFeatures;
import subway.domain.features.StationFeatures;

import java.util.List;

public class OutputView {
    private static final String INFO_TAG = "[INFO] ";
    private static final String DIVISION = "---";

    public void printMainScreen() {
        System.out.println(ProcessMessage.MAIN_SCREEN);
        printMainFeatures();
    }

    public void printNewLine() {
        System.out.println();
    }

    private void printMainFeatures() {
        System.out.println(MainFeatures.STATION_MANAGEMENT);
        System.out.println(MainFeatures.LINE_MANAGEMENT);
        System.out.println(MainFeatures.SECTION_MANAGEMENT);
        System.out.println(MainFeatures.PRINT_SUBWAY_MAP);
        System.out.println(MainFeatures.QUIT);
        printNewLine();
        printSelectWantedFeature();
    }

    public void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        printNewLine();
    }

    public void printStationManagementScreen() {
        printNewLine();
        System.out.println(ProcessMessage.STATION_MANAGEMENT_SCREEN);
        printStationManagementFeature();
        printSelectWantedFeature();
    }

    private void printStationManagementFeature() {
        System.out.println(StationFeatures.REGISTER);
        System.out.println(StationFeatures.DELETE);
        System.out.println(StationFeatures.VIEW);
        System.out.println(StationFeatures.RETURN);
        printNewLine();
    }

    public void printLineManagementScreen() {
        printNewLine();
        System.out.println(ProcessMessage.LINE_MANAGEMENT_SCREEN);
        printLineManagementFeature();
        printSelectWantedFeature();
    }

    private void printLineManagementFeature() {
        System.out.println(LineFeatures.REGISTER);
        System.out.println(LineFeatures.DELETE);
        System.out.println(LineFeatures.VIEW);
        System.out.println(LineFeatures.RETURN);
        printNewLine();
    }

    public void printSelectWantedFeature() {
        System.out.println(ProcessMessage.SELECT_WANTED_FEATURE);
    }

    public void printProcess(ProcessMessage message) {
        printNewLine();
        System.out.println(message.toString());
    }

    public void printInformation(InformationMessage message) {
        printNewLine();
        System.out.println(message.toString());
        printNewLine();
    }

    public void printStations(List<Station> stations) {
        stations.forEach(station -> System.out.println(INFO_TAG + station.getName()));
        printNewLine();
    }

    public void printLines(List<Line> lines) {
        lines.forEach(line -> System.out.println(INFO_TAG + line.getName()));
        printNewLine();
    }

    public void printSubwayMapStation(Station station) {
        System.out.println(INFO_TAG + station.getName());
    }

    public void printSubwayMapLine(Line line) {
        System.out.println(INFO_TAG + line.getName());
        System.out.println(DIVISION);

    }
}
