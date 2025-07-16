package day21;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver; 

/* Test case 
 * ------
 * 1)Launch Browser (chrome)
 * 2)Open URL https://demo.opencart.com/
 * 3)Validate title should be "Your Store" 
 * 4)Close browser
 * 
 * */
 

public class Firsttestcase {

	public static void main(String[] args) {
	//1)Launch Browser (chrome)
		
		//ChromeDriver driver=new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		//2)Open URL https://demo.opencart.com/
		
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		
		//3)Validate title should be "Your Store" 
		String act_title=driver.getTitle();
		if(act_title.equals("OpenCart - Demo")) 
		{
			System.out.println("Test Passed");
		}
		else {
			System.out.println("TEST FAILED");
		}
		
		//4) Close the Browser 
      driver.close();
//		driver.quit();
		

	}

}
