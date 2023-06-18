package hw5.Service.Randomizer;

import java.util.Random;

public class RndmPhoneNumber {
    public static String getPhoneNumber() {
        Random random = new Random();

        return String.format("%s-%s",
                random.nextInt(100, 1000),
                random.nextInt(1000, 10000)
        );
    }
}
