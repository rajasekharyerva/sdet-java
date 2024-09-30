package utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;
    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);



    // Constructor to load the properties file
    public ConfigReader() {
        properties = new Properties();
        try {
            // Load the properties file from the specified path
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("An exception occurred: ", e); // Log the exception with stack trace
        }
    }

    // Method to get a value based on a key
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

