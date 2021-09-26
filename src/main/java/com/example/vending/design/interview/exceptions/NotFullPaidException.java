package com.example.vending.design.interview.exceptions;

public class NotFullPaidException extends RuntimeException {
    public NotFullPaidException(String message){
        super(message);
    }
}
