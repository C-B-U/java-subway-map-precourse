package subway;

import subway.main.SubwayController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayController controller = new SubwayController();
        controller.start();
    }
}
