package testcases;

import data.TestConstants;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PageObjects;

public class navigateToSite extends PageObjects {

    @BeforeMethod
    public void navigateToUrl() {

        driver.get(TestConstants.websiteURL);

        //Wait for the ad banner to display
        wtDriver.until(ExpectedConditions.visibilityOf(homepage.adModal));

        //Close the ad banner
        homepage.adModalClose.click();
    }

    @AfterMethod
    public void exitBrowser() {
        driver.close();
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

    @Test(description = "Assert the different levels of testing in this website")
    public void differentLevelOfTesting() {

        //Wait for the home icon to display
        wtDriver.until(ExpectedConditions.visibilityOf(homepage.homeBarIcon));

        action.moveToElement(homepage.homeBarIcon).build().perform();

        /*
         * Click on the different level icons and assert the description
         */
        Assert.assertTrue(homepage.homeBarIcon.findElement(By.xpath("ancestor::li")).getAttribute("class").contains("active"));

        Assert.assertEquals(homepage.homeBarDescription.getText(), TestConstants.homeBarDescription);

        wtDriver.until(ExpectedConditions.elementToBeClickable(homepage.startPractisingButton));

        homepage.startPractisingButton.click();

        Assert.assertTrue(homepage.basicBarIcon.findElement(By.xpath("ancestor::li")).getAttribute("class").contains("active"));

        wtDriver.until(ExpectedConditions.visibilityOf(homepage.basicBarDescription));

        Assert.assertEquals(homepage.basicBarDescription.getText(), TestConstants.basicBarDescription);

        wtDriver.until(ExpectedConditions.elementToBeClickable(homepage.basicProceedNextButton));

        homepage.basicProceedNextButton.click();

        Assert.assertTrue(homepage.interBarIcon.findElement(By.xpath("ancestor::li")).getAttribute("class").contains("active"));

        wtDriver.until(ExpectedConditions.visibilityOf(homepage.interBarDescription));

        Assert.assertEquals(homepage.interBarDescription.getText(), TestConstants.interBarDescription);

        wtDriver.until(ExpectedConditions.elementToBeClickable(homepage.interProceedNextButton));

        homepage.interProceedNextButton.click();

        Assert.assertTrue(homepage.advanceBarIcon.findElement(By.xpath("ancestor::li")).getAttribute("class").contains("active"));

        wtDriver.until(ExpectedConditions.visibilityOf(homepage.advanceBarDescription));

        Assert.assertEquals(homepage.advanceBarDescription.getText(), TestConstants.advanceBarDescription);

        wtDriver.until(ExpectedConditions.elementToBeClickable(homepage.advanceProceedNextButton));

        homepage.advanceProceedNextButton.click();

        Assert.assertTrue(homepage.doneBarIcon.findElement(By.xpath("ancestor::li")).getAttribute("class").contains("active"));

        wtDriver.until(ExpectedConditions.visibilityOf(homepage.doneBarDescription));

        Assert.assertEquals(homepage.doneBarDescription.getText(), TestConstants.doneBarDescription);
    }
}
