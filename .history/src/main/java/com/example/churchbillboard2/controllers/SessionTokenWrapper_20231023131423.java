package com.example.churchbillboard2.controllers;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionTokenWrapper implements Serializable{

    private String sessionToken;

    public SessionTokenWrapper(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public SessionTokenWrapper() {

    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public boolean validateToken(String in_token) {
        return sessionToken != null && in_token.equals(sessionToken);
    }
}
