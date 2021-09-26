package com.example.vending.design.interview.services;

public class VendingMachineFactory {

    private VendingMachineFactory(){

    }

    public static VendingMachine getVendingMachine(){
        return new VendingMachineImpl();
    }
}
