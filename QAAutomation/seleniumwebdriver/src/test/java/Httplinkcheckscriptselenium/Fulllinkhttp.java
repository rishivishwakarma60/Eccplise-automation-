
//Remember that the link checker with visiting page properly is  in SrashtaSoftMAinWebsite 
package Httplinkcheckscriptselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Fulllinkhttp {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.cosmicairmatics.com/");
	}

	@Test
	public void verifyAllLinksFastWithSummary() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("🔗 Total links found: " + links.size());

		int totalChecked = 0;
		int brokenLinks = 0;
		int skippedLinks = 0;

		List<String> brokenLinkList = new ArrayList<>();

		for (WebElement link : links) {
			String url = link.getAttribute("href");

			if (url == null || url.startsWith("javascript") || url.startsWith("mailto") || url.startsWith("tel")) {
				skippedLinks++;
				continue;
			}

			try {
				HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
				connection.setConnectTimeout(3000);
				connection.connect();
				int statusCode = connection.getResponseCode();

				totalChecked++;

				if (statusCode >= 200 && statusCode < 400) {
					System.out.println("✅ " + url + " - Status: " + statusCode);
				} else {
					System.out.println("❌ " + url + " - Broken (Status: " + statusCode + ")");
					brokenLinks++;
					brokenLinkList.add(url);
				}

			} catch (Exception e) {
				System.out.println("❌ " + url + " - Exception: " + e.getMessage());
				brokenLinks++;
				totalChecked++;
				brokenLinkList.add(url);
			}
		}

		// 🔚 Print Summary
		System.out.println("\n===== 🔍 Link Check Summary =====");
		System.out.println("🔗 Total Links Found     : " + links.size());
		System.out.println("✅ Total Checked         : " + totalChecked);
		System.out.println("❌ Total Broken Links    : " + brokenLinks);
		System.out.println("⚠️ Skipped (mailto/tel)  : " + skippedLinks);

		if (!brokenLinkList.isEmpty()) {
			System.out.println("\n❌ Broken Link List:");
			for (String broken : brokenLinkList) {
				System.out.println("   - " + broken);
			}
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("\n🛑 Browser closed.");
		}
	}
}
