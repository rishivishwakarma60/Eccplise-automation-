package day21;

import org.openqa.selenium.chrome.ChromeDriver;

public class firsttestcase {

	public static void main(String[] args) {
		/* Test case 
		 * ------
		 * 1)Launch Browser (chrome)
		 * 2)Open URL https://demo.opencart.com/
		 * 3)Validate title should be "Your Store" 
		 * 4)Close browser
		 * 
		 * */
		ChromeDriver driver = new ChromeDriver();
		
		
		
		driver.get("https://demo.nopCommerce.com/");
		
		
		
		String act_title= driver.getTitle();
		if(act_title.equals("nopCommerce demo store. Home page title")) {
			System.out.println("Test Passed ");
		}
		else {
			System.out.println("Test failed ");
			
		}
		
		driver.close();


	}

}
