package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InputFormsPage {

    WebDriver driver;

    //Simple Form Demo
    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Single Input Field\")]")
    public WebElement singleInputHeader;

    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Two Input Fields\")]")
    public WebElement twoInputHeader;

    @FindBy(css = "input#user-message")
    public WebElement inputMessage;

    @FindBy(xpath = "//button[contains(text(),\"Show Message\")]")
    public WebElement showMessageButton;

    @FindBy(id = "display")
    public WebElement displayMessage;

    @FindBy(id = "sum1")
    public WebElement sum1;

    @FindBy(id = "sum2")
    public WebElement sum2;

    @FindBy(xpath = "//button[contains(text(),\"Get Total\")]")
    public WebElement getTotalButton;

    @FindBy(id = "displayvalue")
    public WebElement totalSum;

    //Checkbox demo
    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Single Checkbox Demo\")]")
    public WebElement singleCheckboxHeader;

    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Multiple Checkbox Demo\")]")
    public WebElement multipleCheckboxHeader;

    @FindBy(id = "isAgeSelected")
    public WebElement clickOnThisCheckBox;

    @FindBy(id = "txtAge")
    public WebElement successMessageCheckbox;

    public WebElement multipleCheckBox(String option) {
        return driver.findElement(By.xpath("//label[contains(.,\"" + option + "\")]//input"));
    }

    @FindBy(css = "#check1[value=\"Check All\"]")
    public WebElement checkAllButton;

    @FindBy(css = "#check1[value=\"Uncheck All\"]")
    public WebElement unCheckAllButton;

    @FindBy(id = "isChkd")
    public WebElement isChecked;

    //Radio Button Demo
    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Radio Button Demo\")]")
    public WebElement radioButtonHeader;

    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Group Radio Buttons Demo\")]")
    public WebElement groupRadioButtonsHeader;

    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Radio Button Demo\")]//following-sibling::div//input[@value=\"Male\"]")
    public WebElement maleCheckbox1;

    @FindBy(id = "buttoncheck")
    public WebElement getCheckedValueButton;

    @FindBy(css = "p.radiobutton")
    public WebElement radioValue1;

    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Group Radio Buttons Demo\")]//following-sibling::div//input[@value=\"Female\"]")
    public WebElement femaleCheckbox2;

    public WebElement getAgeLimit(String value) {
        return driver.findElement(By.cssSelector("[value=\"" + value + "\"]"));
    }

    @FindBy(xpath = "//button[contains(text(),\"Get values\")]")
    public WebElement getValuesButton;

    @FindBy(css = "p.groupradiobutton")
    public WebElement radioValue2;

    //Select Dropdown
    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Select List Demo\")]")
    public WebElement selectListHeader;

    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Multi Select List Demo\")]")
    public WebElement multiSelectListHeader;

    @FindBy(id = "select-demo")
    public WebElement selectDayDropdown;

    @FindBy(css = "p.selected-value")
    public WebElement selectedDayValue;

    @FindBy(id = "multi-select")
    public WebElement multiSelectPlace;

    @FindBy(id = "printMe")
    public WebElement firstSelectedButton;

    @FindBy(id = "printAll")
    public WebElement getAllSelectedButton;

    @FindBy(css = "p.getall-selected")
    public WebElement selectedPlacesValue;

    //Input form
    @FindBy(xpath = "//legend[contains(text(),\"Contact Us Today!\")]")
    public WebElement contactUsHeader;

    @FindBy(css = "[name=\"first_name\"]")
    public WebElement firstName;

    @FindBy(css = "[name=\"last_name\"]")
    public WebElement lastName;

    @FindBy(css = "[name=\"email\"]")
    public WebElement email;

    @FindBy(css = "[name=\"phone\"]")
    public WebElement phone;

    @FindBy(css = "[name=\"address\"]")
    public WebElement address;

    @FindBy(css = "[name=\"city\"]")
    public WebElement city;

    @FindBy(css = "[name=\"state\"]")
    public WebElement state;

    @FindBy(css = "[name=\"zip\"]")
    public WebElement zip;

    @FindBy(css = "[name=\"website\"]")
    public WebElement website;

    @FindBy(css = "[value=\"no\"]")
    public WebElement noHosting;

    @FindBy(css = "[name=\"comment\"]")
    public WebElement comment;

    @FindBy(xpath = "//button[text()=\"Send \"]")
    public WebElement sendButton;

    //Ajax form
    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Ajax Form\")]")
    public WebElement ajaxFormHeader;

    @FindBy(name = "title")
    public WebElement ajaxName;

    @FindBy(id = "description")
    public WebElement ajaxComment;

    @FindBy(id = "btn-submit")
    public WebElement ajaxSubmit;

    @FindBy(css = "img[src=\"LoaderIcon.gif\"]")
    public WebElement ajaxLoaderIcon;

    @FindBy(id = "submit-control")
    public WebElement ajaxSubmitMessage;

    //JQuery dropdown
    @FindBy(xpath = "//h3[@class=\"panel-title\"][contains(text(),\"Drop Down with Search box\")]")
    public WebElement searchBoxHeader;

    @FindBy(xpath = "//h3[@class=\"panel-title\"][contains(text(),\" Select Multiple Values\")]")
    public WebElement multipleValuesHeader;

    @FindBy(xpath = "//h3[@class=\"panel-title\"][contains(text(),\"Drop Down with Disabled values\")]")
    public WebElement disabledValuesHeader;

    @FindBy(xpath = "//h3[@class=\"panel-title\"][contains(text(),\"Drop-down with Category related options\")]")
    public WebElement categoryHeader;

    @FindBy(xpath = "//span[@id=\"select2-country-container\"]//parent::span")
    public WebElement selectCountry;

    @FindBy(css = ".select2-search--dropdown .select2-search__field")
    public WebElement searchCountry;

    @FindBy(xpath = "//ul[@id=\"select2-country-results\"]//li[contains(@class,\"select2-results__option\")][contains(text(),\"India\")]")
    public WebElement india;

    @FindBy(id = "select2-country-container")
    public WebElement selectedCountryValue;

    @FindBy(css = ".select2-selection--multiple")
    public WebElement selectState;

    public WebElement selectStateFromList(String state) {
        return driver.findElement(By.xpath("//ul[@class=\"select2-results__options\"]//li[@class=\"select2-results__option\"][contains(text(),\"" + state + "\")]"));
    }

    @FindBy(css = ".select2-selection__choice")
    public List<WebElement> selectedStateValues;

    @FindBy(xpath = "//label[text()=\"Select US Outlying Territories :\"]//following-sibling::span[contains(@class,\"select2-container\")]")
    public WebElement disabledDropdown;

    public WebElement selectTerritory(String territory) {
        return driver.findElement(By.xpath("//span[@class=\"select2-results\"]//li[@class=\"select2-results__option\"][contains(text(),\"" + territory + "\")]"));
    }

    @FindBy(css = "[title=\"Puerto Rico\"]")
    public WebElement puertoRico;

    @FindBy(id = "files")
    public WebElement files;

    public InputFormsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
