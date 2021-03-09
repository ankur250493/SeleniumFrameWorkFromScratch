package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPassword {

    public WebDriver driver;
    public ForgetPassword(WebDriver driver){
        this.driver = driver;
    }

    By email = By.name("email");
    By sendMeInstructions = By.name("commit");

    public WebElement enterEmail(){
        return driver.findElement(email);

    }

    public WebElement submitEmail(){
        return driver.findElement(sendMeInstructions);

    }
}
