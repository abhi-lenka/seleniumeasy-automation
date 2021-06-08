package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    //checkbox demo
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

    public InputFormsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
