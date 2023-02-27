package OOP.Lab4;

import java.util.Comparator;
import java.util.TreeSet;

public class Car {
    private String brand, description;
    private int maxEngineSpeed;

    public Car(String brand, String description, int maxEngineSpeed) {
        this.brand = brand;
        this.description = description;
        this.maxEngineSpeed = maxEngineSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxEngineSpeed() {
        return maxEngineSpeed;
    }

    public void setMaxEngineSpeed(int maxEngineSpeed) {
        this.maxEngineSpeed = maxEngineSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", maxEngineSpeed=" + maxEngineSpeed +
                '}';
    }

    static class CarComp implements Comparator<Car> {

        @Override
        public int compare(Car c1, Car c2) {
            return c1.getBrand().compareTo(c2.getBrand());
        }
    }

    public static void main(String args[]){
        TreeSet<Car> myCars = new TreeSet<>(new CarComp());
        myCars.add(new Car("Opel", "Corsa car 1.4", 250));
        myCars.add(new Car("Opel", "Corsa car 1.4", 250));
        myCars.add(new Car("BMW", "Series 5 car 1.4", 350));
        myCars.add(new Car("Mercedes", "Class 5 car 1.4", 350));
        for(Car c : myCars){
            System.out.println(c);
        }

    }
}
