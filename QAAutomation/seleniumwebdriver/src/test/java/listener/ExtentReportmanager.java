package listener;
import org.testng.ITestListener;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportmanager implements ITestListener {

    public ExtentSparkReporter sparkReporter;  // UI of the report 
    public ExtentReports extent;  // populate common info into the report 
    public ExtentTest test;  //creating test cases entry in the report 

    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Rishiraj");
        extent.setSystemInfo("Organization Name", "SrashtaSoft");
        extent.setSystemInfo("OS", "Windows10");
        extent.setSystemInfo("Browser name", "Chrome");
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test case PASSED is: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is: " + result.getName());
        test.log(Status.FAIL, "Test case FAILED cause is: " + result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is: " + result.getName());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
