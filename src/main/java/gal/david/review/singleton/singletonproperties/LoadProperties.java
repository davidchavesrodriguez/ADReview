package gal.david.review.singleton.singletonproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoadProperties {
    private static volatile LoadProperties instance;
    Properties properties;

    private LoadProperties() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/properties.properties"));
    }

    public static LoadProperties getInstance() throws IOException {
        if (instance == null) {
            synchronized (LoadProperties.class) {
                if (instance == null) {
                    instance = new LoadProperties();
                }
            }
        }
        return instance;
    }

    public Map<String, String> getProperty(String key) throws IOException {
        Map <String, String> map = new HashMap<>();
        String value= properties.getProperty(key);
        map.put(key, value);
        return map;
    }

}
