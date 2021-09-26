package com.example.vending.design.interview.enums;

public enum Coin {
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25);

    private Integer value;
    Coin(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
