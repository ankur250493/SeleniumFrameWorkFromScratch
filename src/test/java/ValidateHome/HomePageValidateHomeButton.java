package ValidateHome;

import BrowserInitializer.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.landingPage;

import java.io.IOException;

public class HomePageValidateHomeButton extends Base {
    public WebDriver driver;
    private static Logger log =  LogManager.getLogger(HomePageValidateHomeButton.class);
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
        boolean homeButton = obj.getHomeButton().isDisplayed();
        Assert.assertEquals(validate, "FEATURED COURSES");
        log.info("Assertion Passes");
        Assert.assertFalse(homeButton);
        log.info("Home button is visible");
    }

    @AfterTest
    void TearDown() {
        driver.close();
        log.info("Driver is closed");
    }
}
