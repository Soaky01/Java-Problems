package OOP.Lab5;

public class L5_Employee {
    private String name;
    private String CNP;
    private int salary;

    public L5_Employee(String name, String CNP, int salary) {
        this.name = name;
        this.CNP = CNP;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "L5_Employee{" +
                "name='" + name + '\'' +
                ", CNP='" + CNP + '\'' +
                ", salary=" + salary +
                '}';
    }
}
