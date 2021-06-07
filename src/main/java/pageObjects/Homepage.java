package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    WebDriver driver;

    @FindBy(id = "site-slogan")
    public WebElement SiteSlogan;

    @FindBy(css = "[id=\"site-name\"] [title=\"Home\"]")
    public WebElement siteNameTitle;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
