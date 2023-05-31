package hw1;

import java.util.ArrayList;
import java.util.List;

public class HotDrinksVending implements Vending {
    private final List<HotDrink> list;

    public HotDrinksVending() {
        list = new ArrayList<>();
    }


    public void addProduct(Product product) {
        list.add((HotDrink) product);
    }

    public Product getProduct(String name) {
        for (Product product : list) {
            if (name.equals(product.getKind())){
                return product;
            }
        }
        return null;
    }

    public HotDrink getProduct(String name, Integer volume, Integer temp) {
        for (HotDrink product : list) {
            if (name.equals(product.getKind())
                    && volume.equals(product.getVolume())
                    && temp.equals(product.getTemp()) ){
                return product;
            }
        }
        return null;
    }
}
