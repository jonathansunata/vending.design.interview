package com.example.vending.design.interview.services;

import com.example.vending.design.interview.enums.Coin;
import com.example.vending.design.interview.enums.Item;
import com.example.vending.design.interview.exceptions.NotFullPaidException;
import com.example.vending.design.interview.exceptions.NotSufficientChangeException;
import com.example.vending.design.interview.exceptions.SoldOutException;
import com.example.vending.design.interview.others.Bucket;
import com.example.vending.design.interview.others.Inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {

    private Inventory<Item> itemInventory = new Inventory<>();
    private Inventory<Coin> coinInventory = new Inventory<>();
    private Item currentItem;
    private long currentBalance;


    public VendingMachineImpl(){
        this.initialize();
    }

    private void initialize(){
        for(Item item : Item.values()){
            itemInventory.put(item, 5);
        }
        for(Coin coin : Coin.values()){
            coinInventory.put(coin, 5);
        }
    }

    @Override
    public long selectItemAndGetPrice(Item item) {
        if(itemInventory.hasItem(item)){
            this.currentItem = item;
            return this.currentItem.getPrice();
        }
        throw new SoldOutException("item " + item.getName() + " already sold out!");
    }

    @Override
    public void insertCoin(Coin coin) {
            this.currentBalance = this.currentBalance + coin.getValue();
            coinInventory.addItem(coin);
    }

    @Override
    public List<Coin> refund() {
        List<Coin> change = this.getChange(this.currentBalance);
        this.currentBalance = 0;
        this.currentItem = null;
        return change;
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        List<Coin> changes = this.collectChange();

        return new Bucket<>(item, changes);
    }

    private Item collectItem(){
        if(isFullPaid()){
            itemInventory.deduct(this.currentItem);
            return this.currentItem;
        }
        throw new NotFullPaidException("Current balance not sufficient for this item");
    }

    private boolean isFullPaid(){
        return this.currentBalance >= this.currentItem.getPrice();
    }

    private List<Coin> collectChange(){
        long changeAmount = this.currentBalance - this.currentItem.getPrice();
        List<Coin> change = this.getChange(changeAmount);

        this.currentBalance = 0;
        this.currentItem = null;
        return change;
    }

    private List<Coin> getChange(long amount){
        List<Coin> change = new ArrayList<>();

        if(amount > 0){
            long balance = amount;

            while(balance > 0){
                if(balance >= Coin.QUARTER.getValue() && coinInventory.hasItem(Coin.QUARTER)){
                    change.add(Coin.QUARTER);
                    balance -= Coin.QUARTER.getValue();
                    continue;
                }
                else if(balance >= Coin.DIME.getValue() && coinInventory.hasItem(Coin.DIME)){
                    change.add(Coin.DIME);
                    balance -= Coin.DIME.getValue();
                    continue;
                }
                else if(balance >= Coin.NICKLE.getValue() && coinInventory.hasItem(Coin.NICKLE)){
                    change.add(Coin.NICKLE);
                    balance -= Coin.NICKLE.getValue();
                    continue;
                }
                else if(balance >= Coin.PENNY.getValue() && coinInventory.hasItem(Coin.PENNY)) {
                    change.add(Coin.PENNY);
                    balance -= Coin.PENNY.getValue();
                    continue;
                }
                else{
                    throw new NotSufficientChangeException("Coin not sufficient");
                }
            }
        }
        return change;
    }

    @Override
    public void reset() {

    }
}
