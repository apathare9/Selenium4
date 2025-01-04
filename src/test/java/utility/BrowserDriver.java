package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Properties;


public class BrowserDriver {

    public static WebDriver driver;

    Properties properties;

    public void openBrowser() {
        properties = PropertyFileReader.loadProperties();
        String browserName = properties.getProperty("browser");
        System.out.println(browserName);

        switch (browserName.toLowerCase()) {

            case "chrome" :
                driver = new ChromeDriver();
                break;

            case "edge" :
                driver = new EdgeDriver();
                break;

            case "firefox" :
                driver = new FirefoxDriver();
                break;

            case "safari" :
                driver = new SafariDriver();
                break;

        }

        if (driver != null) {
            driver.manage().window().maximize();
            driver.get(properties.getProperty("url"));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        }

    }

    public void closeBrowser() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return BrowserDriver.driver;
        }
        return driver;
    }

}

