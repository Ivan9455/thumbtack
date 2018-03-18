package net.thumbtack.school.colors;

public enum ColorErrorCode {
    WRONG_COLOR_STRING("Wrong color %s"),
    NULL_COLOR("Wrong color null");

    private String errorString;

    public String getErrorString() {
        return errorString;
    }

    ColorErrorCode(String errorString) {
        this.errorString = errorString;
    }

}
