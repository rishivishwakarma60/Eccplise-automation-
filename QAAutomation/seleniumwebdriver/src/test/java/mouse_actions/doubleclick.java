package mouse_actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class doubleclick {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
	WebElement box1=	driver.findElement(By.xpath("//input[@id=\"field1\"]"));
	WebElement box2= 	driver.findElement(By.xpath("//input[@id=\"field2\"]"));
	WebElement button= 	driver.findElement(By.xpath("//button[normalize-space()=\"Copy Text\"]"));
	
	Actions act = new Actions(driver);
	box1.clear();
	box1.sendKeys("Hello rishibaby");
	
	act.doubleClick(button).perform();
	String rishi = box2.getAttribute("value");
	
	
	if(rishi.equals("Hello rishibaby")) {
		System.out.println("ALL things are working fine ");
	}
	else {
		System.out.println("All things are not working fine ");
	}
	
	act.contextClick(driver.findElement(By.xpath("//button[normalize-space()=\"Upload Single File\"]"))).perform();      
		
		
		

		
	}

}
