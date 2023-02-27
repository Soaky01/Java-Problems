package OOP.Lab5;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class L5_Driver_TouristicPackage {
    public static void main(String args[]){
        L5_Attraction a1 = new L5_Attraction("Peles Castle", "Sinaia");
        L5_Attraction a2 = new L5_Attraction("Bran Castle", "Bran");
        L5_Attraction a3 = new L5_Attraction("Museum", "Sinaia");
        L5_Attraction a4 = new L5_Attraction("Monastery", "Sinaia");
        L5_Attraction a5 = new L5_Attraction("Stana Regala", "Sinaia");
        L5_Attraction a6 = new L5_Attraction("Pelisor Castle", "Sinaia");

        L5_TouristicPackage tp1 = new L5_TouristicPackage("Package 1", 1, 80);
        tp1.addAttraction(a1);
        tp1.addAttraction(a2);
        tp1.addAttraction(a3);
        tp1.addAttraction(a3);

        L5_TouristicPackage tp2 = new L5_TouristicPackage("Package 2", 2, 100);
        tp2.addAttraction(a1);
        tp2.addAttraction(a4);
        tp2.addAttraction(a5);
        tp2.addAttraction(a3);

        L5_TouristicPackage tp3 = new L5_TouristicPackage("Package 3", 3, 120);
        tp3.addAttraction(a5);
        tp3.addAttraction(a6);
        tp3.addAttraction(a1);
        tp3.addAttraction(a2);

        ArrayList<L5_TouristicPackage> tList = new ArrayList<>();
        tList.add(tp1);
        tList.add(tp2);
        tList.add(tp3);

        Map<L5_Attraction, Integer> boughtAtt = new HashMap<>();

        for(L5_TouristicPackage tp : tList){
            for(L5_Attraction a : tp.getAlist()){
                if(boughtAtt.containsKey(a)){
                    Integer temp = boughtAtt.get(a);
                    temp++;
                    boughtAtt.put(a, temp);
                }
                else{
                    boughtAtt.put(a, 1);
                }
            }
        }

        System.out.println("No of occurrences per attractions");

        for(Map.Entry<L5_Attraction, Integer> entry : boughtAtt.entrySet()){
            System.out.println("Attraction: " + entry.getKey().getName() + " has the frequency: " + entry.getValue());
        }

        //compute popularity per attraction (frequency / total)

        Map<L5_Attraction, Double> popMap = new HashMap<>();
        //total no of purchased attractions
        int total = 0;

        for(Map.Entry<L5_Attraction, Integer> e : boughtAtt.entrySet()){
            total += e.getValue();
        }
        System.out.println("No of attraction visits: " + total);

        //compute popularity

        for(Map.Entry<L5_Attraction, Integer> e : boughtAtt.entrySet()){
            if(popMap.containsKey(e.getKey())){
                Double temp = Double.valueOf(e.getValue());
                temp = temp / total;
                popMap.put(e.getKey(), temp);
            }
            else{
                Double temp = Double.valueOf(e.getValue());
                temp = temp/total;
                popMap.put(e.getKey(), temp);
            }
        }

        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);

        System.out.println("POPULARITY");
        for(Map.Entry<L5_Attraction, Double> e : popMap.entrySet()){
            System.out.println("Attraction " + e.getKey().getName() + " has popularity " +
                    df.format(e.getValue()));
        }
    }
}
