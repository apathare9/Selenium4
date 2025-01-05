package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utility.BrowserDriver.driver;

public class WebDriverHelper {

    public static void clickOnElement(String locator, String statement) throws Exception {
        try {
            WebElement webElement = driver.findElement(By.xpath(DatabaseConnection.getLocatorReference(locator)));
            webElement.click();
            String value = DatabaseConnection.getLocatorReference(locator);
            Reporter.addStepLog(statement);
            System.out.println("----------" + value + "----------");
//            ExtentCucumberAdapter.addTestStepLog(statement);
            LoggerHandler.info(statement);
        } catch (Exception e) {
            LoggerHandler.error(statement + "is failed");
            e.printStackTrace();
        }

    }

}
