package pom_classes.WinLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WinLoginPage {
    WebDriver driver;
    public WinLoginPage (WebDriver driver){
        this.driver=driver;
    }

    protected By emailBox= By.cssSelector("#email");
    protected By passBox= By.cssSelector("#pass");
    protected By loginButton= By.cssSelector("#send2");
    protected By reqPass=By.cssSelector("#advice-required-entry-pass");
    protected By reqEmail=By.cssSelector("#advice-required-entry-email");
    protected By wrongEmail=By.cssSelector("#advice-validate-email-email");
    protected By wrongPas=By.cssSelector(".messages>li>ul>li>span");


    public void enterEmail(String email){
        driver.findElement(emailBox).sendKeys(email);
    }

    public void enterPass(String pass){
        driver.findElement(passBox).sendKeys(pass);
    }

    public void enterData(String email, String pass){
        enterEmail(email);
        enterPass(pass);
    }

    public void submitData(){
        driver.findElement(loginButton).click();
    }

    public void login(String email, String pass){
        enterData(email,pass);
        submitData();
    }

    public void checkWarrningMsgPass(String warrningPass){
        Assert.assertEquals(driver.findElement(reqPass).getText(),warrningPass);
    }

    public void checkWarrningMsgEmail(String warrningEmail){
        Assert.assertEquals(driver.findElement(reqEmail).getText(),warrningEmail);
    }

    public void checkWarrningMsg(String warrningMsg){
        checkWarrningMsgEmail(warrningMsg);
        checkWarrningMsgPass(warrningMsg);
    }

    public void checkWrongEmail(String wrongMail){
        Assert.assertEquals(driver.findElement(wrongEmail).getText(),wrongMail);
    }

    public void checkWrongPass(String wrongPass){
        Assert.assertEquals(driver.findElement(wrongPas).getText(),wrongPass);
    }



}
