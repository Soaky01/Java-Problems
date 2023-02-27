package com.mycompany.java_labs.example;

public class OfficeProduct extends SoftwareProduct{
    public OfficeProduct(String n, String p) {
        super(n, p);
    }

    @Override
    public boolean checkCompatibility() {
        if(this.getPlatform().equalsIgnoreCase("Linux"))
            return true;
        return false;
    }
}
