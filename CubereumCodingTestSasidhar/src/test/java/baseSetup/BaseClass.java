package baseSetup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.LoadPropertiesFile;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;
    public LoadPropertiesFile propertiesFile = new LoadPropertiesFile();



    @Parameters({"Browser"})
    @BeforeTest
    public void setupBrowser(@Optional("chrome") String browser) {
        String currentDir = System.getProperty("user.dir");


        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.geckodriver", currentDir + "\\src\\test\\resources\\Drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.geckodriver", currentDir + "\\src\\test\\resources\\Drivers\\InternetExplorer.exe");
                driver = new InternetExplorerDriver();
            default:
                break;
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().to(propertiesFile.loadInputFromPropertiesFile("TestData.properties", "URL"));
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
    }


    @AfterTest
    public void tearDownBrowser() {
        driver.close();
    }
}
