package BrowserInitializer;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public Properties prop = new Properties();
    public WebDriver InitialiseDemo() throws IOException {


        FileInputStream fis = new FileInputStream("/home/ankur/Documents/Selenium 4.0/SeleniumFrameWorkScratch/src/main/resources/Data.properties");
        prop.load(fis);
        String browserName = System.getProperty("browser");
      //  String browserName = prop.getProperty("browser");

        switch (browserName) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/home/ankur/Documents/Selenium/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/home/ankur/Documents/Selenium/chromedriver");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
                driver.manage().window().maximize();
                break;

            case "IE":

                break;
        }
        return driver;
    }

    public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source =  ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/screenshot/reports/" + testCaseName + ".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;

    }
}
