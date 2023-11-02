package com.example.churchbillboard2.controllers;

public class SessionTokenWrapper {

    private String SessionToken;
    private String error;


    public SessionTokenWrapper(String SessionToken, String error) {
        this.SessionToken = SessionToken;
        this.error = error;
    }

    public String getError() {
        return error;
    }
    public String getSessionToken() {
        return SessionToken;
    }
    public void setError(String error) {
        this.error = error;
    }
    public void setSessionToken(String sessionToken) {
        SessionToken = sessionToken;
    }
    
}
