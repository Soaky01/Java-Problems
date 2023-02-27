package com.mycompany.java_labs.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Customer {

    private String username;
    private Computer c;
    private List<SoftwareProduct> sps = new ArrayList<>();

    public Customer(String username, Computer cc){
        this.username = username;
        this.c = cc;
    }

    // + addProduct (sp: SoftwareProduct) : void
    public void addProduct(SoftwareProduct sp){
        this.sps.add(sp);
    }

    // + removeProduct (name : String) : void

    public void removeProduct(String name){
        for(SoftwareProduct sp : sps){
            if(sp.getName().equalsIgnoreCase(name)) {
                this.sps.remove(sp);
                System.out.println("The software product was deleted successfully");
            }
            else
                System.out.println("The software product was not found");
        }
    }

    public static void main (String args[]){
        Computer c = new Computer(2, "i7");
        OfficeProduct op = new OfficeProduct("Office", "Windows");
        OfficeProduct op2 = new OfficeProduct("Libre", "Windows");

        try {
            op.store("input2.txt");
            op.read("input2.txt");
            System.out.println(op.compareTo(op2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameProduct sp = new GameProduct("Sims", "Xbox");
        GameProduct sp2 = new GameProduct("Worms", "Xbox");
//        try {
//            sp.store("input2.txt");
//            sp.read("input2.txt");
//            System.out.println(sp.compareTo(sp2));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Customer cust = new Customer("Poli", c);
        cust.addProduct(op);
        cust.addProduct(sp);
        for(SoftwareProduct softp : cust.sps){
            System.out.println(softp.getName() + ", " + softp.getPlatform());
        }
        cust.removeProduct("Office");
        for(SoftwareProduct softp : cust.sps){
            System.out.println(softp.getName() + ", " + softp.getPlatform());
        }

    }
}
