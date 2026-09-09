package mcacisi.Backend;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private ConfigManager(){}

    private static final Properties props = new Properties();


    static {

        try{
            InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("resources/config.properties");

            if(input == null){
                throw new RuntimeException("Configuration file not found.");
            }

            props.load(input);

        }catch(IOException ex){
            throw new RuntimeException("Failed to load configuration file: \n\n" + ex.getMessage());

        }

    }

    public static String getDbUrl() {
        return props.getProperty("db.url");
    }

    public static String getDbUsername() {
        return props.getProperty("db.username");
    }

    public static String getDbPassword() {
        return props.getProperty("db.password");
    }

    public static String getDbDriver() {
        return props.getProperty("db.driver");
    }

}
