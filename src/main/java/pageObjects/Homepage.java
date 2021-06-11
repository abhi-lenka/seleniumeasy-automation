package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    WebDriver driver;

    @FindBy(id = "at-cv-lightbox-win")
    public WebElement adModal;

    @FindBy(id = "at-cv-lightbox-close")
    public WebElement adModalClose;

    @FindBy(id = "site-slogan")
    public WebElement SiteSlogan;

    @FindBy(css = "[id=\"site-name\"] [title=\"Home\"]")
    public WebElement siteNameTitle;

    @FindBy(id = "home_bar")
    public WebElement homeBarIcon;

    @FindBy(css = "#home .head.text-center")
    public WebElement homeBarDescription;

    @FindBy(xpath = "//div[@id=\"home\"]//a[text()=\" Start Practising \"]")
    public WebElement startPractisingButton;

    @FindBy(id = "basic_example")
    public WebElement basicBarIcon;

    @FindBy(css = "#basic .head.text-center")
    public WebElement basicBarDescription;

    @FindBy(xpath = "//div[@id=\"basic\"]//a[text()=\"Proceed Next\"]")
    public WebElement basicProceedNextButton;

    @FindBy(id = "inter_example")
    public WebElement interBarIcon;

    @FindBy(css = "#intermediate .head.text-center")
    public WebElement interBarDescription;

    @FindBy(xpath = "//div[@id=\"intermediate\"]//a[text()=\"Proceed Next\"]")
    public WebElement interProceedNextButton;

    @FindBy(id = "advanced_example")
    public WebElement advanceBarIcon;

    @FindBy(css = "#advanced .head.text-center")
    public WebElement advanceBarDescription;

    @FindBy(xpath = "//div[@id=\"advanced\"]//a[text()=\" Proceed Next \"]")
    public WebElement advanceProceedNextButton;

    @FindBy(id = "done_example")
    public WebElement doneBarIcon;

    @FindBy(css = "#completed .head.text-center")
    public WebElement doneBarDescription;

    @FindBy(xpath = "//div[@id=\"navbar-brand-centered\"]//a[contains(text(),\"Input Forms\")]")
    public WebElement inputForms;

    @FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[2]/a")
    public WebElement datePickers;

    @FindBy(xpath = "//div[@id=\"navbar-brand-centered\"]//a[contains(text(),\"Progress Bars\")]")
    public WebElement progressBars;

    @FindBy(xpath = "//div[@id=\"navbar-brand-centered\"]//a[contains(text(),\"Alerts & Modals\")]")
    public WebElement alertModalBars;

    @FindBy(css = ".dropdown.open .dropdown-menu")
    public WebElement dropdownOpen;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
