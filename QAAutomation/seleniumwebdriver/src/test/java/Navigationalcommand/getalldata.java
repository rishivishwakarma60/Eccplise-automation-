package Navigationalcommand;


////
////import java.time.Duration;
////import java.util.List;
////
////import org.openqa.selenium.By;
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.WebElement;
////import org.openqa.selenium.chrome.ChromeDriver;
////import org.openqa.selenium.support.ui.ExpectedConditions;
////import org.openqa.selenium.support.ui.WebDriverWait;
////
////public class getalldata {
////
////    public static void main(String[] args) {
////        WebDriver driver = new ChromeDriver();
////
////        driver.get("https://testautomationpractice.blogspot.com/");
////        driver.manage().window().maximize();
////
////        // myWait setup
////        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
////
////        // 1) Optional search – skipped, no search box
////
////        // 2) Count number of links
////        List<WebElement> links = driver.findElements(By.tagName("a"));
////        System.out.println("Total number of links: " + links.size());
////
////        // 3) Loop through and click each link
////        for (int i = 0; i < links.size(); i++) {
////            // Re-locate all links (DOM might reload)
////            links = driver.findElements(By.tagName("a"));
////            WebElement link = links.get(i);
////
////            String linkText = link.getText().trim();
////            if (linkText.isEmpty()) continue;
////
////            try {
////                System.out.println("Clicking on: " + linkText);
////
////                // Wait for the link to be clickable and click
////                myWait.until(ExpectedConditions.elementToBeClickable(link)).click();
////
////                // Wait for page title or URL change (optional)
////                myWait.until(ExpectedConditions.or(
////                        ExpectedConditions.urlContains("blogspot"),
////                        ExpectedConditions.presenceOfElementLocated(By.tagName("body"))
////                ));
////
////                System.out.println("Visited: " + driver.getCurrentUrl());
////
////                // 4) Use navigate().back() to return to the original page
////                driver.navigate().back();
////
////                // 5) Wait until we're back and ready to proceed
////                myWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));
////
////            } catch (Exception e) {
////                System.out.println("Failed to click: " + linkText);
////                driver.navigate().back(); // Safe fallback
////            }
////        }
////
////        driver.quit();
////    }
////}
//
//
//package Navigationalcommand;
//
//import java.util.List;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class getalldata {
//
//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://testautomationpractice.blogspot.com/");
//        driver.manage().window().maximize();
//
//        // Find all anchor <a> tags
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//
//        System.out.println("Total number of links on the page: " + links.size());
//
//        // Optional: Print link text + URL
//        for (WebElement link : links) {
//            String text = link.getText().trim();
//            String href = link.getAttribute("href");
//
//            // Show only meaningful links
//            if (href != null && !href.isEmpty()) {
//                System.out.println("Link Text: " + text + " → URL: " + href);
//            }
//        }
//
//        driver.quit();
//    }
//}


//package Navigationalcommand;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class getalldata {
//
//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Set base URL
//        String homePage = "https://globalhospital.co/";
//        driver.get(homePage);
//        driver.manage().window().maximize();
//
//        // Get all <a> tags
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//        System.out.println("Total links: " + links.size());
//
//        for (int i = 0; i < links.size(); i++) {
//            // Re-fetch links after each load to avoid stale elements
//            links = driver.findElements(By.tagName("a"));
//            WebElement link = links.get(i);
//            String linkText = link.getText().trim();
//            String href = link.getAttribute("href");
//
//            // Skip empty or broken links
//            if (href == null || href.isEmpty()) continue;
//
//            System.out.println("\nVisiting Link " + (i + 1) + ": " + linkText);
//            try {
//                // Open the link
//                myWait.until(ExpectedConditions.elementToBeClickable(link)).click();
//
//                // Wait for page to load (body should be visible)
//                myWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//                System.out.println("Visited URL: " + driver.getCurrentUrl());
//
//            } catch (Exception e) {
//                System.out.println("❌ Error visiting link: " + linkText);
//            }
//         // Return to homepage again (force reload)
//            try {
//                driver.get(homePage);
//                myWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));
//                System.out.println("🔙 Returned to home page.");
//            } catch (Exception e) {
//                System.out.println("⚠️ Failed to return to home. Reloading...");
//                driver.navigate().to(homePage);
//            }
//        }
//
//        System.out.println("\n✅ All links visited successfully.");
//        driver.quit();
//    }
//}

