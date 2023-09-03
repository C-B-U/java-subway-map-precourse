package subway.line;

import subway.constant.InformationMessage;
import subway.station.Name;

public class Line {

    private final Name name;
    private final StopStations stopStations;

    public Line(Name name, StopStations stopStations) {
        this.name = name;
        this.stopStations = stopStations;
    }

    public boolean isSame(Name name) {
        return name.equals(this.name);
    }

    @Override
    public String toString() {
        return String.format(InformationMessage.READ_ELEMENT.toString(), name);
    }
}
