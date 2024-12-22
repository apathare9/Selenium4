package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserDriver {

    public static WebDriver driver;

    public static void openWebsite(String website) {
        driver = new ChromeDriver();
//        driver.get("https://www.ajinkyapathare.netlify.app");

        driver.get(website);
    }

}

