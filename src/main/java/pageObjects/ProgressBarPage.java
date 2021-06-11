package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBarPage {

    WebDriver driver;

    //Jquery UI progress bar
    @FindBy(id = "downloadButton")
    public WebElement downloadButton;

    @FindBy(id = "progressbar")
    public WebElement progressBar;

    @FindBy(css = ".progress-label")
    public WebElement progressLabel;

    @FindBy(xpath = "//button[text()=\"Close\"]")
    public WebElement closeButton;

    //Drag and drop sliders
    @FindBy(css = "#slider1 input[name=\"range\"]")
    public WebElement slider1;

    @FindBy(css = "#slider1 #range")
    public WebElement slider1Range;

    @FindBy(css = "#slider2 input[name=\"range\"]")
    public WebElement slider2;

    @FindBy(css = "#slider2 #rangePrimary")
    public WebElement slider2Range;

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
