package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsAndModalPage {

    WebDriver driver;

    //Bootstrap alert
    @FindBy(xpath = "//h2[contains(text(),\"Bootstrap Alert messages\")]")
    public WebElement bootstrapAlertHeader;

    @FindBy(id = "normal-btn-success")
    public WebElement normalSuccessMessage;

    @FindBy(css = ".alert.alert-success.alert-normal-success")
    public WebElement normalSuccessMessageContent;

    @FindBy(css = ".alert.alert-success.alert-normal-success .close")
    public WebElement normalSuccessMessageClose;

    //Bootstrap modals
    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Single Modal Example\")]")
    public WebElement singleModalHeader;

    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Multiple Modal Example\")]")
    public WebElement multipleModalHeader;

    @FindBy(xpath = "//a[@href=\"#myModal0\"]")
    public WebElement singleLaunchModalButton;

    @FindBy(css = "#myModal0 .modal-content")
    public WebElement modal1;

    @FindBy(xpath = "//div[@id=\"myModal0\"]//a[contains(text(),\"Close\")]")
    public WebElement modal1Close;

    @FindBy(xpath = "//a[@href=\"#myModal\"]")
    public WebElement multiLaunchModalButton;

    @FindBy(css = "#myModal .modal-content")
    public WebElement modal2;

    @FindBy(css = "#myModal [href=\"#myModal2\"]")
    public WebElement multiInsideLaunchModalButton;

    @FindBy(css = "#myModal2 .modal-content")
    public WebElement modal3;

    @FindBy(xpath = "//div[@id=\"myModal2\"]//a[contains(text(),\"Close\")]")
    public WebElement modal3Close;

    @FindBy(xpath = "//div[@id=\"myModal\"]//a[contains(text(),\"Close\")]")
    public WebElement modal2Close;

    //Window Popup
    @FindBy(xpath = "//h3[@class=\"panel-title\"][contains(text(),\"Single Window Popup\")]")
    public WebElement singleWindowPopHeader;

    @FindBy(xpath = "//h3[@class=\"panel-title\"][contains(text(),\"Multiple Window Modal\")]")
    public WebElement multiWindowPopHeader;

    @FindBy(css = "a[title=\"Follow @seleniumeasy on Twitter\"]")
    public WebElement twitterFollow;

    @FindBy(css = "a[title=\"Follow @seleniumeasy on Facebook\"]")
    public WebElement facebookFollow;

    @FindBy(id = "followall")
    public WebElement followAll;

    public AlertsAndModalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
