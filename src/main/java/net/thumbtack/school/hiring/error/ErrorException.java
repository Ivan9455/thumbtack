package net.thumbtack.school.hiring.error;

public class ErrorException extends Exception {
    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public ErrorException(ErrorCode errorCode) {
        super(errorCode.getErrorString());
        this.errorCode = errorCode;
    }
}
