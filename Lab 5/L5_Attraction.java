package OOP.Lab5;

public class L5_Attraction {
    private String name;
    private String location;

    public L5_Attraction(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "L5_Attraction{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
