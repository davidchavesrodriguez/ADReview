package gal.david.review.singleton.singletonnumber;

import java.util.Random;

public class SingletonNumber {
    private final int generatedNumber;
    private static volatile SingletonNumber instance;

    private SingletonNumber() {
        Random random = new Random();
        generatedNumber = random.nextInt(100) + 1;
    }

    public static SingletonNumber getInstance() {
        if (instance == null) {
            synchronized (SingletonNumber.class) {
                if (instance == null) {
                    instance = new SingletonNumber();
                }
            }
        }
        return instance;
    }

    public int generateNumber() {
        return generatedNumber;
    }
}
