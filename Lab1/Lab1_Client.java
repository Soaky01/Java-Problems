package com.mycompany.java_labs.example;

import java.util.*;


public class Lab1_Client {
    private String name;
    private GregorianCalendar bday;
    private String CNP;
    private Lab1_Address a;
    private int maxSize = 10;
    private List<Lab1_Card> cards = new ArrayList<>();

    // + addCard (c : Card) : boolean
    //accessability (public/private) returnType methodName (params)
    public boolean addCard(Lab1_Card c){
//        this.cards.add(c);
//        return true;
        if(this.cards.size() < this.maxSize){
            this.cards.add(c);
            return true;
        }
        else
            return false;
    }

    // + removeCard(iban: String) : Card

    public Lab1_Card removeCard(String iban){
        Lab1_Card c = null;
        for(Lab1_Card cc : cards){
            //always compare String with the method equalsIgnoreCase
            if(cc.getIBAN().equalsIgnoreCase(iban)) {
                c = cc;
                this.cards.remove(cc);
                System.out.println("The card was successfully removed!");
            }
        }
        return c;
    }

    public static void main(String args[]){
        Lab1_Address a = new Lab1_Address("Bucharest",10,"Politehnica");
        Lab1_DebitCard dc = new Lab1_DebitCard("RO182828", 1000);
        Lab1_CreditCard cc = new Lab1_CreditCard("RO28282", 2000, 3000);
        Lab1_Client c = new Lab1_Client("Popescu", new GregorianCalendar(1998, 9, 9), "19809092020", a);
        c.setA(a);
        c.cards.add(dc);
        c.cards.add(cc);
        System.out.println(c.getName());
        dc.withdraw(2000);
        for(Lab1_Card ccc : c.cards){
            System.out.println(ccc.getIBAN());
        }
        c.removeCard("RO182828");
        for(Lab1_Card ccc : c.cards){
            System.out.println(ccc.getIBAN());
        }


    }

    public Lab1_Client(String name, GregorianCalendar bday, String CNP) {
        this.name = name;
        this.bday = bday;
        this.CNP = CNP;
    }

    public Lab1_Client(String name, GregorianCalendar bday, String CNP, Lab1_Address a) {
        this.name = name;
        this.bday = bday;
        this.CNP = CNP;
        this.a = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getBday() {
        return bday;
    }

    public void setBday(GregorianCalendar bday) {
        this.bday = bday;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public Lab1_Address getA() {
        return a;
    }

    public void setA(Lab1_Address a) {
        this.a = a;
    }

    public List<Lab1_Card> getCards() {
        return cards;
    }

    public void setCards(List<Lab1_Card> cards) {
        this.cards = cards;
    }
}
