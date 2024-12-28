package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {

    public static ExtentReports report;
    public static ExtentSparkReporter spark;

    public static ExtentReports createReport(String reportName) {

        try {

            String pathOfReport = System.getProperty("user.dir") + "/ExecutionReports/" + reportName + ".html";

            report = new ExtentReports();
            spark = new ExtentSparkReporter(pathOfReport);
            report.attachReporter(spark);

            return report;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

}
