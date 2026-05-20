package java_learning.rest_api.service;

import java_learning.rest_api.domain.user.User;
import java_learning.rest_api.domain.user.UserRequest;
import java_learning.rest_api.domain.user.UserResponse;
import java_learning.rest_api.exception.CustomException;
import java_learning.rest_api.exception.ErrorCode;
import java_learning.rest_api.mapper.UserMapper;
import java_learning.rest_api.repository.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public UserResponse create(@NonNull UserRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new CustomException(
                    ErrorCode.USER_ALREADY_EXISTS,
                    ErrorCode.USER_ALREADY_EXISTS.getStatus(),
                    ErrorCode.USER_ALREADY_EXISTS.getMessage());
        }

        User user = UserMapper.toEntity(request);

        user.setPassword(encoder.encode(user.getPassword()));

        User savedUser = repository.save(user);

        return UserMapper.toResponse(savedUser);
    }

    public UserResponse findById(UUID id) {
        User user = repository.findById(id).orElseThrow(() -> new CustomException(
                ErrorCode.USER_NOT_FOUND,
                ErrorCode.USER_NOT_FOUND.getStatus(),
                ErrorCode.USER_NOT_FOUND.getMessage()));

        return UserMapper.toResponse(user);
    }


}
