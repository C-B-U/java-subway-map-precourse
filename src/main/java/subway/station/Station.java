package subway.station;

public class Station {

    private final String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSame(String name) {
        return name.equals(this.name);
    }
}
