package OOP.Lab5;

import java.util.*;

public class L5_TouristicPackage {
    private String name;
    private int id, price;
    private ArrayList<L5_Attraction> alist = new ArrayList<>();

    public L5_TouristicPackage(String name, int id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public void addAttraction(L5_Attraction a){
        this.alist.add(a);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<L5_Attraction> getAlist() {
        return alist;
    }

    public void setAlist(ArrayList<L5_Attraction> alist) {
        this.alist = alist;
    }

    @Override
    public String toString() {
        return "L5_TouristicPackage{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", alist=" + alist +
                '}';
    }
}
