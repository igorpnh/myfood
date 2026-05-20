package java_learning.rest_api.exception;

public class CustomException extends RuntimeException {

    private final ErrorCode code;
    private final int status;

    public CustomException(ErrorCode code, int status, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public ErrorCode getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}
