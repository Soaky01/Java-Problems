package OOP.Lab5;

import java.util.*;

public class L5_Driver {
    public static void main(String args[]){
        ArrayList<L5_Employee> empList = new ArrayList<>();
        empList.add(new L5_Employee("Ionel", "1980425463768", 1300));
        empList.add(new L5_Employee("Ionela", "2980425463762", 1400));
        empList.add(new L5_Employee("Ana", "2990425463123", 1500));
        empList.add(new L5_Employee("Mihai", "1980427413768", 1450));
        empList.add(new L5_Employee("Ionel", "1980425463768", 1300));

        Map<String, L5_Employee> eMap = new HashMap<>();
        for(L5_Employee e : empList){
            eMap.put(e.getCNP(), e);
        }
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the searched CNP: ");
        String cnp = s.next();
        if(eMap.containsKey(cnp))
            System.out.println(eMap.get(cnp).toString());
        else
            System.out.println("There is no such person!");

        for(Map.Entry<String, L5_Employee> e : eMap.entrySet()){
            System.out.println("<K, V>: <" + e.getKey() +", " + e.getValue() +">");
        }
    }
}
