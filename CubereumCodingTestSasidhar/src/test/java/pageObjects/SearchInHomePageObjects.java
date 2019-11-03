package pageObjects;

import baseSetup.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchInHomePageObjects {
    private WebDriver driver;

    public SearchInHomePageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    @CacheLookup
    private
    WebElement searchBoxInHomePage;

    public void setSearchBoxInHomePage(String searchThisProduct) {
      searchBoxInHomePage.sendKeys(searchThisProduct + Keys.ENTER);

    }
}
