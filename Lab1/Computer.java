package com.mycompany.java_labs.example;

public class Computer {
    private int RAM;
    private String processor;

    public Computer(int r, String p){
        this.RAM = r;
        this.processor = p;
    }

    // GET - return a type / object; there is no arg for the function
    // SET - always void (you store a value and you don't return anything)

    public int getRAM(){
        return RAM;
    }

    public void setRAM(int r){
        this.RAM = r;
    }

    public String getProcessor(){
        return processor;
    }

    public void setProcessor(String p){
        this.processor = p;
    }

}
