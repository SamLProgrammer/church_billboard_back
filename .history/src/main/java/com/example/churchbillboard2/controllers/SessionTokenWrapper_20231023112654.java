package com.example.churchbillboard2.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionTokenWrapper {

    private String sessionToken;

    public SessionTokenWrapper(String sessionToken, String error) {
        this.sessionToken = sessionToken;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public boolean validateToken(String in_token) {
        return in_token.equals(sessionToken);
    }
}
