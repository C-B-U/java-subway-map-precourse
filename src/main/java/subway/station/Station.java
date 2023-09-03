package subway.station;

import subway.constant.InformationMessage;

public class Station {

    private final Name name;

    public Station(Name name) {
        this.name = name;
    }

    public boolean isSame(Name name) {
        return name.equals(this.name);
    }

    @Override
    public String toString() {
        return String.format(InformationMessage.STATION_ELEMENT.toString(), name.toString());
    }
}
