package purveshbhaicmapp;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BrokenLinkChecker {
    static WebDriver driver;
    static Set<String> visitedLinks = new HashSet<>();
    static Workbook workbook = new XSSFWorkbook();
    static Sheet sheet = workbook.createSheet("Link Report");
    static int rowCount = 0;

    public static void main(String[] args) throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String homePage = "https://developer.srashtasoft.com/projects/cosmicairmatics/";
        driver.get(homePage);

        // Add headers to Excel
        Row header = sheet.createRow(rowCount++);
        header.createCell(0).setCellValue("Link");
        header.createCell(1).setCellValue("Status");

        checkLinksOnPage(homePage, 0);

        FileOutputStream fileOut = new FileOutputStream("BrokenLinkReport.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

        driver.quit();
        System.out.println("✅ Scan complete. Report saved to BrokenLinkReport.xlsx");
    }

    public static void checkLinksOnPage(String pageUrl, int depth) {
        if (depth > 2) return; // Limit recursion depth

        try {
            driver.get(pageUrl);
            Thread.sleep(1000); // Wait for page to load

            List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));

            for (WebElement link : links) {
                String href = link.getAttribute("href");

                if (href != null && (href.startsWith("http") || href.startsWith("https")) && !visitedLinks.contains(href)) {
                    visitedLinks.add(href);
                    System.out.println("🔎 Checking: " + href);

                    String status = isLinkBroken(href) ? "❌ Broken" : "✅ Valid";
                    System.out.println(status + ": " + href);

                    // Write to Excel
                    Row row = sheet.createRow(rowCount++);
                    row.createCell(0).setCellValue(href);
                    row.createCell(1).setCellValue(status);

                    // Recursively check links
                    if (!status.contains("Broken")) {
                        checkLinksOnPage(href, depth + 1);
                    }

                    // Go back to current page
                    driver.get(pageUrl);
                    Thread.sleep(1000);
                }
            }

        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }

    public static boolean isLinkBroken(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
            connection.setRequestMethod("HEAD");
            connection.connect();
            int code = connection.getResponseCode();
            return (code >= 400);
        } catch (Exception e) {
            return true;
        }
    }
}
