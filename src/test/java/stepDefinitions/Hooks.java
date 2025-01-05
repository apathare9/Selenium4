package stepDefinitions;


import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.*;
import utility.BrowserDriver;
import utility.Reporter;

public class Hooks extends BrowserDriver {

    Reporter reporter;
    public static Scenario scenario;

    @Before
    public void setUp(){
        openBrowser();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @BeforeStep()
    public void loggerHtml(Scenario scenario) {
        Hooks.scenario = scenario;
    }

    @AfterStep()
    public void captureScreenshot(Scenario scenario) throws Exception {
        if(Hooks.scenario.isFailed()) {
            ExtentCucumberAdapter.getCurrentScenario().fail("Test - Failed - " + scenario.getName() );
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(Reporter.getBase64Screenshots());
            ExtentCucumberAdapter.getCurrentScenario().log(Status.FAIL, scenario.getName());
            Reporter.takeScreenshot(scenario);
        }

    }

}