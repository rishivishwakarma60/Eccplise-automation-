package datadriven;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class icicicalculator {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");

        String filepath = "D:\\QAAutomation\\seleniumwebdriver\\testdata\\Book1.xlsx";
        int rows = takingfromexcel.getRowCount(filepath, "Sheet1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Read data from Excel
        for (int i = 1; i <= rows; i++) {

            String deposit = takingfromexcel.getCellData(filepath, "Sheet1", i, 0);
            String length = takingfromexcel.getCellData(filepath, "Sheet1", i, 1);
            String rate = takingfromexcel.getCellData(filepath, "Sheet1", i, 2);
            String total = takingfromexcel.getCellData(filepath, "Sheet1", i, 4);
            String expected = takingfromexcel.getCellData(filepath, "Sheet1", i, 5);

            // Input values
            WebElement dep = driver.findElement(By.id("mat-input-0"));
            dep.clear();
            dep.sendKeys(deposit);

            WebElement len = driver.findElement(By.id("mat-input-1"));
            len.clear();
            len.sendKeys(length);

            WebElement ra = driver.findElement(By.id("mat-input-2"));
            ra.clear();
            ra.sendKeys(rate);

            // Skip dropdown selection – rely on default value (e.g., "Compounded Monthly")

            // Click the "Let's run the numbers" button
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("CIT-chart-submit")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

            // Fetch result
            String act_value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("displayTotalValue"))).getText();

            // Normalize and compare
            if (act_value.replace("$", "").replace(",", "").trim()
                    .equals(total.replace("$", "").replace(",", "").trim())) {
                System.out.println("Test Passed");
                takingfromexcel.setCellData(filepath, "Sheet1", i, 6, "Passed");
            } else {
                System.out.println("Test Failed");
                takingfromexcel.setCellData(filepath, "Sheet1", i, 6, "Failed");
            }
        }

        driver.quit(); // Close the browser
    }
}
