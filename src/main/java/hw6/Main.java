package hw6;

import hw6.Work3.Greeter;
import hw6.Work3.OfficialGreeting;
import hw6.Work1.Rectangle;
import hw6.Work1.Square;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(30);
        rectangle.setWidth(60);

        System.out.println("Прямоугольник:");
        System.out.println("------------");
        System.out.println("Высота: " + rectangle.getHeight());
        System.out.println("Ширина: " + rectangle.getWidth());
        System.out.println("------------");


        Square square = new Square();
        square.setSide(7);

        System.out.println("Квадрат:");
        System.out.println("--------");
        System.out.println("Сторона: " + square.getSide());
        System.out.println("--------");


        Greeter greeter = new Greeter();
        System.out.println(greeter.greet());
        greeter.setGreeting(new OfficialGreeting());
        System.out.println(greeter.greet());
    }
}