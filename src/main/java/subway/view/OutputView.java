package subway.view;

import subway.domain.ProcessMessage;
import subway.domain.features.MainFeatures;
import subway.domain.features.StationFeatures;

public class OutputView {

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
    }

    public void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printStationManagementScreen() {
        printNewLine();
        System.out.println(ProcessMessage.STATION_MANAGEMENT_SCREEN);
        printStationManagement();
    }

    private void printStationManagement() {
        System.out.println(StationFeatures.MANAGEMENT);
        System.out.println(StationFeatures.DELETE);
        System.out.println(StationFeatures.VIEW);
        System.out.println(StationFeatures.RETURN);
        printNewLine();
    }
}
