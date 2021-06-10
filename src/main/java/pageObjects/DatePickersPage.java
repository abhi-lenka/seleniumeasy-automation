package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PageObjects;
import utils.TestUtils;

import java.util.Calendar;
import java.util.Date;

public class DatePickersPage extends PageObjects {

    WebDriver driver;
    TestUtils tu = new TestUtils();

    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Date Example :\")]")
    public WebElement dateHeader;

    @FindBy(xpath = "//div[@class=\"panel-heading\"][contains(text(),\"Date Range Example :\")]")
    public WebElement dateRangeHeader;

    @FindBy(css = ".input-group.date input")
    public WebElement singleInputDate;

    @FindBy(css = "#sandbox-container1 .input-group-addon")
    public WebElement dateAddon1;

    @FindBy(css = ".datepicker-days th.clear")
    public WebElement clear;

    @FindBy(css = ".datepicker-days th.today")
    public WebElement today;

    @FindBy(css = "input[placeholder=\"Start date\"]")
    public WebElement startDate;

    @FindBy(css = "input[placeholder=\"End date\"]")
    public WebElement endDate;

    public void selectDate(WebElement datePickerLocator, Date givenDate) {

        Date date;
        int day, month, year;

        date = new Date(givenDate.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        datePickerLocator.click();

        WebElement chooseMonthAndYear = driver.findElement(By.cssSelector(".datepicker .datepicker-days .datepicker-switch"));

        chooseMonthAndYear.click();

        WebElement chooseYear = driver.findElement(By.xpath("//div[contains(@class,\"datepicker\")]//div[contains(@class,\"datepicker-months\")]//th[contains(@class,\"datepicker-switch\")]"));

        chooseYear.click();

        WebElement selectYear = driver.findElement(By.xpath("//div[contains(@class,\"datepicker\")]//span[contains(@class,\"year\")][contains(text(),\"" + year + "\")]"));

        if (!(tu.isElementDisplayed(selectYear))) {

            WebElement firstYearInModal = driver.findElement(By.cssSelector(".year.old"));
            WebElement lastYearInModal = driver.findElement(By.cssSelector(".year.new"));

            int firstYear = Integer.parseInt(firstYearInModal.getText());
            int lastYear = Integer.parseInt(lastYearInModal.getText());

            int diff, numberOfClicks;
            if (firstYear > year) {
                diff = firstYear - year;
                numberOfClicks = (diff / 25) + 1;
                for (int i = 1; i <= numberOfClicks; i++) {

                    WebElement previousArrow = driver.findElement(By.cssSelector(".datepicker .datepicker-years th.prev"));

                    previousArrow.click();
                }
            } else if (lastYear < year) {
                diff = year - lastYear;
                numberOfClicks = (diff / 25) + 1;
                for (int i = 1; i <= numberOfClicks; i++) {

                    WebElement nextArrow = driver.findElement(By.cssSelector(".datepicker .datepicker-years th.next"));

                    nextArrow.click();
                }
            }
        }

        selectYear.click();

        WebElement selectMonth = driver.findElement(By.xpath("//div[@class=\"datepicker-months\"]//span[contains(@class,\"month\")][contains(text(),\"" + MONTHS[month] + "\")]"));
        selectMonth.click();

        WebElement selectDate = driver.findElement(By.xpath("//div[@class=\"datepicker-days\"]//td[contains(@class,\"day\")][contains(text(),\"" + day + "\")]"));
        selectDate.click();
    }

    public DatePickersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
