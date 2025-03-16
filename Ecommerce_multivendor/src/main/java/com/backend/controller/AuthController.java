package com.backend.controller;

import com.backend.model.User;
import com.backend.repository.UserRepository;
import com.backend.response.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    @PostMapping("/signup")
    public ResponseEntity<User> createUserHandler(@RequestBody SignUpRequest request){
        User user=new User();
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        User savedUser=userRepository.save(user);

        return ResponseEntity.ok(savedUser);
    }
}
