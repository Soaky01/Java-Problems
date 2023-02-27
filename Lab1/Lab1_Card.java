package com.mycompany.java_labs.example;

public abstract class Lab1_Card {

    // - = private
    // + = public
    // # = protected

    private String IBAN;
    private int ammount;

    public Lab1_Card(String IBAN, int ammount) {
        this.IBAN = IBAN;
        this.ammount = ammount;
    }

    // + withdraw ( sum : int) : void

    // you never write the logic behind an abstract method
    // inside the abstract class
    // !!!!
    public abstract void withdraw (int sum);

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
}
