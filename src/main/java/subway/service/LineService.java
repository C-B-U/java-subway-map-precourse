package subway.service;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.OutputView;

public class LineService {
    private static final OutputView outputView = new OutputView();

    public void registerLine(Line line) {
        LineRepository.addLine(line);
    }

    public void viewLine() {
        outputView.printLines(LineRepository.lines());
    }
}
