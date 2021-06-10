package utils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageObjects.*;

public class PageObjects extends BaseUtils{

    protected Homepage homepage;
    protected InputFormsPage inputFormsPage;
    protected DatePickersPage datePickersPage;

    @BeforeClass
    @BeforeMethod
    /*
     * Creates objects for all the PageObjects under PageFactory
     */
    public void beforeMethodPageObjects() {

        homepage = new Homepage(driver);
        inputFormsPage = new InputFormsPage(driver);
        datePickersPage = new DatePickersPage(driver);
    }
}
