package subway.view;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.features.LineFeatures;
import subway.domain.features.MainFeatures;
import subway.domain.features.StationFeatures;
import subway.repository.StationRepository;

import java.util.Scanner;

public class InputView {
    private static final OutputView outputView = new OutputView();

    public MainFeatures inputWantedFeature() {
        final Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        try {
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
            return StationFeatures.convert(number);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputWantedStationFeature();
        }
    }

    public Station inputStationName() {
        final Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            return new Station(name);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputStationName();
        }
    }

    public LineFeatures inputWantedLineFeature() {
        final Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        try {
            return LineFeatures.convert(number);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputWantedLineFeature();
        }
    }

    public Line inputLineName() {
        final Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            return new Line(name);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputLineName();
        }
    }

    public Station inputStationOfLineName() {
        final Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            StationRepository.validateExistStation(name);
            return StationRepository.getStation(name);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputStationOfLineName();
        }
    }
}
