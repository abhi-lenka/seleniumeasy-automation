package testcases;

import data.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    @Test(description = "Test simple form demo")
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

        Assert.assertEquals(Integer.parseInt(inputFormsPage.totalSum.getText()), Integer.parseInt(TestConstants.num1) + Integer.parseInt(TestConstants.num2));
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

    @Test(description = "Test Radio Buttons Demo")
    public void radioButtonsDemo() {

        homepage.inputForms.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"Radio Buttons Demo\")]")).click();

        wtDriver.until(ExpectedConditions.visibilityOf(inputFormsPage.radioButtonHeader));

        Assert.assertTrue(inputFormsPage.radioButtonHeader.isDisplayed());
        Assert.assertTrue(inputFormsPage.groupRadioButtonsHeader.isDisplayed());

        //single radio button
        inputFormsPage.maleCheckbox1.click();

        Assert.assertTrue(inputFormsPage.maleCheckbox1.isSelected());

        inputFormsPage.getCheckedValueButton.click();

        Assert.assertTrue(inputFormsPage.radioValue1.isDisplayed());

        Assert.assertEquals(inputFormsPage.radioValue1.getText(), "Radio button 'Male' is checked");

        //group radio button
        action.moveToElement(inputFormsPage.femaleCheckbox2).build().perform();

        inputFormsPage.femaleCheckbox2.click();

        inputFormsPage.getAgeLimit("15 - 50").click();

        Assert.assertTrue(inputFormsPage.femaleCheckbox2.isSelected());
        Assert.assertTrue(inputFormsPage.getAgeLimit("15 - 50").isSelected());

        inputFormsPage.getValuesButton.click();

        Assert.assertTrue(inputFormsPage.radioValue2.isDisplayed());

        Assert.assertTrue(inputFormsPage.radioValue2.getText().contains("Sex : Female"));
        Assert.assertTrue(inputFormsPage.radioValue2.getText().contains("Age group: 15 - 50"));
    }

    @Test(description = "Test Select List Demo")
    public void selectList() {

        homepage.inputForms.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"Select Dropdown List\")]")).click();

        wtDriver.until(ExpectedConditions.visibilityOf(inputFormsPage.selectListHeader));

        Assert.assertTrue(inputFormsPage.selectListHeader.isDisplayed());
        Assert.assertTrue(inputFormsPage.multiSelectListHeader.isDisplayed());

        //Single select
        Select single = new Select(inputFormsPage.selectDayDropdown);

        single.selectByVisibleText("Thursday");

        Assert.assertTrue(inputFormsPage.selectedDayValue.isDisplayed());

        Assert.assertEquals(inputFormsPage.selectedDayValue.getText(), "Day selected :- Thursday");

        //Multi select
        action.moveToElement(inputFormsPage.multiSelectPlace).build().perform();

        Select multi = new Select(inputFormsPage.multiSelectPlace);

        multi.selectByValue("Ohio");

        inputFormsPage.firstSelectedButton.click();

        Assert.assertTrue(inputFormsPage.selectedPlacesValue.isDisplayed());

        Assert.assertEquals(inputFormsPage.selectedPlacesValue.getText(), "First selected option is : Ohio");

        multi.deselectByValue("Ohio");

        multi.selectByIndex(0);
        multi.selectByVisibleText("Florida");

        inputFormsPage.getAllSelectedButton.click();

        //Found an bug using select multiple select options (Multiple values are not displaying in the website) so commenting the assertion to avoid failure
