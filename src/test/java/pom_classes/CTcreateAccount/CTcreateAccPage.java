package pom_classes.CTcreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CTcreateAccPage {
    WebDriver driver;
    public CTcreateAccPage(WebDriver driver){
        this.driver=driver;
    }

    private By ime= By.cssSelector("#firstname");
    private By prezime= By.cssSelector("#lastname");
    private By email= By.cssSelector("#email_address");
    private By password= By.cssSelector("#password");
    private By confirmation=By.cssSelector("#confirmation");
    private By send=By.cssSelector("[title='Submit']");
    private By cookie=By.cssSelector("div>button:nth-child(4)");

    public void fillForm(String name, String lastName, String mail, String lozinka){
        driver.findElement(ime).sendKeys(name);
        driver.findElement(prezime).sendKeys(lastName);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(lozinka);
        driver.findElement(confirmation).sendKeys(lozinka);
    }

    public void submitData(){
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
        driver.findElement(cookie).click();
        driver.findElement(send).click();
    }

    public void createAcc(String name,String lastName, String mail, String lozinka ){
        this.fillForm(name,lastName,mail,lozinka);
        this.submitData();
    }


}
