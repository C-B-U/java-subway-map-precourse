package subway.service;

import subway.domain.Line;
import subway.repository.LineRepository;

public class LineService {
    public void registerLine(Line line) {
        LineRepository.addLine(line);
    }
}
