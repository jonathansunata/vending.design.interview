package com.example.vending.design.interview.exceptions;

public class SoldOutException extends RuntimeException {

    public SoldOutException(String message){
        super(message);
    }
}
