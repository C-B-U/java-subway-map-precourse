package subway.view;

import subway.domain.Station;
import subway.domain.features.MainFeatures;
import subway.domain.features.StationFeatures;
import subway.validator.Inputvalidator;

import java.util.Scanner;

public class InputView {
    private static final Inputvalidator inputValidator = new Inputvalidator();
    private static final OutputView outputView = new OutputView();

    public MainFeatures inputWantedFeature() {
        final Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        try {
            inputValidator.validateIsDigit(number);
            return MainFeatures.convert(number);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputWantedFeature();
        }
    }

    public StationFeatures inputWantedStationFeature() {
        final Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        try {
            inputValidator.validateIsDigit(number);
            return StationFeatures.convert(number);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputWantedStationFeature();
        }
    }

    public Station inputStationForRegister() {
        final Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            return new Station(name);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputStationForRegister();
        }
    }
}
