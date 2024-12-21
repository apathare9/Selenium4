package stepdefinition;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utils.Base;
import utils.Reporter;

public class Hooks extends Base {

    public static ExtentReports extentReportsObj;
    public static ExtentTest extentTestObj;
    public static Base baseObj = new Base();

    @BeforeAll
    public static void createReport() {
        extentReportsObj = Reporter.createReport("Insight Reporting");
    }

    @Before
    public static void setUp() {
        baseObj.openBrowser();
    }
    
    @After
    public static void flushReport() {
        extentReportsObj.flush();
    }

    @AfterAll
    public static void quitBrowser()  {   
        driver.quit();
    }
    


}