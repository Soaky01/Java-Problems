package com.mycompany.java_labs.example;

import java.io.*;
import java.util.GregorianCalendar;

public class Account implements Comparable<Account>, Storable{
    //accessability, type, attrName
    private String ownerName;
    private GregorianCalendar ownerBDay;
    private String IBAN;
    private double amount;
    private double credit;
    private GregorianCalendar creationDate;
    Bank myb;

    @Override
    public void store(String file) throws FileNotFoundException {
        //TODO
        FileOutputStream outputFile=new FileOutputStream(file);
        //FileOutputStream outputFile=new FileOutputStream("info.txt", true); // to append at the end of the file
        OutputStreamWriter outputStream=new OutputStreamWriter(outputFile);
        PrintWriter pw=new PrintWriter(outputStream);
        pw.println("My obj " +this.toString());
        pw.close();
    }

    @Override
    public void read(String file) throws IOException {
        //TODO
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(file);
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
    public int compareTo(Account o) {
        //TODO
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        //this optimization is usually worthwhile, and can
        //always be added
        if ( this == o )
            return EQUAL;
        //ATTRIBUTES based on which you do the comparison
        if(this.getIBAN().compareTo(o.getIBAN())!=EQUAL)
            return this.getIBAN().compareTo(o.getIBAN());
        //IBAN are equal
        if (this.getAmount() < o.getAmount())
            return BEFORE;
        if (this.getAmount() > o.getAmount())
            return AFTER;
        return EQUAL;
    }

    static class Bank { //NESTED CLASS
        private String name;
        private double capital;

        public Bank(String n, double c){
            this.name = n;
            this.capital = c;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getCapital() {
            return capital;
        }

        public void setCapital(double capital) {
            this.capital = capital;
        }

        @Override
        public String toString() {
            return "Bank{" +
                    "name='" + name + '\'' +
                    ", capital=" + capital +
                    '}';
        }
    }

    public Account(String on, GregorianCalendar obd, String iban, double a, double c, GregorianCalendar cd){
        this.ownerName = on;
        this.ownerBDay = obd;
        this.IBAN = iban;
        this.amount = a;
        this.credit = c;
        this.creationDate = cd;
    }

    // GET
    // public returnType getParam(EMPTY)
    public String getOwnerName(){
        return ownerName;
    }

    //SET
    //public void setParam (params)

    public void setOwnerName(String newOwnerName){
        this.ownerName = newOwnerName;
    }

    public GregorianCalendar getOwnerBDay() {
        return ownerBDay;
    }

    public void setOwnerBDay(GregorianCalendar ownerBDay) {
        this.ownerBDay = ownerBDay;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(GregorianCalendar creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ownerName='" + ownerName + '\'' +
//                ", ownerBDay=" + ownerBDay +
                ", IBAN='" + IBAN + '\'' +
                ", amount=" + amount +
                ", credit=" + credit +
//                ", creationDate=" + creationDate +
                ", myb=" + myb +
                '}';
    }

    public static void main(String[] args){
        Bank b = new Bank("BCR", 1000000);
        Account a = new Account("Ionel Popescu", new GregorianCalendar(1990,4,10), "RO123143", 2000, 1000, new GregorianCalendar(2020,1,20));
        a.myb = b;
        System.out.println(a.toString());
    }
}