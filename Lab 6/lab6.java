mport java.util.ArrayList;

public class MedicalProducts {
	String name;
	ArrayList<String> indications = new ArrayList<>();
	ArrayList<String> contraIndications = new ArrayList<>();
	ArrayList<String> ingredients = new ArrayList<>();
	double price;

	public MedicalProducts(String name, ArrayList<String> indications, ArrayList<String> contraIndications,
			ArrayList<String> ingredients) {
		super();
		this.name = name;
		this.indications = indications;
		this.contraIndications = contraIndications;
		this.ingredients = ingredients;
	}

	public String toString(){
		return this.name+" "+this.price;
	}

}
Pharmacy.java

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pharmacy {

	ArrayList<MedicalProducts> medicines = new ArrayList<>();

	public Pharmacy(ArrayList<MedicalProducts> medicines) {
		super();
		this.medicines = medicines;
	}

	public boolean checkStock(MedicalProducts m){
		if(medicines.contains(m)){
			return true;
		}
		return false;
	}

	Map<String, Integer> toMap(){
		Map<String, Integer> ingredientsCount = new HashMap<String, Integer>();
		int val=0;
		for(MedicalProducts m : medicines){
			for(String s : m.ingredients){
			  if(ingredientsCount.containsKey(s)){
				  val=ingredientsCount.get(s)+1;
				 ingredientsCount.put(s,val);
			  }else{
				  ingredientsCount.put(s, 1);
			  }
			}
		}

		return ingredientsCount;

	}
}

TetsPharamacy.java

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class TetsPharamacy {

	public static void main(String[] args){
		ArrayList<String> indications =new ArrayList<>();
		indications.add("AA");
		indications.add("BB");
		indications.add("CC");
		ArrayList<String> contra_indications =new ArrayList<>();
		contra_indications.add("XX");
		contra_indications.add("YY");
		contra_indications.add("ZZ");
		ArrayList<String> ingredients = new ArrayList<>();
		ingredients.add("ing1");
		ingredients.add("ing2");
		ingredients.add("ing3");
		MedicalProducts mp1 = new MedicalProducts("prod1", indications, contra_indications, ingredients);
		MedicalProducts mp2 = new MedicalProducts("prod2", indications, contra_indications, ingredients);
		ArrayList<MedicalProducts> mp = new ArrayList<>();
		mp.add(mp1);
		mp.add(mp2);
		Pharmacy p = new Pharmacy(mp);
		System.out.println(mp1.name +" has stock : "+p.checkStock(mp1));
		Map<String, Integer> map1 = p.toMap();
		java.util.Iterator<Entry<String, Integer>> hmIterator = map1.entrySet().iterator();
		while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            int count = (int)mapElement.getValue();
            System.out.println(mapElement.getKey() + " : " + count);
        }
	}

}
