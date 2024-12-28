package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utility.BrowserDriver;
import utility.Reporter;


public class Hooks extends BrowserDriver {

    public static ExtentReports extentReportsObj;
//    public static ExtentTest extentTestObj;
    BrowserDriver browserDriverObj = new BrowserDriver();

    @BeforeAll
    public static void report(){
//        extentReportsObj = Reporter.createReport("GoibiboReport");
    }
    @Before
    public void setUp(){
        openBrowser();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @AfterAll
    public static void flush(){
//        extentReportsObj.flush();
    }

}
