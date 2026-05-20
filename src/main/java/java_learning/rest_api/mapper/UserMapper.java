package java_learning.rest_api.mapper;

import java_learning.rest_api.domain.user.User;
import java_learning.rest_api.domain.user.UserRequest;
import java_learning.rest_api.domain.user.UserResponse;

public class UserMapper {

    // DTO -> Entity
    public static User toEntity(UserRequest request) {
        User user = new User();

        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password());

        return user;
    }

    // Entity -> DTO
    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
