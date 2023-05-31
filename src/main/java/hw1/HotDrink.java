package hw1;

public abstract class HotDrink extends Product {

    private int volume;
    private int temp;

    public HotDrink(String name, double price, int volume, int temp) {
        super(name, price);
        this.volume = volume;
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "\nГорячий напиток: " + getKind() +
                "\nЦена: " + getPrice() + " руб." +
                "\nОбъем: " + getVolume() + " мл" +
                "\nТемпература: " + getTemp() + "℃";
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
