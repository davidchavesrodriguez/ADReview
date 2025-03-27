package gal.david.review.singleton.singletonproperties;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoadProperties {
    private static volatile LoadProperties instance;
    Properties properties;
    public static final String FILE = "src/main/resources/properties.properties";

    // Constructor privado
    private LoadProperties() throws IOException {
        properties = new Properties();
        try (var bufferReader = new BufferedReader(new FileReader(FILE))) {
            properties.load(bufferReader);
        }
    }

    // Singleton
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

    // Crear mapa de propiedades
    public Map<String, String> getProperty(String key) throws IOException {
        Map<String, String> map = new HashMap<>();
        String value = properties.getProperty(key);
        map.put(key, value);
        return map;
    }

}
