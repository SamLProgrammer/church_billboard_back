package com.example.churchbillboard2.services;

public class InsertResult {
    private boolean success;
    private String message;

    public InsertResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public InsertResult() {
        
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
