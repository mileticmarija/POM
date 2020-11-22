package tests.WinLoginTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom_classes.WinLogin.WinAccPage;
import pom_classes.WinLogin.WinLoginPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.concurrent.TimeUnit;

public class WinLoginTest {
    WebDriver driver;
    String URL="https://www.winwin.rs/customer/account/login/";
    DriverManager driverManager;
    WinLoginPage wlp;
    WinAccPage wap;

    @BeforeMethod
    public void setUp(){
        driverManager= DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver=driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
//01.TC. Successful login
    @Test
    @Parameters ({"email","pass","welcomeM"})
    public void login (String email,String pass, String welcomeM){
        wlp=new WinLoginPage(driver);
        wap=new WinAccPage(driver);

        wlp.login(email,pass);
        wap.checkWelcomeMsg(welcomeM);
    }
//02.TC. Submit all required fields empty
    @Test
    @Parameters ({"email","pass","warrningMsg"})
    public void submitEmptyFields (String email,String pass,String warrningMsg){
        wlp=new WinLoginPage(driver);

        wlp.login(email,pass);
        wlp.checkWarrningMsg(warrningMsg);
    }
//03.TC. Submit email field empty
    @Test
    @Parameters ({"email","pass","warrningMsg"})
    public void submitEmptyEmail(String email, String pass, String warrningMsg){
        wlp=new WinLoginPage(driver);

        wlp.login(email,pass);
        wlp.checkWarrningMsgEmail(warrningMsg);
    }
//04.TC. Submit password field empty
    @Test
    @Parameters ({"email","pass","warrningMsg"})
    public void submitEmptyPass (String email, String pass, String warrningMsg){
        wlp=new WinLoginPage(driver);

        wlp.login(email,pass);
        wlp.checkWarrningMsgPass(warrningMsg);
    }
//05.TC. Submit wrong email format
    @Test
    @Parameters ({"email","pass","warrningEmail"})
    public void submitwrongEmailFormat (String email, String pass, String warrningEmail){
        wlp=new WinLoginPage(driver);

        wlp.login(email,pass);
        wlp.checkWrongEmail(warrningEmail);
    }
//06.TC. Submit wrong password
    @Test
    @Parameters ({"email","pass","warrningPass"})
    public void submitwrongPass (String email, String pass, String warrningPass){
        wlp=new WinLoginPage(driver);

        wlp.login(email,pass);
        wlp.checkWrongPass(warrningPass);
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}
