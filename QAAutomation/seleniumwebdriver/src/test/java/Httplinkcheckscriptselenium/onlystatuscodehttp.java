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


public class onlystatuscodehttp{ 
	 WebDriver driver;

	    // A helper class to hold both URL and its anchor text
	    class LinkInfo {
	        String href;
	        String text;

	        LinkInfo(String href, String text) {
	            this.href = href;
	            this.text = text;
	        }
	    }

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://www.cosmicairmatics.com/");
	    }

	    @Test
	    public void verifyAllLinksFastWithSummary() {
	        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
	        List<LinkInfo> linksToTest = new ArrayList<>();

	        for (WebElement element : linkElements) {
	            String url = element.getAttribute("href");
	            String text = element.getText().trim();

	            if (url != null && !url.startsWith("javascript") && !url.startsWith("mailto") && !url.startsWith("tel")) {
	                linksToTest.add(new LinkInfo(url, text.isEmpty() ? "[No Text]" : text));
	            }
	        }

	        System.out.println("🔗 Total valid links to test: " + linksToTest.size());

	        int totalChecked = 0;
	        int brokenLinks = 0;
	        int skippedLinks = linkElements.size() - linksToTest.size();

	        List<String> brokenLinkList = new ArrayList<>();

	        for (LinkInfo linkInfo : linksToTest) {
	            System.out.println("\n▶ Visiting: " + linkInfo.href);
	            System.out.println("🔹 Link Text: " + linkInfo.text);

	            try {
	                HttpURLConnection connection = (HttpURLConnection) (new URL(linkInfo.href).openConnection());
	                connection.setConnectTimeout(3000);
	                connection.connect();
	                int statusCode = connection.getResponseCode();

	                totalChecked++;

	                if (statusCode >= 200 && statusCode < 400) {
	                    System.out.println("✅ Page is valid - Status: " + statusCode);

	                    // Load page and get title
	                    driver.get(linkInfo.href);
	                    String title = driver.getTitle();
	                    System.out.println("📄 Visiting page: " + title);

	                    // Return to home page
	                    driver.get("https://www.cosmicairmatics.com/");
	                } else {
	                    System.out.println("❌ Broken page - Status: " + statusCode);
	                    brokenLinks++;
	                    brokenLinkList.add(linkInfo.href);
	                }

	            } catch (Exception e) {
	                System.out.println("❌ Exception while visiting: " + e.getMessage());
	                brokenLinks++;
	                totalChecked++;
	                brokenLinkList.add(linkInfo.href);

	                // Return to home page after failure
	                try {
	                    driver.get("https://www.cosmicairmatics.com/");
	                } catch (Exception ignore) {}
	            }
	        }

	        // 🔚 Summary
	        System.out.println("\n===== 🔍 Link Check Summary =====");
	        System.out.println("🔗 Total Links Found     : " + linkElements.size());
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