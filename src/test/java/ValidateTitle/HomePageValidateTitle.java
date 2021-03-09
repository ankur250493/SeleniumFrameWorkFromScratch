package ValidateTitle;

import BrowserInitializer.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.landingPage;
import pageObjects.loginPage;

import java.io.IOException;

public class HomePageValidateTitle extends Base {
    public WebDriver driver;
    private static Logger log =  LogManager.getLogger(HomePageValidateTitle.class);
    @BeforeTest
    public void TearUp() throws IOException {
        driver = InitialiseDemo();
        driver.get(prop.getProperty("url"));
        log.info("Driver is initialized");
    }

    @Test
    public void basePageNavigation(){
        landingPage obj = new landingPage(driver);
        String validate = obj.getTitle().getText();
        Assert.assertEquals(validate, "FEATURED COURSES");
        log.info("Title is correct");

    }

    @AfterTest
    void TearDown() {
        driver.close();
        log.info("Driver is closed");
    }
}
