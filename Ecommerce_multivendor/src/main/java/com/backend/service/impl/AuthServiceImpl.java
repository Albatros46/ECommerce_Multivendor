package com.backend.service.impl;

import com.backend.enums.USER_ROLE;
import com.backend.model.Cart;
import com.backend.model.User;
import com.backend.repository.CartRepository;
import com.backend.repository.UserRepository;
import com.backend.response.SignUpRequest;
import com.backend.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public String createUser(SignUpRequest req) {
        User user=userRepository.findByEmail(req.getEmail());
        if (user==null){
            User createdUser=new User();
            createdUser.setFullName(req.getFullName());
            createdUser.setEmail(req.getFullName());
            createdUser.setRole(USER_ROLE.ROLE_CUSTOMER);
            createdUser.setMobile("045656165");
            createdUser.setPassword(passwordEncoder.encode(req.getOtp()));
            user=userRepository.save(createdUser);

            Cart cart=new Cart();
            cart.setUser(user);
            cartRepository.save(cart);

        }
        return "";
    }
}
