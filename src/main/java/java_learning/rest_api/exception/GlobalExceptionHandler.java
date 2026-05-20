package java_learning.rest_api.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiError> handleCustomException(CustomException ex, HttpServletRequest request) {

        log.warn("Business error: {}", ex.getMessage());

        ApiError error = new ApiError(ex.getCode().name(), ex.getMessage(), ex.getStatus(), request.getRequestURI(), LocalDateTime.now());

        return ResponseEntity.status(ex.getStatus()).body(error);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        String message = ex.getBindingResult().getFieldErrors().stream().map(err -> err.getField() + ": " + err.getDefaultMessage()).findFirst().orElse("Validation error");

        log.warn("Validation error: {}", message);

        ApiError error = new ApiError(
        "VALIDATION_ERROR",
        message,
        400,
        request.getRequestURI(),
        LocalDateTime.now()
        );

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(
            Exception ex,
            HttpServletRequest request) {

        log.error("Unexpected error", ex);

        ApiError error = new ApiError(
                "INTERNAL_ERROR",
                "Internal server error",
                500,
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(500).body(error);
    }
}
