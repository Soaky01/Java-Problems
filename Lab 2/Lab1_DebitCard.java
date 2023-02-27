package com.mycompany.java_labs.example;

import java.io.*;

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


    @Override
    public void store(String file) throws FileNotFoundException {
        //FileOutputStream outputFile=new FileOutputStream(file);
        FileOutputStream outputFile=new FileOutputStream(file, true); // to append at the end of the file
        OutputStreamWriter outputStream=new OutputStreamWriter(outputFile);
        PrintWriter pw=new PrintWriter(outputStream);
        pw.println(this.toString());
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
}
