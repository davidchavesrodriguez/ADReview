package gal.david.review.singleton.singletonnumber;

public class SingletonNumberMain {
    public static void main(String[] args) {
        SingletonNumber number1 = SingletonNumber.getInstance();
        System.out.println("Number 1: " + number1.generateNumber());

        SingletonNumber number2 = SingletonNumber.getInstance();
        System.out.println("Number 2: " + number2.generateNumber());
    }
}
