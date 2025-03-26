package gal.david.review.singleton.singletonproperties;

import java.io.IOException;

public class PropertiesMain {
    public static void main(String[] args) throws IOException {
        LoadProperties loadProperties = LoadProperties.getInstance();

        System.out.println(loadProperties.getProperty("url"));
        System.out.println(loadProperties.getProperty("driver"));
        System.out.println(loadProperties.getProperty("usuario"));
        System.out.println(loadProperties.getProperty("password"));    }
}
