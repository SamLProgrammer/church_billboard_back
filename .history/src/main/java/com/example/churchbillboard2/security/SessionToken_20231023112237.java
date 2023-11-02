package com.example.churchbillboard2.security;

import java.security.SecureRandom;
import java.util.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class SessionToken {

    private String sessionToken;
    private String error;


    public SessionToken(String error) {
        this.error = error;
        if(error == null) {
            initComponents();
        }
    }

    private void initComponents() {
        initToken();
    }

    private void initToken() {
        SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[128];
        random.nextBytes(randomBytes);
        sessionToken = Base64.getEncoder().encodeToString(randomBytes);
    }
    
    public boolean validateToken(String in_token) {
        return in_token.equals(sessionToken);
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getError() {
        return error;
    }
}
