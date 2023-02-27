package com.mycompany.java_labs.example;

public class Lab1_DebitCard extends Lab1_Card{
    public Lab1_DebitCard(String IBAN, int ammount) {
        super(IBAN, ammount);
    }

    @Override
    public void withdraw(int sum) {
        if(this.getAmmount() >= sum){

            //sout
            System.out.println("Operation was done successfully");
            this.setAmmount(this.getAmmount() - sum);
        }
        else
            System.out.println("Not enough funding!");
    }
}
