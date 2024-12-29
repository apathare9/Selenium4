package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.ReporterConfigurable;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import stepDefinitions.Hooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

import static utility.BrowserDriver.driver;
import static utility.BrowserDriver.getDriver;

public class Reporter {




    public static String getBase64Screenshots() throws IOException {

        String base64StringOfScreenshot = "";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");

        String sDate = sdf.format(date);

        String screenshotdir = System.getProperty("user.dir") + "/folderName/" + "imageName" + sDate + ".png";
        File screenshotName = new File(screenshotdir);
        FileUtils.copyFile(src, screenshotName);

        byte[] fileContent = FileUtils.readFileToByteArray(screenshotName);
        base64StringOfScreenshot = "date:image/png;png;base64," + Base64.getEncoder().encodeToString(fileContent);

        return base64StringOfScreenshot;
    }

    public static void addStepLog(String statement) throws Exception {

        ExtentCucumberAdapter.addTestStepLog(statement);
        Reporter.takeScreenshot(Hooks.scenario, statement);

    }

    public static void takeScreenshot(Scenario scenario) throws Exception {
        final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);

        if (Hooks.scenario.isFailed()) {
            Hooks.scenario.attach(screenshot, "image/png", "");
            Hooks.scenario.attach("", "text/html", "");
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(Reporter.getBase64Screenshots());
        }

        else {
            Hooks.scenario.attach(screenshot, "image/png", "");
            Hooks.scenario.attach("", "text/html", "");
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(Reporter.getBase64Screenshots());
        }


    }

    public static void takeScreenshot(Scenario scenario, String statement) throws Exception {
        final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);

        if (Hooks.scenario.isFailed()) {
            Hooks.scenario.attach(screenshot, "image/png", statement);
            Hooks.scenario.attach(statement, "text/html", statement);
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(Reporter.getBase64Screenshots());
        }

        else {
            Hooks.scenario.attach(screenshot, "image/png", statement);
            Hooks.scenario.attach(statement, "text/html", statement);
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(Reporter.getBase64Screenshots());
        }


    }

}
