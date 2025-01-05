package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utility.BrowserDriver.driver;


public class Screenshot {

    public static void takeScreenshot() throws IOException {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
        String sDate = sdf.format(date);

        String path = System.getProperty("user.dir") + "/Screenshots/" + "Selenium4Cucumber" + sDate + ".png";
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(path) );

    }
}
