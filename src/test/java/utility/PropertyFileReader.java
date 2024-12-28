package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileReader {

    public static FileInputStream fileInputStream;
    public static Properties properties;
    public static String propertiesPath = System.getProperty("user.dir") +  "/config/config.properties";

    public static Properties loadProperties() {

        try {
            fileInputStream = new FileInputStream(propertiesPath);
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return properties;

    }

    public static String getReportConfigPath() {
        String reportConfigPath = System.getProperty("user.dir") + properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

}
