package hw2;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        market.update();

        Human human1 = new Human("Иванов Иван", 26, "Омск");
        Human human2 = new Human("Смирнов Сергей", 32, "Москва");
        Human human3 = new Human("Сидоров Александр", 30, "Санкт-Петербург");

        market.acceptToMarket(human1);
        market.acceptToMarket(human2);
        market.acceptToMarket(human3);

        market.update();

        human1.setMakeOrder();
        human2.setMakeOrder();
        human3.setMakeOrder();

        market.update();

        human1.setTakeOrder();

        market.update();

        market.update();
    }
}
