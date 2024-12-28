package stepDefinitions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage_Implementation;
import utility.PropertyFileReader;
import utility.WebDriverHelper;

import java.util.Properties;

public class HomePage {

//    ExtentTest extentTestObj = Hooks.extentReportsObj.createTest("Title", "Description");
    WebDriver driver = Hooks.driver;
    HomePage_Implementation hpObj = new HomePage_Implementation();


    @Given("User navigates to the Online products page")
    public void user_navigates_to_the_online_products_page() {
        String website = "https://www.amazon.in";
//        openWebsite(website);

        ExtentCucumberAdapter.addTestStepLog("TEst 1");




        System.out.println("Works...");
    }
    @When("User clicks on Formal Shoes drop down")
    public void user_clicks_on_formal_shoes_drop_down() {

        Properties properties = PropertyFileReader.loadProperties();
        String val = properties.getProperty("browser");

//        Reporter.addStepLog("Test2");
        driver.findElement(By.xpath("ddd")).click();
        ExtentCucumberAdapter.addTestStepLog("TEst 2");
        System.out.println(val + "-----");
        System.out.println("Works2...");
    }



    @Then("User should be able to view the Products")
    public void user_should_be_able_to_view_the_products() {


//        Reporter.addStepLog("Test3 failes");

        ExtentCucumberAdapter.addTestStepLog("TEst 2");
        System.out.println("Works3...");
    }


}
