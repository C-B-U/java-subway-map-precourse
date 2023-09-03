package subway.view;

import subway.domain.features.MainFeatures;
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
}
