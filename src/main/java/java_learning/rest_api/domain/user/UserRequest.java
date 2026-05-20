package java_learning.rest_api.domain.user;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank(message = "USER_NAME_IS_REQUIRED")
        @Size(max = 100, message = "USER_NAME_IS_TOO_LONG")
        String name,

        @NotBlank(message = "USER_EMAIL_IS_REQUIRED")
        @Email(message = "USER_EMAIL_INVALID_FORMAT")
        String email,

        @NotBlank(message = "USER_PASSWORD_IS_REQUIRED")
        @Size(min=6, message = "USER_PASSWORD_MIN_SIZE_6")
        String password
) {}
