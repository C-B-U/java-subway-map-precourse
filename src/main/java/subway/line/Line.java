package subway.line;

public class Line {

    private final String name;
    private final StopStations stopStations;

    public Line(String name, StopStations stopStations) {
        this.name = name;
        this.stopStations = stopStations;
    }

    public String getName() {
        return name;
    }
}
