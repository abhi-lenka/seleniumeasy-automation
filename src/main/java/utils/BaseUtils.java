package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseUtils {

    protected WebDriver driver;
    protected WebDriverWait wtDriver;
    protected Actions action;

    @BeforeMethod
    @Parameters({"browser"})
    public void openBrowser(String browser) {

        if(browser.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")) {

            System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        wtDriver = new WebDriverWait(driver, 10);
        action= new Actions(driver);

        driver.manage().window().maximize();
    }
}
