package SrashtaSoft_mainWebsite;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class FullWebsiteLinkTest {
	  WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        // Replace with your actual path or set ChromeDriver to PATH
	   

	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();

	        // Open the website
	        driver.get("https://www.cosmicairmatics.com/");
	    }

	    @Test
	    public void verifyAllLinks() {
	        List<WebElement> links = driver.findElements(By.tagName("a"));
	        System.out.println("🔗 Total links found: " + links.size());

	        for (int i = 0; i < links.size(); i++) {
	            try {
	                WebElement link = links.get(i);
	                String url = link.getAttribute("href");

	                if (url == null || url.startsWith("javascript") || url.startsWith("mailto") || url.startsWith("tel")) {
	                    continue;
	                }

	                System.out.println("\n▶ Visiting: " + url);
	                driver.get(url);

	                String title = driver.getTitle();
	                if (!title.isEmpty()) {
	                    System.out.println("✅ Page loaded successfully: " + title);
	                } else {
	                    System.out.println("⚠️ Warning: Page title is empty.");
	                }

	                // Go back to home and re-fetch links
	                driver.get("https://www.cosmicairmatics.com/");
	                links = driver.findElements(By.tagName("a"));

	            } catch (Exception e) {
	                System.out.println("❌ Error visiting link: " + e.getMessage());
	            }
	        }
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            System.out.println("\n🛑👌 Browser closed.");
	        }
	    }
	}