package gal.david.review.singleton.singletonproperties;

public class PropertiesMain {
    public static void main(String[] args) {
        Properties properties= Properties.getInstance();

        System.out.println(properties.getProperty("url"));
    }
}
