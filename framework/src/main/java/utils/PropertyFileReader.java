package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileReader {
    
    public static FileInputStream fileInputStreamObj;
    public static Properties propertiesObj;
    public static String propertiesPath = "./config/config.properties";

    public static Properties loadProperties() {

        try {
            fileInputStreamObj = new FileInputStream(propertiesPath);
            propertiesObj = new Properties();
            propertiesObj.load(fileInputStreamObj);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return propertiesObj;

    }



}
