package subway.domain.features;

public enum StationFeatures {
    MANAGEMENT("1", "역 등록"),
    DELETE("2", "역 삭제"),
    VIEW("3", "역 조회"),
    RETURN("B", "돌아가기");


    private static final String DOT = ". ";
    private final String number;
    private final String name;

    StationFeatures(String number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return number + DOT + name;
    }
}
