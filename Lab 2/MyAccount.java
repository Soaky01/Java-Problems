package com.mycompany.java_labs.example;

import java.io.*;
import java.util.GregorianCalendar;

public class MyAccount implements Comparable<MyAccount>, Storable {
    // - ownerName : String
    private String ownerName;
    private GregorianCalendar ownerBDay;
    private String IBAN;
    private double amount;
    private double credit;
    private GregorianCalendar creationDate;

    Bank b;

    public MyAccount(String on, GregorianCalendar obday, String iban, double a, double c, GregorianCalendar cd){
        this.ownerName = on;
        this.ownerBDay = obday;
        this.IBAN = iban;
        this.amount = a;
        this.credit = c;
        this.creationDate = cd;
    }

    // GET
    // accessability + returnType + nameM (NO PARAMS)
    public String getOwnerName () {
        return ownerName;
    }

    // SET
    // accessability + void + setO (type v)
    public void setOwnerName(String on){
        this.ownerName = on;
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

    public Bank getB() {
        return b;
    }

    public void setB(Bank b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "MyAccount{" +
                "ownerName='" + ownerName + '\'' +
//                ", ownerBDay=" + ownerBDay +
                ", IBAN='" + IBAN + '\'' +
                ", amount=" + amount +
                ", credit=" + credit +
//                ", creationDate=" + creationDate +
                ", b=" + b +
                '}';
    }

    @Override
    public void store(String file) throws FileNotFoundException {
        FileOutputStream outputFile=new FileOutputStream(file);
        //FileOutputStream outputFile=new FileOutputStream("info.txt", true); // to append at the end of the file
        OutputStreamWriter outputStream=new OutputStreamWriter(outputFile);
        PrintWriter pw=new PrintWriter(outputStream);
        pw.println("My obj " +this.toString());
        pw.close();
    }

    @Override
    public void read(String file) throws IOException {
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
    public int compareTo(MyAccount o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        //this optimization is usually worthwhile, and can
        //always be added
        if ( this == o )
            return EQUAL;
        //ATTRIBUTES based on which you do the comparison
        if(this.b.getName().compareTo(o.getB().getName())!=EQUAL) {
            System.out.println("The banks are different");
            return this.b.getName().compareTo(o.getB().getName());
        }
        //Banks are equal
        if (this.getCreationDate().before(o.getCreationDate()))
            return BEFORE;
        if (this.getCreationDate().after(o.getCreationDate()))
            return AFTER;
        return EQUAL;
    }

    public static void main(String args[]) throws IOException {
        Bank b = new Bank("BCR", 10202030);
        Bank b2 = new Bank("ING", 10102030);
        //public MyAccount(String on, GregorianCalendar obday, String iban, double a, double c, GregorianCalendar cd){
        MyAccount c1 = new MyAccount("Ionel Popescu", new GregorianCalendar(1990, 1, 20),
                "RO202020", 2000, 1000, new GregorianCalendar(2020, 1, 20));
        c1.setB(b);
        MyAccount c2 = new MyAccount("Ionel Popescu", new GregorianCalendar(1990, 1, 20),
                "RO202020", 1000, 2000, new GregorianCalendar(2020, 1, 23));
        c2.setB(b);
        c1.store("input2.txt");
        c1.read("input2.txt");
        System.out.println(c1.compareTo(c2));
    }

    static class Bank{ // NESTED CLASS
        private String name;
        private double capital;

        public Bank(String name, double capital) {
            this.name = name;
            this.capital = capital;
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
}

