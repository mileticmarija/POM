package pom_classes.WinLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WinAccPage {
    WebDriver driver;
    public WinAccPage(WebDriver driver){
        this.driver=driver;
    }

    protected By welcomeMsg= By.cssSelector(".welcome-msg .hello");

    public void checkWelcomeMsg(String welcomeM){
        Assert.assertEquals(driver.findElement(welcomeMsg).getText(),welcomeM);
    }
}
