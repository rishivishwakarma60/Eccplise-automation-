package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CounterIncrementTest {

    public AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("12151314A1123898"); // Replace with your device ID
        options.setAppPackage("com.example.counter_app");
        options.setAppActivity(".MainActivity");
        options.setAutomationName("UiAutomator2");
        options.setNoReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("✅ App launched successfully");
    }

    @Test
    public void testCounterIncrement() {
        System.out.println("🔎 Locating the plus button...");
        WebElement plusButton = driver.findElement(AppiumBy.xpath("//android.widget.Button"));

        int expectedValue = 0;
        for (int i = 0; i < 3; i++) {
            plusButton.click();
            expectedValue++;
            System.out.println("➕ Clicked plus button, current expected value: " + expectedValue);

            // Wait briefly to let UI update
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Locate the counter value element
        String valueXPath = "//android.view.View[@content-desc='" + expectedValue + "']";
        WebElement valueElement = driver.findElement(AppiumBy.xpath(valueXPath));

        String actualValue = valueElement.getAttribute("content-desc");
        System.out.println("✅ Actual value found: " + actualValue);

        Assert.assertEquals(actualValue, String.valueOf(expectedValue), "❌ Counter value mismatch!");
        System.out.println("✅ Test passed! Counter value matched: " + expectedValue);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🛑 Driver session ended");
            
        }
    }
}
