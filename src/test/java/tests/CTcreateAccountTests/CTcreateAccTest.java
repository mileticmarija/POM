package tests.CTcreateAccountTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_classes.CTcreateAccount.CTcreateAccPage;
import pom_classes.CTcreateAccount.CTregisterPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CTcreateAccTest {
    WebDriver driver;
    String URL= "https://www.ctshop.rs/customer/account/create";
    DriverManager driverManager;
    CTcreateAccPage ctcp;
    CTregisterPage ctrp;

    @BeforeMethod
    public void setUp(){
        driverManager= DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver= driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void createCTaccount(){
        ctcp= new CTcreateAccPage(driver);
        ctrp=new CTregisterPage(driver);
        Random r=new Random();
        int br=r.nextInt(10);

        ctcp.createAcc("Marija","Miletic","malac5445"+br+"@gmail.com","mamadu5445");
        ctrp.checkMessage();
    }

    @AfterMethod
    public void tearDown(){
      driverManager.quitDriver();
    }

}
