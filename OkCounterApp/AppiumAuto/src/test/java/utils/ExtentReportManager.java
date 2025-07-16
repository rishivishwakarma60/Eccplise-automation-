package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Set timestamp for the report name
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String reportPath = "test-output/ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setDocumentTitle("Automation Test Report - Counter App");
            reporter.config().setReportName("Appium Test Report");
            reporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            // Add system/environment info
            extent.setSystemInfo("Tester Name", "Rishiraj Vishwakarma");
            extent.setSystemInfo("Company", "Srashta Soft");
            extent.setSystemInfo("Execution Date", new SimpleDateFormat("dd MMM yyyy").format(new Date()));
            extent.setSystemInfo("Execution Time", new SimpleDateFormat("hh:mm:ss a").format(new Date()));
            extent.setSystemInfo("Platform", "Windows 11");
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
        return extent;
    }
}
