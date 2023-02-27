package com.mycompany.java_labs.example;

import java.io.*;

public class Lab1_CreditCard extends Lab1_Card{

    private int maxCredit;

    public Lab1_CreditCard(String IBAN, int ammount, int maxCredit) {
        super(IBAN, ammount);
        this.maxCredit = maxCredit;
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
    public int compareTo(Lab1_Card o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        //this optimization is usually worthwhile, and can
        //always be added
        if ( this == o )
            return EQUAL;
        //you can compare based on IBAN, amount and maxCredit
        if(super.getIBAN().compareTo(o.getIBAN())!=EQUAL)
            return super.getIBAN().compareTo(o.getIBAN());
        //IBAN are equal
        //primitive numbers follow this form
        if (super.getAmmount() < o.getAmmount())
            return BEFORE;
        if (super.getAmmount() > o.getAmmount())
            return AFTER;
        return EQUAL;

    }

    @Override
    public String toString() {
        return "Lab1_CreditCard{" +
                "maxCredit=" + maxCredit + ", IBAN " + super.getIBAN() +
                '}';
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
