package java_learning.rest_api.domain.user;

import jakarta.validation.constraints.NotBlank;

public record UserResponse() {
    @NotBlank
    static String name;

    @NotBlank
    static String email;
}
