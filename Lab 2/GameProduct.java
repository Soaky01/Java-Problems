package com.mycompany.java_labs.example;

import java.io.*;

public class GameProduct extends SoftwareProduct{
    public GameProduct(String n, String p) {
        super(n, p);
    }

    @Override
    public boolean checkCompatibility() {
        if(this.getPlatform().equalsIgnoreCase("Xbox"))
            return true;
        return false;
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
    public int compareTo(SoftwareProduct o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        //this optimization is usually worthwhile, and can
        //always be added
        if ( this == o )
            return EQUAL;
        //name, platform
        if(super.getPlatform().compareTo(o.getPlatform())!=EQUAL)
            return super.getPlatform().compareTo(o.getPlatform());
        //platform are equal
        if (this.getName().length() < o.getName().length())
            return BEFORE;
        if (this.getName().length() > o.getName().length())
            return AFTER;
        return EQUAL;
    }

    public String toString() {
        return "Game Product{" +
                "name='" + super.getName() + '\'' +
                ", platform='" + super.getPlatform() + '\'' +
                '}';
    }
}
