package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class FiltersObjects {
    private WebDriver driver;
    private WebDriverWait wait;

    public FiltersObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='brandsRefinements'] //a")
    @CacheLookup
    private List<WebElement> brandsList;

    @FindBy(xpath = "//div[@id='filters'] //a")
    @CacheLookup
    private List<WebElement> filtersList;

    @FindBy(xpath = "//div[@id='filters'] //a[@class='a-link-normal s-navigation-item']")
    @CacheLookup
    private List<WebElement> materialList;


    public void selectBrandFilter(String desiredBrand) throws InterruptedException, IOException {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='brandsRefinements'] //a")));
        //    List<WebElement> brandsList = driver.findElements(By.xpath("//div[@id='brandsRefinements'] //a"));
        for (WebElement pList : brandsList) {

            if (pList.getText().contains(desiredBrand) || pList.getText().contains("LIMESTONE") || pList.getText().contains("Dice")) {
                pList.click();
                break;
            }
        }

    }

    public void selectDisplayFilter(String typeOfDisplay) {

        //   List<WebElement> displayItemsList=driver.findElements(By.xpath("//div[@id='filters'] //a"));
        for (WebElement pList : filtersList) {
            if (pList.getText().contains(typeOfDisplay)) {
                pList.click();
                break;
            }
        }
    }

    public void selectMaterialFilter(String typeOfMaterial) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='filters'] //a[@class='a-link-normal s-navigation-item']")));
        // List<WebElement> displayList = driver.findElements(By.xpath("//div[@id='filters'] //a[@class='a-link-normal s-navigation-item']"));
        for (WebElement pList : materialList) {
            if (pList.getText().contains(typeOfMaterial)) {
                pList.click();
                break;
            }
        }
    }

    public void selectDiscountFilter(String discount) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='filters'] //a[@class='a-link-normal s-navigation-item']")));
        List<WebElement> filtersList = driver.findElements(By.xpath("//div[@id='filters'] //a[@class='a-link-normal s-navigation-item']"));
        for (WebElement pList : filtersList) {
            if (pList.getText().contains(discount)) {
                pList.click();
                break;
            }
        }
    }
}
