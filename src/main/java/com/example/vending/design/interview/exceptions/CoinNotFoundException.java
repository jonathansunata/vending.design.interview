package com.example.vending.design.interview.exceptions;

public class CoinNotFoundException extends RuntimeException {
    public CoinNotFoundException(String message){
        super(message);
    }
}
