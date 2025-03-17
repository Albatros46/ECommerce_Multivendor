package com.backend.service.interfaces;

import com.backend.response.SignUpRequest;

public interface AuthService {
    String createUser(SignUpRequest req);
}
