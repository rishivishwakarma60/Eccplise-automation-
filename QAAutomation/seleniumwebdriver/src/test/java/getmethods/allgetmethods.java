package getmethods;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class allgetmethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		// TODO Auto-generated method stub
		driver.get("https://www.nopcommerce.com/en");

		String a = driver.getTitle();
		System.out.println(a);

		System.out.println(driver.getCurrentUrl());

	String b=  	driver.getPageSource();
	System.out.println(b);

		String c = driver.getWindowHandle();
		System.out.println(c);

		driver.findElement(By.linkText("About us")).click();

		Set<String> d = driver.getWindowHandles();
		System.out.println(d);

		driver.quit();

	}

}
