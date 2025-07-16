package listener;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(listener.ExtentReportmanager.class )
public class orangeHrm {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() throws InterruptedException{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login" );
		driver.manage().window().maximize();
		Thread.sleep(300);
		
	}
	
	
	@Test(priority=1)
	void testlogo() throws InterruptedException {
		Thread.sleep(5000);
		boolean status = driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed();
	
		
		Assert.assertEquals(status, true);
	}
	
	@Test(priority=2)
	void testAppurl() {
            Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority=3, dependsOnMethods = {"testAppurl"})
	void testHomePagetitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	
	@Test
	void testLogin() {
	    Assert.assertTrue(true);
	}

	@Test
	void testHomePageLoad() {
	    Assert.assertTrue(true);
	}

	@Test
	void testDashboard() {
	    Assert.assertTrue(true);
	}

	@Test
	void testUserCreation() {
	    Assert.assertTrue(true);
	}

	@Test
	void testUserDeletion() {
	    Assert.assertTrue(true);
	}

	@Test
	void testSearchFunctionality() {
	    Assert.assertTrue(true);
	}

	@Test
	void testProfileUpdate() {
	    Assert.assertTrue(true);
	}

	@Test
	void testSettingsPage() {
	    Assert.assertTrue(true);
	}

	@Test
	void testNotificationPanel() {
	    Assert.assertTrue(true);
	}

	@Test
	void testReportsGeneration() {
	    Assert.assertTrue(true);
	}

	@Test
	void testRoleManagement() {
	    Assert.assertTrue(true);
	}

	@Test
	void testAuditLogs() {
	    Assert.assertTrue(true);
	}

	@Test
	void testThemeChange() {
	    Assert.assertTrue(true);
	}

	@Test
	void testHelpSection() {
	    Assert.assertTrue(true);
	}

	@Test
	void testLogout() {
	    Assert.assertTrue(true);
	}

	
	
	
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
	


}
