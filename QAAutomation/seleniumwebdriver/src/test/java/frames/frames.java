package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class frames {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
driver.get("https://ui.vision/demo/webtest/frames");
driver.manage().window().maximize();


WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));

		
		driver.switchTo().frame(frame1);
		
		
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("HEllo");
		driver.switchTo().defaultContent();
		
	WebElement frame5= 	driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
	
	driver.switchTo().frame(frame5);
	//driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("hello frame5");
	
	
	
	driver.findElement(By.tagName("a")).click();
	
	boolean rishi=driver.findElement(By.xpath("//a[normalize-space()='Our Privacy Policy']")).isDisplayed();
	System.out.println(rishi);
	
	


		boolean rishi1 = driver.findElement(By.xpath("//img[@alt='Ui.Vision by a9t9 software - Image-Driven Automation']")).isDisplayed();
		if(rishi1 == true ) {
System.out.println("logo is available ");			
		}
		else {
			System.out.println("Logo  is not available ");
		}
		
		
		driver.quit();
		
	}
}
