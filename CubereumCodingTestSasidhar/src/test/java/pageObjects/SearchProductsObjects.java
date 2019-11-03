package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WriteInExcel;

import java.io.IOException;
import java.util.List;

public class SearchProductsObjects {
    private WebDriver driver;


    public SearchProductsObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='s-result-list s-search-results sg-row'] //h2")
    @CacheLookup
    private List<WebElement> productNamesList;

    @FindBy(xpath = "//div[@class='s-result-list s-search-results sg-row'] //a //span[@class='a-price']")
    @CacheLookup
    private List<WebElement> priceList;

    public void getProductAndPrice(String count) throws IOException {

        WriteInExcel.writingToExcel(productNamesList.get(Integer.valueOf(count)).getText(), priceList.get(Integer.valueOf(count)).getText());
    }
}
