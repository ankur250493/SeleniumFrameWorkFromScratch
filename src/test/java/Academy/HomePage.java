package Academy;

import BrowserInitializer.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ForgetPassword;
import pageObjects.landingPage;
import pageObjects.loginPage;

import java.io.IOException;

public class HomePage extends Base {
    private static Logger log = LogManager.getLogger(HomePage.class);
    public WebDriver driver;

    @BeforeTest
    public void TearUp() throws IOException {
        driver = InitialiseDemo();
        driver.get(prop.getProperty("url"));
        log.info("Driver is initialized");
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String UserName, String Password, String text) {
        driver.get(prop.getProperty("url"));
        landingPage l = new landingPage(driver);

        loginPage lp = l.getLogin();

        lp.enterEmail().sendKeys(UserName);
        lp.enterPassword().sendKeys(Password);
        System.out.println(text);

        lp.login().click();
        ForgetPassword fp = lp.forgotPass();
        fp.enterEmail().sendKeys("vhbf");
        fp.submitEmail().click();
        log.info("Login failed");
    }

    @DataProvider
    public Object[][] getData() {
        //Row stands for how many different data types test should run
        //Columns stands for how many values per test
        Object[][] data = new Object[2][3];

        // 1st set
        data[0][0] = "sampleEmail";
        data[0][1] = "samplePassword";
        data[0][2] = "Restricted user";

        //  2nd dataset
        data[1][0] = "2ndsampleEmail";
        data[1][1] = "2ndSamplePassword";
        data[1][2] = "notRestricked";

        return data;
    }

    @AfterTest
    void TearDown() {
        driver.close();
        log.info("Driver is closed");
    }
}
