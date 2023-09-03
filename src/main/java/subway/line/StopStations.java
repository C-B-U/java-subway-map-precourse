package subway.line;

import subway.station.Station;

import java.util.ArrayList;
import java.util.List;

public class StopStations {

    private final List<Station> element;

    public StopStations(List<Station> stations) {
        this.element = new ArrayList<>(stations);
    }
}
