package com.example.vending.design.interview.exceptions;

public class NotSufficientChangeException extends RuntimeException {
    public NotSufficientChangeException(String message){
        super(message);
    }
}
