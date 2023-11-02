package com.example.churchbillboard2.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionTokenWrapper {

    private String SessionToken;

    public SessionTokenWrapper(String SessionToken, String error) {
        this.SessionToken = SessionToken;
    }

    public String getSessionToken() {
        return SessionToken;
    }

    public void setSessionToken(String sessionToken) {
        SessionToken = sessionToken;
    }
}
