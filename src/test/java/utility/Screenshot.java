package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;

import static utility.BrowserDriver.driver;


public class Screenshot {

    public static void takeScreenshot() throws IOException {

        String path = System.getProperty("user.dir") + "/SS/test.png";
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(path) );
    }
}
