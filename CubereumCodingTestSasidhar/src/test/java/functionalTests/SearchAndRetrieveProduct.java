package functionalTests;

import baseSetup.BaseClass;
import org.testng.annotations.Test;
import pageObjects.FiltersObjects;
import pageObjects.SearchInHomePageObjects;
import pageObjects.SearchProductsObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SearchAndRetrieveProduct extends BaseClass {

    @Test(priority = 0)
    public void searchingTheDesiredProductInHomePage() {
        SearchInHomePageObjects searchObject = new SearchInHomePageObjects(driver);
        searchObject.setSearchBoxInHomePage(propertiesFile.loadInputFromPropertiesFile("TestData.properties", "SEARCH_THIS"));
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }

    @Test(priority = 1)
    public void selectingTheFilters() throws InterruptedException, IOException {
        FiltersObjects filtersObjects = new FiltersObjects(driver);
        filtersObjects.selectDisplayFilter(propertiesFile.loadInputFromPropertiesFile("TestData.properties", "DESIRED_TYPE_OF_DISPLAY"));
        filtersObjects.selectBrandFilter(propertiesFile.loadInputFromPropertiesFile("TestData.properties", "DESIRED_PRODUCT"));
        filtersObjects.selectMaterialFilter(propertiesFile.loadInputFromPropertiesFile("TestData.properties", "DESIRED_MATERIAL"));
        filtersObjects.selectDiscountFilter(propertiesFile.loadInputFromPropertiesFile("TestData.properties", "DESIRED_DISCOUNT"));
    }


    @Test(priority = 2)
    public void getPriceAndProduct() throws IOException {
        SearchProductsObjects searchProductsObjects = new SearchProductsObjects(driver);
        searchProductsObjects.getProductAndPrice(propertiesFile.loadInputFromPropertiesFile("TestData.properties", "COUNT_OF_PRODUCT"));
    }
}
