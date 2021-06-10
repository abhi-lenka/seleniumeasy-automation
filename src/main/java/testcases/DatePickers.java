package testcases;

import data.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePickers extends PageObjects {

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

    @Test(description = "Test Bootstrap date picker")
    public void bootStrapDatePicker() {

        homepage.datePickers.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"Bootstrap Date Picker\")]")).click();

        //Wait for the header to display
        wtDriver.until(ExpectedConditions.visibilityOf(datePickersPage.dateHeader));

        Assert.assertTrue(datePickersPage.dateHeader.isDisplayed());
        Assert.assertTrue(datePickersPage.dateRangeHeader.isDisplayed());

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String todayDate = formatter.format(date);

        //single date
        datePickersPage.singleInputDate.sendKeys(todayDate);

        Assert.assertEquals(datePickersPage.singleInputDate.getAttribute("value"), todayDate);

        datePickersPage.dateAddon1.click();

        datePickersPage.clear.click();

        datePickersPage.dateAddon1.click();

        datePickersPage.today.click();

        Assert.assertEquals(datePickersPage.singleInputDate.getAttribute("value"), todayDate);

        //date range
        action.moveToElement(datePickersPage.dateRangeHeader).build().perform();

        //** This function will throw error when clicking on Sundays ** Feel free to update the function
        datePickersPage.selectDate(datePickersPage.startDate, date);
        datePickersPage.selectDate(datePickersPage.endDate, date);

        Assert.assertEquals(datePickersPage.startDate.getAttribute("value"), todayDate);
        Assert.assertEquals(datePickersPage.endDate.getAttribute("value"), todayDate);
    }
}
