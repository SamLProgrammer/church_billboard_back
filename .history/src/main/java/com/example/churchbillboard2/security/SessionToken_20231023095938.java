package com.example.churchbillboard2.security;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class SessionToken {

    private String sessionToken;

    public SessionToken() {
        SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[128];
        random.nextBytes(randomBytes);
        sessionToken = Base64.getEncoder().encodeToString(randomBytes);
    }
}
