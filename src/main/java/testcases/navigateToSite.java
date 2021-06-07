package testcases;

import data.TestConstants;
import pageObjects.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class navigateToSite {

    WebDriver driver;
    Homepage homepage;

    @BeforeMethod
    public void navigateToUrl() {

        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();

        homepage = new Homepage(driver);

        driver.manage().window().maximize();

        driver.get(TestConstants.websiteURL);
    }

    @AfterMethod
    public void exitBrowser() {
        driver.quit();
    }

    @Test(description = "Navigate to the seleniumeasy test demo website and assert that the site is visible")
    public void assertTheUrlIsOpened() {

        //Assert the page logo title
        Assert.assertEquals(homepage.siteNameTitle.getText(),"Selenium Easy");

        //Assert the url
        Assert.assertEquals(driver.getCurrentUrl(),TestConstants.websiteURL);

        //Assert the site slogan
        Assert.assertEquals(homepage.SiteSlogan.getText(), "Complete Automation Testing Tutorials");
    }

}
