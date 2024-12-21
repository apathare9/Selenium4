package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {

    public static ExtentReports extentReportObj;
    public static ExtentSparkReporter extentSparkReporterObj;

    public static ExtentReports createReport(String reportName) {

        try {
            String path = System.getProperty("user.dir") + "/ExecutionReports/" + reportName;
            extentReportObj = new ExtentReports();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String timeStamp = dateFormat.format(new Date());

            String reportFilePath = path + "_" + timeStamp + ".html";
			extentSparkReporterObj = new ExtentSparkReporter(reportFilePath);
			extentReportObj.attachReporter(extentSparkReporterObj);

            extentSparkReporterObj.config().setReportName(reportName);
            extentSparkReporterObj.config().setDocumentTitle(reportName);
            extentReportObj.attachReporter(extentSparkReporterObj);

            return extentReportObj;


        } catch (Exception e){

            e.printStackTrace();
            return null;
            
        }
    }

}
