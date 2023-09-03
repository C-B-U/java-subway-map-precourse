package subway.view;

import subway.domain.ProcessMessage;
import subway.domain.features.MainFeatures;

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
}
