package tests.GoogleSearchTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_classes.GoogleSearch.GoogleResultPage;
import pom_classes.GoogleSearch.GoogleSearchPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTests {
    WebDriver driver;
    String URL= "http://www.google.com";
    String Topic = "QAITive";
    DriverManager driverManager;
    GoogleSearchPage gsp;
    GoogleResultPage grp;


    @BeforeMethod
    public void setup(){
        driverManager= DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver= driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchSomethingOnGoogle(){
        gsp= new GoogleSearchPage(driver);
        grp= new GoogleResultPage(driver);

        gsp.searchGoogle(Topic);
        grp.checkResults(Topic);
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitDriver();
    }

}
