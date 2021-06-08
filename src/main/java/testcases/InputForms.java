package testcases;

import data.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PageObjects;

public class InputForms extends PageObjects {

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

    @Test(enabled = false, description = "Test simple form demo")
    public void simpleFormDemo() {

        homepage.inputForms.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"Simple Form Demo\")]")).click();

        //Wait for the header to display
        wtDriver.until(ExpectedConditions.visibilityOf(inputFormsPage.singleInputHeader));

        Assert.assertTrue(inputFormsPage.singleInputHeader.isDisplayed());
        Assert.assertTrue(inputFormsPage.twoInputHeader.isDisplayed());

        //Single input
        inputFormsPage.inputMessage.sendKeys(TestConstants.RandomStringValue);

        inputFormsPage.showMessageButton.click();

        Assert.assertEquals(inputFormsPage.displayMessage.getText(), TestConstants.RandomStringValue);

        //Two input
        inputFormsPage.sum1.sendKeys(TestConstants.num1);
        inputFormsPage.sum2.sendKeys(TestConstants.num2);

        inputFormsPage.getTotalButton.click();

        Assert.assertEquals(Integer.parseInt(inputFormsPage.totalSum.getText()),Integer.parseInt(TestConstants.num1) + Integer.parseInt(TestConstants.num2));
    }

    @Test(description = "Test Checkbox demo")
    public void checkboxDemo() {

        homepage.inputForms.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"Checkbox Demo\")]")).click();

        wtDriver.until(ExpectedConditions.visibilityOf(inputFormsPage.singleCheckboxHeader));

        Assert.assertTrue(inputFormsPage.singleCheckboxHeader.isDisplayed());
        Assert.assertTrue(inputFormsPage.multipleCheckboxHeader.isDisplayed());

        //single checkbox
        inputFormsPage.clickOnThisCheckBox.click();

        Assert.assertTrue(inputFormsPage.clickOnThisCheckBox.isSelected());
        Assert.assertTrue(inputFormsPage.successMessageCheckbox.isDisplayed());

        //multiple checkbox
        inputFormsPage.multipleCheckBox("Option 1").click();
        Assert.assertTrue(inputFormsPage.multipleCheckBox("Option 1").isSelected());

        inputFormsPage.multipleCheckBox("Option 3").click();
        Assert.assertTrue(inputFormsPage.multipleCheckBox("Option 3").isSelected());

        inputFormsPage.checkAllButton.click();
        Assert.assertEquals(inputFormsPage.isChecked.getAttribute("value"), "true");

        Assert.assertTrue(inputFormsPage.multipleCheckBox("Option 1").isSelected());
        Assert.assertTrue(inputFormsPage.multipleCheckBox("Option 2").isSelected());
        Assert.assertTrue(inputFormsPage.multipleCheckBox("Option 3").isSelected());
        Assert.assertTrue(inputFormsPage.multipleCheckBox("Option 4").isSelected());

        inputFormsPage.unCheckAllButton.click();
        Assert.assertEquals(inputFormsPage.isChecked.getAttribute("value"), "false");

        Assert.assertFalse(inputFormsPage.multipleCheckBox("Option 1").isSelected());
        Assert.assertFalse(inputFormsPage.multipleCheckBox("Option 2").isSelected());
        Assert.assertFalse(inputFormsPage.multipleCheckBox("Option 3").isSelected());
        Assert.assertFalse(inputFormsPage.multipleCheckBox("Option 4").isSelected());
    }
}
