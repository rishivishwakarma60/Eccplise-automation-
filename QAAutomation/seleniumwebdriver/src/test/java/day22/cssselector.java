package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class cssselector {
	public static void main(String[] args) {
		   
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
//		
//	driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Rishi");
//			driver.findElement(By.cssSelector("input.search-box-text ")).sendKeys("1234Riishi");
		
		
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("samsung");
		driver.findElement(By.className("title")).click();
		
		
		
		driver.findElement(By.className("search-text valid")).sendKeys("Samsung");
		
		
		driver.findElement(By.id("customerCurrency")).click();
	
//		driver.findElement(By.className("cb-i")).click();
//		driver.findElement(By.className("cb-i")).click();
		driver.findElement(By.className("button-1 search-button")).click();
		
		driver.quit();
		
	}

}
