package testcases;

import data.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PageObjects;

public class AlertsAndModals extends PageObjects {

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

    @Test(description = "Bootstrap Alert")
    public void bootstrapAlert() {

        homepage.alertModalBars.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"Bootstrap Alerts\")]")).click();

        //Wait for the header to display
        wtDriver.until(ExpectedConditions.visibilityOf(alertsAndModalPage.bootstrapAlertHeader));

        Assert.assertTrue(alertsAndModalPage.normalSuccessMessage.isDisplayed());

        alertsAndModalPage.normalSuccessMessage.click();

        wtDriver.until(ExpectedConditions.visibilityOf(alertsAndModalPage.normalSuccessMessageContent));

        Assert.assertTrue(alertsAndModalPage.normalSuccessMessageContent.getText().contains("I'm a normal success message. To close use the appropriate button."));

        alertsAndModalPage.normalSuccessMessageClose.click();
    }

    @Test(description = "Test Bootstrap Modal")
    public void bootstrapModal() {

        homepage.alertModalBars.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"Bootstrap Modals\")]")).click();

        //Wait for the header to display
        wtDriver.until(ExpectedConditions.visibilityOf(alertsAndModalPage.singleModalHeader));

        Assert.assertTrue(alertsAndModalPage.singleModalHeader.isDisplayed());
        Assert.assertTrue(alertsAndModalPage.multipleModalHeader.isDisplayed());

        //Single modal
        alertsAndModalPage.singleLaunchModalButton.click();

        wtDriver.until(ExpectedConditions.visibilityOf(alertsAndModalPage.modal1));

        alertsAndModalPage.modal1Close.click();

        //Multi modal
        alertsAndModalPage.multiLaunchModalButton.click();

        wtDriver.until(ExpectedConditions.visibilityOf(alertsAndModalPage.modal2));

        alertsAndModalPage.multiInsideLaunchModalButton.click();

        wtDriver.until(ExpectedConditions.visibilityOf(alertsAndModalPage.modal3));

        alertsAndModalPage.modal3Close.click();

        alertsAndModalPage.modal2Close.click();
    }

    @Test(description = "Test Window Popup")
    public void windowPopUp() throws InterruptedException {

        homepage.alertModalBars.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"Window Popup Modal\")]")).click();

        //Wait for the header to display
        wtDriver.until(ExpectedConditions.visibilityOf(alertsAndModalPage.singleWindowPopHeader));

        Assert.assertTrue(alertsAndModalPage.singleWindowPopHeader.isDisplayed());
        Assert.assertTrue(alertsAndModalPage.multiWindowPopHeader.isDisplayed());

        String mainWindow = driver.getWindowHandle();

        alertsAndModalPage.twitterFollow.click();

        for (String win : driver.getWindowHandles()) {

            if(!(win.equals(mainWindow))) {
                driver.switchTo().window(win);
                Thread.sleep(3000);
                Assert.assertTrue(driver.getTitle().contains("Twitter"));
                driver.close();
            }
        }

        driver.switchTo().window(mainWindow);

        alertsAndModalPage.facebookFollow.click();

        for (String win : driver.getWindowHandles()) {

            if(!(win.equals(mainWindow))) {
                driver.switchTo().window(win);
                Thread.sleep(3000);
                Assert.assertTrue(driver.getTitle().contains("Facebook"));
                driver.close();
            }
        }

        driver.switchTo().window(mainWindow);

        action.moveToElement(alertsAndModalPage.multiWindowPopHeader).build().perform();

        alertsAndModalPage.followAll.click();

        for (String win : driver.getWindowHandles()) {

            if(!(win.equals(mainWindow))) {
                driver.switchTo().window(win);
                driver.close();
            }
        }

        driver.switchTo().window(mainWindow);
    }
}
