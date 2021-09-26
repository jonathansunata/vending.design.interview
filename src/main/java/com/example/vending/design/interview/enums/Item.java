package com.example.vending.design.interview.enums;

public enum Item {
    COKE("Coke",25),
    PEPSI("Pepsi", 35),
    SODA("Soda", 45);

    private String name;
    private Integer price;
    Item(String name, Integer price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public Integer getPrice() {
        return price;
    }

}
