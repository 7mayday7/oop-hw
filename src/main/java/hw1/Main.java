package hw1;

public class Main {
    public static void main(String[] args) {

        Vending hotDrinksVending = new HotDrinksVending();

        HotDrink hotTeaSmall = new HotTea("Richard", 100, 200, 50);
        HotDrink hotCoffeeMedium = new HotCoffee("Bushido", 150, 300, 80);
        HotDrink hotChocolateLarge = new HotChocolate("Cacao", 250, 350, 70);

        hotDrinksVending.addProduct(hotTeaSmall);
        hotDrinksVending.addProduct(hotCoffeeMedium);
        hotDrinksVending.addProduct(hotChocolateLarge);

        System.out.println(hotDrinksVending.getProduct("Bushido"));
        System.out.println(hotDrinksVending.getProduct("Cacao", 350, 70));
    }
}
