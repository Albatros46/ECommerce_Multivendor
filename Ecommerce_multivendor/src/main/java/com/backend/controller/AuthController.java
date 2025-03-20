package com.backend.controller;

import com.backend.enums.USER_ROLE;
import com.backend.model.User;
import com.backend.repository.UserRepository;
import com.backend.response.AuthResponse;
import com.backend.response.SignUpRequest;
import com.backend.service.interfaces.AuthService;
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
    private final AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody SignUpRequest request){
//        User user=new User();
//        user.setEmail(request.getEmail());
//        user.setFullName(request.getFullName());
//        User savedUser=userRepository.save(user);
        String jwt=authService.createUser(request);
        AuthResponse response=new AuthResponse();
        response.setJwt(jwt);
        response.setMessage("Registration Successfully...");
        response.setRole(USER_ROLE.ROLE_CUSTOMER);
        return ResponseEntity.ok(response);
    }
}
