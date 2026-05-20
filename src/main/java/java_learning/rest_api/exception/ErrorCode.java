package java_learning.rest_api.exception;

public enum ErrorCode {

    //USER
    USER_ALREADY_EXISTS(400, "User already exists"),
    USER_NAME_IS_REQUIRED(400, "Name is required"),
    USER_NAME_IS_TOO_LONG(400, "Name is too long"),
    USER_EMAIL_IS_REQUIRED(400, "Email is required"),
    USER_EMAIL_INVALID_FORMAT(400, "Email is invalid"),
    USER_PASSWORD_IS_REQUIRED(400, "Password is required"),
    USER_PASSWORD_MIN_SIZE_6(400, "Password must be at least 6 characters long");

    //RESTAURANTS

    //ORDERS

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
