package demo_dropdown_table_testing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tabletesting {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//select[@name='fromPort']")).click();
		driver.findElement(By.xpath("//option[@value='Rome']")).click();

		driver.findElement(By.xpath("//select[@name='toPort']")).click();
		driver.findElement(By.xpath("//option[@value='Mexico City']")).click();

		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

		int rows = driver.findElements(By.xpath("//table[@class='table']//tr")).size();
		System.out.println("Total rows including header: " + rows);

		// ✅ Array to store prices (row count - 1 because 1st row is header)
		double[] prices = new double[rows - 1];

		int index = 0;
		for (int i = 1; i < rows; i++) {
			String priceXpath = "//table[@class='table']//tr[" + i + "]/td[6]";
			WebElement priceElement = driver.findElement(By.xpath(priceXpath));
			String priceText = priceElement.getText().replace("$", "");
			System.out.println(priceText);

			prices[index] = Double.parseDouble(priceText);  
			index++;
		}

		// ✅ Bubble Sort logic to sort prices in ascending order
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = 0; j < prices.length - i - 1; j++) {
				if (prices[j] > prices[j + 1]) {
					double temp = prices[j];
					prices[j] = prices[j + 1];
					prices[j + 1] = temp;
				}
			}
		}

		// ✅ Print sorted prices
		System.out.println("\nSorted Prices:");
		for (double p : prices) {
			System.out.println("$" + p);
		}

		// ✅ Print lowest price
		System.out.println("\nLowest Price: $" + prices[0]);
		double  [] price = new double  [rows - 1];
		int a=0;
		
		
		for(int i=1;i<rows;i++) {
			String xpathdes =  "//table[@class='table']// tr[" + i + "]/td[6]" ;
			
	WebElement descending=		driver.findElement(By.xpath(xpathdes));
	String priceText = descending .getText().replace("$", "");
	
	
	System.out.println(priceText);
	
	
       price [a]= Double.parseDouble(priceText);
       
       a++;
       
	
	
   
			
		}
		
		double tem;
		
		
		for (int i = 0; i > price.length - 1; i++) {
			for (int j = 0; j < price.length - i - 1; j++) {
				if (price[j] > price[j + 1]) {
			       tem = price[j];
					price[j] = price[j + 1];
					price[j + 1] = tem;
					
				}
			}
			
		}
		System.out.println("\nSorted Prices:");
		for (double p : price) {
			System.out.println("$" + p);
		}
		
		
		
		
		
		
System.out.println("Largest " +price[0]);


		 driver.quit();
	}
}