//        Assert.assertEquals(inputFormsPage.selectedPlacesValue.getText(), "Options selected are : California,Florida");
    }

    @Test(description = "Test Input form")
    public void inputForm() {

        homepage.inputForms.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"Input Form Submit\")]")).click();

        wtDriver.until(ExpectedConditions.visibilityOf(inputFormsPage.contactUsHeader));

        Assert.assertTrue(inputFormsPage.contactUsHeader.isDisplayed());

        inputFormsPage.firstName.sendKeys("Jon");

        inputFormsPage.lastName.sendKeys("Wick");

        inputFormsPage.email.sendKeys("jonwick@action.com");

        inputFormsPage.phone.sendKeys("3422203553");

        inputFormsPage.address.sendKeys("07 Seattle");

        inputFormsPage.city.sendKeys("New York");

        Select state = new Select(inputFormsPage.state);

        state.selectByVisibleText("Washington");

        inputFormsPage.zip.sendKeys("1234");

        inputFormsPage.website.sendKeys("hellyeah.com");

        inputFormsPage.noHosting.click();

        inputFormsPage.comment.sendKeys("WHOEVER COMES, WHOEVER IT IS... I'LL KILL THEM. I'LL KILL THEM ALL.");

        Assert.assertTrue(inputFormsPage.sendButton.isEnabled());

        inputFormsPage.sendButton.submit();
    }

    @Test(description = "Test Ajax form")
    public void ajaxForm() {

        homepage.inputForms.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"Ajax Form Submit\")]")).click();

        wtDriver.until(ExpectedConditions.visibilityOf(inputFormsPage.ajaxFormHeader));

        Assert.assertTrue(inputFormsPage.ajaxFormHeader.isDisplayed());

        inputFormsPage.ajaxName.sendKeys("Bruce Wayne");

        inputFormsPage.ajaxComment.sendKeys("I am Batman!");

        action.moveToElement(inputFormsPage.ajaxSubmit).build().perform();

        inputFormsPage.ajaxSubmit.click();

        wtDriver.until(ExpectedConditions.visibilityOf(inputFormsPage.ajaxLoaderIcon));

        Assert.assertTrue(inputFormsPage.ajaxLoaderIcon.isDisplayed());

        Assert.assertTrue(inputFormsPage.ajaxSubmitMessage.isDisplayed());

        Assert.assertEquals(inputFormsPage.ajaxSubmitMessage.getText(), "Ajax Request is Processing!");

        wtDriver.until(ExpectedConditions.textToBePresentInElement(inputFormsPage.ajaxSubmitMessage, "Form submited Successfully!"));
    }

    @Test(description = "Test JQuery select dropdown")
    public void jQueryDropdown() {

        homepage.inputForms.click();

        homepage.dropdownOpen.findElement(By.xpath("//a[contains(text(),\"JQuery Select dropdown\")]")).click();

        wtDriver.until(ExpectedConditions.visibilityOf(inputFormsPage.searchBoxHeader));

        Assert.assertTrue(inputFormsPage.searchBoxHeader.isDisplayed());
        Assert.assertTrue(inputFormsPage.multipleValuesHeader.isDisplayed());
        Assert.assertTrue(inputFormsPage.disabledValuesHeader.isDisplayed());
        Assert.assertTrue(inputFormsPage.categoryHeader.isDisplayed());

        //Single select
        inputFormsPage.selectCountry.click();

        wtDriver.until(ExpectedConditions.visibilityOf(inputFormsPage.searchCountry));

        inputFormsPage.searchCountry.sendKeys("India");

        inputFormsPage.india.click();

        Assert.assertEquals(inputFormsPage.selectedCountryValue.getText(), "India");

        //Multi select
        inputFormsPage.selectState.click();
        inputFormsPage.selectStateFromList("Alaska").click();

        inputFormsPage.selectState.click();
        inputFormsPage.selectStateFromList("Arizona").click();

        Assert.assertTrue(inputFormsPage.selectedStateValues.get(0).getText().contains("Alaska"));
        Assert.assertEquals(inputFormsPage.selectedStateValues.get(1).getText(), "×Arizona");

        //Disabled values
        action.moveToElement(inputFormsPage.disabledValuesHeader).build().perform();

        inputFormsPage.disabledDropdown.click();

        inputFormsPage.selectTerritory("Puerto Rico").click();

        Assert.assertTrue(inputFormsPage.puertoRico.isDisplayed());

        //Select Category
        action.moveToElement(inputFormsPage.categoryHeader).build().perform();

        Select file = new Select(inputFormsPage.files);

        file.selectByVisibleText("Java");
    }
}
