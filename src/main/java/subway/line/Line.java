package subway.line;

import subway.constant.InformationMessage;
import subway.constant.PrintElement;
import subway.station.Name;
import subway.station.Station;

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

    public void addStopStation(Station station, int index) {
        stopStations.addStation(station, index);
    }

    public void deleteStopStation(Station station) {
        stopStations.deleteStation(station);
    }

    @Override
    public String toString() {
        return String.format(InformationMessage.READ_ELEMENT.toString(), name);
    }

    public String getSubwayMap() {
        return String.valueOf(this) +
                PrintElement.DOTTED_LINE +
                PrintElement.NEW_LINE +
                stopStations;
    }
}
