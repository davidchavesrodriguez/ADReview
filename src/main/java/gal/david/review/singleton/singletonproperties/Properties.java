package gal.david.review.singleton.singletonproperties;

import java.util.Map;

public class Properties {
    private static volatile Properties instance;

    private Properties() {
    }

    public static Properties getInstance() {
        if (instance == null) {
            synchronized (Properties.class) {
                if (instance == null) {
                    instance = new Properties();
                }
            }
        }
        return instance;
    }

    public Map<String, String> getProperty(String key) {

    }

}
