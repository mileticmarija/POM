package pom_classes.CTcreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CTregisterPage {
    WebDriver driver;
    WebDriverWait wdWait;
    String result;
    public CTregisterPage(WebDriver driver){
        this.driver=driver;
    }

    private By close=By.cssSelector(".soundest-form-background-image-wrapper a ");
    private By cMessageContainer= By.cssSelector(".alert.alert-success>p");

    public String getCmessageText(){
        wdWait=new WebDriverWait(driver,5000);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(cMessageContainer));
        result=driver.findElement(cMessageContainer).getText();
        return result;
    }

    public void checkMessage(String cMessage){
        getCmessageText();
        Assert.assertEquals(result,cMessage);
    }

}
