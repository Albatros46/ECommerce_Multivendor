package com.backend.response;

import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String fullName;
    private String otp;
    private String mobile;
    private String role;
    private String Otp;
    private String password;
}
