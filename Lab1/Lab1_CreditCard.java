package com.mycompany.java_labs.example;

public class Lab1_CreditCard extends Lab1_Card{

    private int maxCredit;

    public Lab1_CreditCard(String IBAN, int ammount, int maxCredit) {
        super(IBAN, ammount);
        this.maxCredit = maxCredit;
    }

    @Override
    public void withdraw(int sum) {
        if(this.getAmmount() + sum <= maxCredit){
            this.setAmmount(this.getAmmount() + sum);
            System.out.println("Operation was done successfully!");
        }
        else
            System.out.println("The maximum threshold of " +
                    this.maxCredit + " was exceeded");
    }
}
