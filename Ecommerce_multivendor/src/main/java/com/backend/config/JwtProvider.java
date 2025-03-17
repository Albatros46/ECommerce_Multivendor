package com.backend.config;

import io.jsonwebtoken.security.Keys;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;

public class JwtProvider {
    SecretKey key= Keys.hmacShaKeyFor(JWT_CONSTANT.SECRET_KEY.getBytes());
    public String generateToken(Authentication auth){

        Collation<? extends GrantedAuthority>
                return null;
    }
}
