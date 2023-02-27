package OOP.Lab4;

import java.util.*;

public class Product {
    private String productName, description;
    private List<String> ingredients = new ArrayList<>();
    private GregorianCalendar expiryDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getProductName().equalsIgnoreCase(product.getProductName()) &&
                getDescription().equalsIgnoreCase(product.getDescription()) &&
                getIngredients().equals(product.getIngredients()) &&
                getExpiryDate().equals(product.getExpiryDate());
    }

    @Override
    public int hashCode() {
//        return Objects.hash(getProductName(), getDescription(), getIngredients(), getExpiryDate());
          return (int) Math.random() * 10;
    }

    public Product(String productName, String description, List<String> ingredients, GregorianCalendar expiryDate) {
        this.productName = productName;
        this.description = description;
        this.ingredients = ingredients;
        this.expiryDate = expiryDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public GregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(GregorianCalendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                ", expiryDate=" + expiryDate +
                '}';
    }

    public static void main(String args[]){
        HashSet<Product> productSet = new HashSet<>();
        List<String> ingP1 = new ArrayList<>();
        ingP1.add("Chocolate beans");
        ingP1.add("Sugar");
        Product p1 = new Product("Chocolate", "Delicious treat", ingP1, new GregorianCalendar(2023, 4, 20));
        Product p2 = new Product("Chocolate", "Delicious treat", ingP1, new GregorianCalendar(2023, 4, 20));
        Product p3 = new Product("Muffin", "Delicious muffin", ingP1, new GregorianCalendar(2022, 4, 20));
        productSet.add(p1);
        productSet.add(p2);
        productSet.add(p3);
        System.out.println(p1.equals(p2));

        System.out.println("The hash set has in total " + productSet.size() + " elements");

        if(productSet.contains(new Product("Vanilla Muffin", "Delicious muffin", ingP1, new GregorianCalendar(2022, 4, 20)))){
            System.out.println("We already have the delicious muffin!");
        }
        else
        {
            System.out.println("No happiness");
        }
    }
}
