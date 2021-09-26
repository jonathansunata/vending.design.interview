package com.example.vending.design.interview.bootstrap;

import com.example.vending.design.interview.enums.Coin;
import com.example.vending.design.interview.enums.Item;
import com.example.vending.design.interview.exceptions.CoinNotFoundException;
import com.example.vending.design.interview.services.VendingMachine;
import com.example.vending.design.interview.services.VendingMachineFactory;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

public class InitializeData{

    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachineFactory.getVendingMachine();
        vendingMachine.selectItemAndGetPrice(Item.SODA);
        vendingMachine.insertCoin(Coin.DIME);//10
        vendingMachine.insertCoin(Coin.DIME);//20
        vendingMachine.insertCoin(Coin.DIME);//30
        vendingMachine.insertCoin(Coin.DIME);//40
        vendingMachine.insertCoin(Coin.DIME);//50
        var itemAndChange = vendingMachine.collectItemAndChange();
        System.out.println("Item " + itemAndChange.getItem1().getName() + " and Change " +
                listOfCoin(itemAndChange.getItem2()));
    }

    private static String getCoinDescription(Coin coin){
        if(Coin.PENNY.equals(coin)){
            return "PENNY(1)";
        }
        else if(Coin.NICKLE.equals(coin)){
            return "NICKLE(5)";
        }
        else if(Coin.DIME.equals(coin)){
            return "DIME(10)";
        }
        else if(Coin.QUARTER.equals(coin)){
            return "QUARTER(25)";
        }
        else{
            throw new CoinNotFoundException("Doesn't have this type of coin");
        }
    }

    private static String listOfCoin(List<Coin> coins){
        StringBuilder sb = new StringBuilder();
        for(Coin coin : coins){
            sb.append(getCoinDescription(coin)).append(", ");
        }
        return sb.toString();
    }
}
