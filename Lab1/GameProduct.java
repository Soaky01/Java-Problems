package com.mycompany.java_labs.example;

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
}
