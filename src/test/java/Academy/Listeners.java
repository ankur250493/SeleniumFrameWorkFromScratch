package Academy;

import BrowserInitializer.Base;
import BrowserInitializer.ExtentReportTestNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import BrowserInitializer.Base;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {

    ExtentReports extent = ExtentReportTestNG.getReportObject();
    ExtentTest test;
    ThreadLocal <ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passes");
    }

    public void onTestFailure(ITestResult result) {

        extentTest.get().fail(result.getThrowable());
        WebDriver driver = null;
        String testMethodName = result.getMethod().getMethodName();
        result.getTestClass().getRealClass();
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName,driver),result.getMethod().getMethodName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
