package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

    public WebDriver driver;
    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    By emailAddress = By.id("user_email");
    By password = By.name(" password");
    By loginButton = By.name("commit");
    By forgotPassword = By.cssSelector("[href*='password/new']");

    public WebElement enterEmail(){
        return driver.findElement(emailAddress);

    }
    public WebElement enterPassword(){
        return driver.findElement(password);

    }
    public WebElement login(){
        return driver.findElement(loginButton);

    }

    public ForgetPassword forgotPass(){
        driver.findElement(forgotPassword).click();
        ForgetPassword fp = new ForgetPassword(driver);
        return fp;


    }
}
