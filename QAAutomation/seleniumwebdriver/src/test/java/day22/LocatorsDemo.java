package day22;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsDemo {

	public static void main(String[] args) {
		

		
		
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://demo.nopcommerce.com/");
//		driver.manage().window().maximize();
//		
//		//name 
////		driver.findElement(By.name("q")).sendKeys("Mac");
//		boolean logoDisplay=driver.findElement(By.id("customerCurrency")).isDisplayed();
//	    System.out.println(logoDisplay);	
		
		
	WebDriver driver= new ChromeDriver();
	driver.get("https://demoblaze.com/index.html");
	
	List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println("No of links are "+ links.size());
	
	
	List<WebElement> imglink=driver.findElements(By.tagName("img"));
	System.out.println("Image links are "+imglink.size());
	
	driver.findElement(By.linkText("Contact")).click();;
	
	
	driver.findElement(By.partialLinkText("Hom")).click();
	
	driver.close();
	
	
	
	
	
	
	
	
	    
	    
	}

}
