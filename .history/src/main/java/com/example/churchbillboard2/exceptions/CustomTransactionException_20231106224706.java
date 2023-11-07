package com.example.churchbillboard2.exceptions;

public class CustomTransactionException extends RuntimeException {

    public CustomTransactionException(String message) {
        super(message);
    }
}