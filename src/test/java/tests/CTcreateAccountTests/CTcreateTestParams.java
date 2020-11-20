package tests.CTcreateAccountTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom_classes.CTcreateAccount.CTcreateAccPage;
import pom_classes.CTcreateAccount.CTregisterPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CTcreateTestParams {
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

    @Parameters({"ime","prezime","pass", "cMessage"})
    @Test
    public void createCTaccount(String ime,String prezime, String pass, String cMessage){
        ctcp= new CTcreateAccPage(driver);
        ctrp=new CTregisterPage(driver);
        Random r=new Random();
        int br=r.nextInt(24);
        String[] chars= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z"};
        String mail="malac5445"+br+chars[br]+"@gmail.com";

        ctcp.createAcc(ime,prezime,mail,pass);
        ctrp.checkMessage(cMessage);
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}
