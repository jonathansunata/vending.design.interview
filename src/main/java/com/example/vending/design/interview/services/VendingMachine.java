package com.example.vending.design.interview.services;

import com.example.vending.design.interview.enums.Coin;
import com.example.vending.design.interview.enums.Item;
import com.example.vending.design.interview.others.Bucket;

import java.util.List;

public interface VendingMachine {
    long selectItemAndGetPrice(Item item);
    void insertCoin(Coin coin);
    List<Coin> refund();
    Bucket<Item, List<Coin>> collectItemAndChange();
    void reset();
}
