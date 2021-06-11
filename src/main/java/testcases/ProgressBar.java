package testcases;

import data.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PageObjects;

public class ProgressBar extends PageObjects {

    @BeforeMethod
    public void navigateToUrl() {

        driver.get(TestConstants.websiteURL);

        //Wait for the ad banner to display
        wtDriver.until(ExpectedConditions.visibilityOf(homepage.adModal));

        //Close the ad banner
        homepage.adModalClose.click();

        //Wait for the title to display
        wtDriver.until(ExpectedConditions.visibilityOf(homepage.siteNameTitle));
    }

    @AfterMethod
    public void exitBrowser() {
        driver.quit();
    }

    @Test(description = "Test Jquery UI progress bar")
    public void jqueryUI() throws InterruptedException {

        homepage.progressBars.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"JQuery Download Progress bars\")]")).click();

        wtDriver.until(ExpectedConditions.visibilityOf(progressBarPage.downloadButton));

        Assert.assertTrue(progressBarPage.downloadButton.isDisplayed());

        progressBarPage.downloadButton.click();

        wtDriver.until(ExpectedConditions.visibilityOf(progressBarPage.progressBar));

        Thread.sleep(3000);

        System.out.println("The progress is : " + progressBarPage.progressBar.getAttribute("aria-valuenow"));

        wtDriver.until(ExpectedConditions.visibilityOf(progressBarPage.closeButton));

        Assert.assertEquals(progressBarPage.progressLabel.getText(), "Complete!");

        progressBarPage.closeButton.click();
    }

    @Test(description = "Test Drag & Drop sliders")
    public void dragDropSlider() {

        homepage.progressBars.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"Drag & Drop Sliders\")]")).click();

        wtDriver.until(ExpectedConditions.visibilityOf(progressBarPage.slider1));

        int slider1Before = Integer.parseInt(progressBarPage.slider1Range.getText());

        action.dragAndDropBy(progressBarPage.slider1, 50, 0).build().perform();

        int slider1After = Integer.parseInt(progressBarPage.slider1Range.getText());

        System.out.println("Slider 1 value - Before : " + slider1Before + " After : " + slider1After);

        Assert.assertTrue(slider1After > slider1Before);

        int slider2Before = Integer.parseInt(progressBarPage.slider2Range.getText());

        action.dragAndDropBy(progressBarPage.slider2, 20, 0).build().perform();

        int slider2After = Integer.parseInt(progressBarPage.slider2Range.getText());

        System.out.println("Slider 2 value - Before : " + slider2Before + " After : " + slider2After);

        Assert.assertTrue(slider2After > slider2Before);
    }
}
