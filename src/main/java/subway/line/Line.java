package subway.line;

import subway.station.Name;

public class Line {

    private final Name name;
    private final StopStations stopStations;

    public Line(Name name, StopStations stopStations) {
        this.name = name;
        this.stopStations = stopStations;
    }

    public Name getName() {
        return name;
    }
}
