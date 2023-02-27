package OOP.Lab4;

import com.mycompany.java_labs.example.Account;

public class Person implements Comparable<Person> {
    private String name, CNP;
    private Address addr;

    public Person(String name, String CNP, Address addr) {
        this.name = name;
        this.CNP = CNP;
        this.addr = addr;
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

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", CNP='" + CNP + '\'' +
                ", addr=" + addr +
                '}';
    }


    @Override
    public int compareTo(Person o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        //this optimization is usually worthwhile, and can
        //always be added
        if ( this == o )
            return EQUAL;
        //ATTRIBUTES based on which you do the comparison
        if(this.getCNP().compareTo(o.getCNP())!=EQUAL)
            return this.getCNP().compareTo(o.getCNP());
        //CNP are equal
        if (this.getAddr().getNumber() < o.getAddr().getNumber())
            return BEFORE;
        if (this.getAddr().getNumber() > o.getAddr().getNumber())
            return AFTER;
        return EQUAL;
    }
}
