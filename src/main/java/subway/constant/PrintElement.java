package subway.constant;

public enum PrintElement {

    COMMA(". "),
    NEW_LINE("\n");

    private final String element;

    PrintElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element;
    }
}
