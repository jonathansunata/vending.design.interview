package com.example.vending.design.interview.others;


import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {

    private Map<T, Integer> inventory;

    public Inventory(){
        inventory = new HashMap<>();
    }

    public Integer getQuantity(T item){
        Integer quantity = inventory.get(item);
        return quantity == null ? 0 : quantity;
    }

    public void addItem(T item){
        int value = this.getQuantity(item);
        inventory.put(item, value + 1);
    }

    public void deduct(T item){
        if(this.hasItem(item)){
            int value = this.getQuantity(item);
            inventory.put(item, value - 1);
        }
    }

    public boolean hasItem(T item){
        return this.getQuantity(item) > 0;
    }

    public void put(T item, Integer quantity){
        inventory.put(item, quantity);
    }
}
