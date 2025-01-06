package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utility.BrowserDriver.driver;

public class WebDriverHelper {

    public static void clickOnElement(String locator, String statement) throws Throwable {
        try {
            WebElement webElement = driver.findElement(By.xpath(DatabaseConnection.getLocatorName(locator)));
            webElement.click();
            String value = DatabaseConnection.getLocatorName(locator);
            Reporter.addStepLog(statement);
            System.out.println("----------" + value + "----------");
            LoggerHandler.info(statement);
        }
        catch (Throwable e) {
            Reporter.addStepLog(statement + " is failed");
            LoggerHandler.error(statement + " is failed");
            e.printStackTrace();
            throw e;
        }

    }



}
