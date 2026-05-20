package java_learning.rest_api.controller;

import jakarta.validation.Valid;
import java_learning.rest_api.domain.user.UserRequest;
import java_learning.rest_api.domain.user.UserResponse;
import java_learning.rest_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest request) {

        UserResponse response = service.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable UUID id){
        return ResponseEntity.ok(service.findById(id));
    }


}
