package subway.subwaymap;

import subway.view.subwaymap.SubwayMapOutputView;

public class SubwayMapController {

    private final SubwayMapOutputView outputView = new SubwayMapOutputView();

    public void start() {
        outputView.printSubwayMap();
    }
}
