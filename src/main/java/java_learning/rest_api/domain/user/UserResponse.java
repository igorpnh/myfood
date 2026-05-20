package java_learning.rest_api.domain.user;

public record UserResponse(
        java.util.UUID id,
        String name,
        String email
) {}
