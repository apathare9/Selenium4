package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.*;

public class HomePage {

    WebDriver driver = Hooks.driver;

    @Given("User navigates to the Online products page")
    public void user_navigates_to_the_online_products_page() throws Exception {

        driver.navigate().refresh();
        Thread.sleep(3000);
        Screenshot.takeScreenshot();
        ExcelReader.readValuesFromExcel();
        int totalRowCount = ExcelReader.getTotalRowFromExcel("Data");
        int totalColumnCount = ExcelReader.getTotalColumnsFromExcel("Data");
        String cellData = ExcelReader.getCellDataFromExcel("Data", "Last Name", 2);

        System.out.println("------- Total Row Count : " + totalRowCount + " -------");
        System.out.println("------- Total Column Count : " + totalColumnCount + " -------");
        System.out.println("------- Cell Data : " + cellData + " -------");
        LoggerHandler.info("-------- logger working --------");
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//button[contains(text(),'Allow')]")).click();
        WebDriverHelper.clickOnElement(DatabaseConnection.getLocatorReference("PopupCloseButton"),  "Clicked on Pop Up Close Button");
        Reporter.addStepLog("Test1");
    }
    @When("User clicks on Formal Shoes drop down")
    public void user_clicks_on_formal_shoes_drop_down() throws Exception {
        Reporter.addStepLog("Test2");
        WebDriverHelper.clickOnElement(DatabaseConnection.getLocatorReference("sss"), "Get text test");

        driver.findElement(By.xpath("defef")).click();
    }
    @Then("User should be able to view the Products")
    public void user_should_be_able_to_view_the_products() throws Exception {
        Reporter.addStepLog("Test3");
    }

}
