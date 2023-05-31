package hw1;

public interface Vending {
    void addProduct(Product product);

    Product getProduct(String kind);

    Product getProduct(String kind, Integer volume, Integer temp);
}