//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.*;
//
//public class getalldata {
//
//    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        String homePage = "https://global.srashtasoft.in/";
//        driver.get(homePage);
//        driver.manage().window().maximize();
//
//        // Collect all valid <a> links
//        List<WebElement> rawLinks = driver.findElements(By.tagName("a"));
//        List<String> linkTexts = new ArrayList<>();
//        List<String> linkHrefs = new ArrayList<>();
//
//        for (WebElement link : rawLinks) {
//            String href = link.getAttribute("href");
//            String text = link.getText().trim();
//
//            if (href == null || href.isEmpty()) continue;
//            if (href.startsWith("mailto:") || href.startsWith("tel:")) continue;
//            if (!link.isDisplayed() || !link.isEnabled()) continue;
//
//            linkTexts.add(text);
//            linkHrefs.add(href);
//        }
//
//        System.out.println("Total valid links: " + linkHrefs.size());
//
//        for (int i = 0; i < linkHrefs.size(); i++) {
//            String href = linkHrefs.get(i);
//            String linkText = linkTexts.get(i);
//
//            System.out.println("\n🔗 Link Text: " + linkText);
//            System.out.println("🌐 Link URL: " + href);
//
//            try {
//                // Open the link directly using href
//                driver.get(href);
//                Thread.sleep(1000); // Wait a bit for any potential alert
//
//                // ⚠️ Handle alert if present
//                try {
//                    Alert alert = driver.switchTo().alert();
//                    System.out.println("⚠️ Alert detected: " + alert.getText());
//                    alert.dismiss(); // or alert.accept();
//                    System.out.println("✅ Alert dismissed.");
//                } catch (NoAlertPresentException e) {
//                    // No alert found
//                }
//
//                // Wait for body to load
//                myWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//                System.out.println("✅ Visited URL: " + driver.getCurrentUrl());
//
//            } catch (Exception e) {
//                System.out.println("❌ Error visiting link: " + linkText + " - " + e.getMessage());
//            }
//
//            // Go back to home page after each visit
//            try {
//                driver.get(homePage);
//                myWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));
//                System.out.println("🔙 Returned to home page.");
//            } catch (Exception e) {
//                System.out.println("⚠️ Failed to return to home. Retrying...");
//                driver.navigate().to(homePage);
//            }
//        }
//
//        System.out.println("\n✅ All links visited successfully.");
//        driver.quit();
//    }
//}



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class getalldata {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String homePage = "https://global.srashtasoft.in/";
        driver.get(homePage);
        driver.manage().window().maximize();

        // Step 1: Collect all <a> tags
        List<WebElement> rawLinks = driver.findElements(By.tagName("a"));
        System.out.println("🔍 Total <a> tags found: " + rawLinks.size());

        // Counters for skipped links
        int skippedEmpty = 0, skippedTel = 0, skippedMail = 0, skippedInvisible = 0;

        // Valid links to process
        List<String> linkTexts = new ArrayList<>();
        List<String> linkHrefs = new ArrayList<>();

        for (WebElement link : rawLinks) {
            String href = link.getAttribute("href");
            String text = link.getText().trim();

            if (href == null || href.isEmpty()) {
                System.out.println("⏭️ Skipping: Empty href");
                skippedEmpty++;
                continue;
            }

            if (href.startsWith("mailto:")) {
                System.out.println("⏭️ Skipping mailto link: " + href);
                skippedMail++;
                continue;
            }

            if (href.startsWith("tel:")) {
                System.out.println("⏭️ Skipping tel link: " + href);
                skippedTel++;
                continue;
            }

            if (!link.isDisplayed() || !link.isEnabled()) {
                System.out.println("⏭️ Skipping invisible/disabled link: " + href);
                skippedInvisible++;
                continue;
            }

            // Add to valid list
            linkTexts.add(text);
            linkHrefs.add(href);
        }

        System.out.println("\n✅ Total valid links to visit: " + linkHrefs.size());
        System.out.println("⛔ Skipped empty href: " + skippedEmpty);
        System.out.println("⛔ Skipped mailto: " + skippedMail);
        System.out.println("⛔ Skipped tel: " + skippedTel);
        System.out.println("⛔ Skipped invisible/disabled: " + skippedInvisible);

        // Step 2: Visit all valid links
        for (int i = 0; i < linkHrefs.size(); i++) {
            String href = linkHrefs.get(i);
            String linkText = linkTexts.get(i);

            System.out.println("\n🔗 Link Text: " + (linkText.isEmpty() ? "[No Text]" : linkText));
            System.out.println("🌐 Link URL: " + href);

            try {
                // Open link
                driver.get(href);
                Thread.sleep(1000); // Wait for alert if any

                // 🔔 Handle alert
                try {
                    Alert alert = driver.switchTo().alert();
                    System.out.println("⚠️ Alert detected: " + alert.getText());
                    alert.dismiss(); // or alert.accept()
                    System.out.println("✅ Alert dismissed.");
                } catch (NoAlertPresentException e) {
                    // No alert present
                }

                // Wait for content
                myWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
                System.out.println("✅ Visited URL: " + driver.getCurrentUrl());

            } catch (Exception e) {
                System.out.println("❌ Error visiting link: " + linkText + " - " + e.getMessage());
            }

            // Return to home page
            try {
                driver.get(homePage);
                myWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));
                System.out.println("🔙 Returned to home page.");
            } catch (Exception e) {
                System.out.println("⚠️ Failed to return to home. Retrying...");
                driver.navigate().to(homePage);
            }
        }
         

        System.out.println("\n🏁 Test completed. Closing browser.");
        driver.quit();
    }
}









