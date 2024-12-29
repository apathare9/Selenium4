package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
//import com.aventstack.extentreports.reporter.ReporterConfigurable;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.PropertyFileReader;
import utility.Reporter;

import java.io.IOException;
import java.util.Properties;

public class HomePage {

    WebDriver driver = Hooks.driver;

    @Given("User navigates to the Online products page")
    public void user_navigates_to_the_online_products_page() throws Exception {
        Reporter.addStepLog("Test1");
        System.out.println("Works...");

    }
    @When("User clicks on Formal Shoes drop down")
    public void user_clicks_on_formal_shoes_drop_down() throws Exception {

        Properties properties = PropertyFileReader.loadProperties();
        String val = properties.getProperty("browser");
        driver.findElement(By.xpath("ddd")).click();
//        ExtentCucumberAdapter.addTestStepLog("TEst 2");
        Reporter.addStepLog("Test2");
        System.out.println(val + "-----");
        System.out.println("Works2...");
    }
    @Then("User should be able to view the Products")
    public void user_should_be_able_to_view_the_products() throws Exception {
//        ExtentCucumberAdapter.addTestStepLog("TEst 2");
        Reporter.addStepLog("Test3");
//        ExtentCucumberAdapter.addTestStepScreenCaptureFromPath();
        System.out.println("Works3...");
    }


}
