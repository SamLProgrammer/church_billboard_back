package com.example.churchbillboard2.controllers;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("Session")
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
