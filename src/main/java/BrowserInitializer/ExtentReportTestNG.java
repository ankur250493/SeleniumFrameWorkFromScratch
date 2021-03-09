package BrowserInitializer;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTestNG {

   static ExtentReports extent;
    public static ExtentReports getReportObject() {
        String path = System.getProperty("user.dir") + "/target/reports/index.html";
        System.out.println(System.getProperty("user.dir"));
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("SampleReportName");
        reporter.config().setDocumentTitle("SampleDocumentTitle");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Ankur");
        return extent;
    }
}
