package subway.view.subwaymap;

import subway.constant.OutputMessage;
import subway.line.LineRepository;

public class SubwayMapOutputView {

    public void printSubwayMap() {
        System.out.println(OutputMessage.SUBWAY_MAP);
        System.out.println();
        LineRepository.lines()
                .forEach(line -> System.out.println(line.getSubwayMap()));
    }
}
