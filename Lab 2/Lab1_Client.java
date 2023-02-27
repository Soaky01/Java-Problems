package com.mycompany.java_labs.example;

import java.io.*;
import java.util.*;


public class Lab1_Client implements Comparable<Lab1_Client>, Storable {
    private String name;
    private GregorianCalendar bday;
    private String CNP;
    private C_Address a;
    private int maxSize = 10;
    private List<Lab1_Card> cards = new ArrayList<>();


    static class C_Address {
        private String city;
        private int number;
        private String street;

        public C_Address(String city, int number, String street) {
            this.city = city;
            this.number = number;
            this.street = street;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }

    @Override
    public void store(String file) throws FileNotFoundException {
        FileOutputStream outputFile=new FileOutputStream("info.txt");
        //FileOutputStream outputFile=new FileOutputStream("info.txt", true); // to append at the end of the file
        OutputStreamWriter outputStream=new OutputStreamWriter(outputFile);
        PrintWriter pw=new PrintWriter(outputStream);
        pw.println(this.toString());
        pw.close();
    }

    @Override
    public void read(String file) throws IOException {
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream("info.txt");
            InputStreamReader reader = new InputStreamReader(inputFile);
            BufferedReader br = new BufferedReader(reader);
            String sCurrentLine = "";
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int compareTo(Lab1_Client o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        //this optimization is usually worthwhile, and can
        //always be added
        if ( this == o )
            return EQUAL;
        if(CNP.compareTo(o.getCNP())!=EQUAL)
            return CNP.compareTo(o.getCNP());
        //CNP are equal
        //primitive numbers follow this form
        if (this.cards.size() < o.getCards().size())
            return BEFORE;
        if (this.cards.size() > o.getCards().size())
            return AFTER;
        return EQUAL;
    }

    @Override
    public String toString() {
        return "Lab1_Client{" +
                "name='" + name + '\'' +
                ", bday=" + bday +
                ", CNP='" + CNP + '\'' +
                ", a=" + a +
                ", maxSize=" + maxSize +
                ", cards=" + cards +
                '}';
    }

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
        C_Address a = new C_Address("Bucharest",10,"Politehnica");
        Lab1_DebitCard dc = new Lab1_DebitCard("RO182828", 1000);
        Lab1_DebitCard dc2 = new Lab1_DebitCard("RO182830", 1000);
        Lab1_CreditCard cc = new Lab1_CreditCard("RO28282", 2000, 3000);
        Lab1_Client c = new Lab1_Client("Popescu", new GregorianCalendar(1998, 9, 9), "19809092020", a);
        Lab1_Client c2 = new Lab1_Client("Popescu", new GregorianCalendar(1998, 9, 9), "19809092020", a);
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
        try {
            dc.store("info.txt");
            try {
                dc.read("info.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c.compareTo(c2));
        System.out.println(dc.compareTo(dc2));


    }

    public Lab1_Client(String name, GregorianCalendar bday, String CNP) {
        this.name = name;
        this.bday = bday;
        this.CNP = CNP;
    }

    public Lab1_Client(String name, GregorianCalendar bday, String CNP, C_Address a) {
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

    public C_Address getA() {
        return a;
    }

    public void setA(C_Address a) {
        this.a = a;
    }

    public List<Lab1_Card> getCards() {
        return cards;
    }

    public void setCards(List<Lab1_Card> cards) {
        this.cards = cards;
    }


}
