package util;

public enum Input {
    DEMO("demo.txt"),
    TEST("test.txt");

    public final String file;

    Input(String file) {
        this.file = file;
    }
}
