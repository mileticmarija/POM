package pom_classes.GoogleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GoogleResultPage {
    WebDriver driver;
    String result;
    public GoogleResultPage(WebDriver driver){
        this.driver= driver;
    }

    private By searchResultContainer= By.cssSelector("#rso :nth-child(2)>div>div>div>a>h3>span");

    public String getSearchResult(){
        result= driver.findElement(searchResultContainer).getText();
        return result;
    }

    public void checkResults(String Topic){
        getSearchResult();
        Assert.assertTrue(result.contains(Topic));
    }

}
