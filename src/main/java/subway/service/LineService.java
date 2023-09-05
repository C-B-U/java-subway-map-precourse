package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.view.OutputView;

public class LineService {
    private static final OutputView outputView = new OutputView();

    public void registerLine(Line line) {
        LineRepository.addLine(line);
    }

    public void addStation(Line line, Station station) {
        line.addStation(station);
    }

    public void deleteLine(Line line) {
        LineRepository.deleteLine(line);
    }

    public void viewLine() {
        outputView.printLines(LineRepository.lines());
    }

    public void drawMap() {
        LineRepository.lines()
                .forEach(line -> {
                    outputView.printSubwayMapLine(line);
                    line.getStationList().forEach(outputView::printSubwayMapStation);
                    outputView.printNewLine();
                });
    }
}
