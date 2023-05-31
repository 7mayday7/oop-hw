package hw1;

public abstract class Product {
    private String kind;
    private double price;

    public Product(String kind, double price) {
        this.kind = kind;
        this.price = price;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
