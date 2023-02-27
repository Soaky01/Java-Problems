package OOP.Lab4;

import java.util.*;

public class Driver_Person {

    public static void main(String args[]){
        List<Person> persons = new ArrayList<>();
        Person p1 = new Person("Ionel Popescu", "1990426376889", new Address("Politehnica", 10, "Bucharest", "Romania"));
        Person p2 = new Person("Ionela Popescu", "2990426376881", new Address("Politehnica", 10, "Bucharest", "Romania"));
        Person p3 = new Person("Dragos Mihailescu", "1980426376889", new Address("Lalelelor", 12, "Bucharest", "Romania"));
        Person p4 = new Person("Madalina Miu", "2990521376882", new Address("Branduselor", 14, "Bucharest", "Romania"));
        Person p5 = new Person("Alexandru Mihai", "1990426376123", new Address("Eroilor", 16, "Bucharest", "Romania"));
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);

        // parsing a list from beginning to end
        Iterator itr = persons.iterator();
        while(itr.hasNext()){
            Person cPerson = (Person) itr.next();
            System.out.println(cPerson);
        }

        System.out.println("************");

        ListIterator<Person> litr = null;
        litr = persons.listIterator();

        // parsing through the elements using a forward direction
        // from beginning until the end

        while(litr.hasNext()){
            Person cPerson = (Person) litr.next();
            System.out.println(cPerson);
        }
        System.out.println("\nList elements from back to front");
        // from back to front
        while(litr.hasPrevious()){
            Person cPerson = (Person) litr.previous();
            System.out.println(cPerson);
        }

        System.out.println("Previous element: " + litr.previousIndex());
        System.out.println("Last element: " + litr.nextIndex());

        litr.next();
        litr.add(new Person("Liliana Popescu", "29904263762319", new Address("Politehnica", 10, "Bucharest", "Romania")));

        litr.next();
        litr.remove();
        litr.next();
        litr.set(p2);

        itr = persons.iterator();
        while(itr.hasNext()){
            Person cPerson = (Person) itr.next();
            System.out.println(cPerson);
        }

        System.out.println(p1.compareTo(p2));

    }
}
