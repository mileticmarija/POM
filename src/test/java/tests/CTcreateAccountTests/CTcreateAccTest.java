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
        int br=r.nextInt(9);
        String[] chars= {"A","B","C","D","E","F","G","H","I","J"};

        ctcp.createAcc("Marija","Miletic","malac5445"+br+chars[br]+"@gmail.com","mamadu5445","mamadu5445");
        ctrp.checkMessage("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.");
    }

    @AfterMethod
    public void tearDown(){
      driverManager.quitDriver();
    }

}
