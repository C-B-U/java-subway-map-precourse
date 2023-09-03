package subway.station;

public class Station {

    private final Name name;

    public Station(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public boolean isSame(Name name) {
        return name.equals(this.name);
    }
}
