package mouse_actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draganddrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();

		//a[normalize-space()='BANK']
		//section[@id='g-container-main']//li[2]//a[1]
		//ol[@id='bank']//li[@class='placeholder']
		//ol[@id='amt7']//li[@class='placeholder']

	 Actions act = new Actions(driver);	
	WebElement	Bank=driver.findElement(By.xpath("//a[normalize-space()=\"BANK\"]"));
	
	WebElement Bankpos=	driver.findElement(By.xpath("//ol[@id=\"bank\"]//li[@class=\"placeholder\"]"));
	WebElement fivetho= driver.findElement(By.xpath("(//a[@class='button button-orange'][normalize-space()='5000'])[2]"));
	
	WebElement 	Fivethospos=driver.findElement(By.xpath("//ol[@id=\"amt7\"]//li[@class=\"placeholder\"]"));
		
	
act.dragAndDrop(Bank,Bankpos).perform();	   
act.dragAndDrop(fivetho, Fivethospos).perform();

WebElement	Sales=driver.findElement(By.xpath("//a[normalize-space()=\"SALES\"]"));

WebElement Salespos=	driver.findElement(By.xpath("//ol[@id=\"loan\"]//li[@class=\"placeholder\"]"));
WebElement fivesales= driver.findElement(By.xpath("(//a[@class='button button-orange'][normalize-space()='5000'])[2]"));

WebElement 	Fivesalespos=driver.findElement(By.xpath("//ol[@id=\"amt8\"]"));



act.dragAndDrop(Sales, Salespos).perform();

act.dragAndDrop(fivesales, Fivesalespos).perform();

		
	}

}
