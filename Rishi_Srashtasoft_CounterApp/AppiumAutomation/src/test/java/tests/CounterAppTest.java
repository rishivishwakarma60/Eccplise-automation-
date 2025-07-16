package tests;

import java.net.URI;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CounterAppTest {
    @Test
    public void clickPlusButton() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.example.counter_app")
                .setAppActivity("com.example.counter_app.MainActivity");

        AndroidDriver driver = new AndroidDriver(
                URI.create("http://localhost:4723/wd/hub").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Click the "+" button
        WebElement plusButton = driver.findElement(AppiumBy.xpath("//android.widget.Button"));
        plusButton.click();

        // Optionally, quit the driver
        driver.quit();
    }
}