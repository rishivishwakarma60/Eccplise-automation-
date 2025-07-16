package Navigationalcommand;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class navigation {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		
		WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(10));
//		driver.get("https://testautomationpractice.blogspot.com/");
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");

//	driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).click();

//	driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("jai ho");
//	driver.navigate().refresh();
//	
//	
//	driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("jairamji ki ");
//	driver.navigate().forward();
//	driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("jai ho");
//	driver.navigate().back();
//	driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("jai ho");
	
//	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Hello ");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement hello= mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Hello']")));
		// Thread.sleep(1000);
		
		hello.click();
		
		
	
	
	
	Set<String> windowid = driver.getWindowHandles();
	
	
	List<String> winlist = new ArrayList<>(windowid);
	String parentid =winlist.get(0);
	String childid= winlist.get(1);
	
	
	
driver.switchTo().window(childid);
  System.out.println(driver.getTitle()); 
  
  driver.switchTo().window(parentid);
  System.out.println(driver.getTitle()); 

	driver.quit();
	
	
	

	}

}
