package com.mycompany.java_labs.example;


// install java JRE
// install Java JDK
//https://www.jetbrains.com/idea/download/#section=windows
//install Intellij community
public class Lab1_Address {
    private String city;
    private int number;
    private String street;

    public Lab1_Address(String city, int number, String street) {
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
