package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

    public WebDriver driver;
    public landingPage(WebDriver driver){
        this.driver = driver;
    }

    By signing = By.cssSelector("a[href*='sign_in']");
    By title = By.cssSelector("#content > div > div > h2");
    By homeButton = By.cssSelector("#homepage > header > div.navbar.navbar-default.navbar-static-top > div > nav > ul > li.active > a");

    public loginPage getLogin(){
        driver.findElement(signing).click();
        loginPage lp = new loginPage(driver);
        return lp;

    }

    public WebElement getTitle(){
        return driver.findElement(title);

    }

    public WebElement getHomeButton(){
        return driver.findElement(homeButton);

    }
}
