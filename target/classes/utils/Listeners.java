package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listeners extends TestListenerAdapter {

    ExtentReports extent; //Specify the location of the report
    ExtentTest test; //Specify the body of the report

    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
    Date date = new Date();
    String actualDate = format.format(date);

    @Override
    public void onTestStart(ITestResult tr) {

        //before each test case
        test = extent.startTest(tr.getMethod().getMethodName());
        ExtentFactory.getInstance().setExtent(test);
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        ExtentFactory.getInstance().getExtent().log(LogStatus.PASS, "Test Case: " + tr.getMethod().getMethodName() + " is Passed.");
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        ExtentFactory.getInstance().getExtent().log(LogStatus.FAIL, "Test Case: " + tr.getMethod().getMethodName() + " is Failed.");
        ExtentFactory.getInstance().getExtent().log(LogStatus.FAIL, tr.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        ExtentFactory.getInstance().getExtent().log(LogStatus.SKIP, "Test Case: " + tr.getMethod().getMethodName() + " is Skipped.");
    }

    @Override
    public void onStart(ITestContext ts) {

        extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReports_" + actualDate + ".html", true);

        extent.addSystemInfo("User", "Abhisek");

        extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
    }

    @Override
    public void onFinish(ITestContext ts) {
        extent.flush();
    }
}
