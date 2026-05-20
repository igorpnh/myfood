package java_learning.rest_api.exception;

import java.time.LocalDateTime;

public record ApiError(
        String code,
        String message,
        int status,
        String path,
        LocalDateTime timestamp
) {}
