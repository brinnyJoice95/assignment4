package week4.Assignment1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
					//1.Load the uRL https://www.amazon.in/
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//2.search as oneplus 9 pro 
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 9 pro");
		driver.findElement(By.xpath("(//span[text()=' 5g'])/parent::div")).click();
		
		//3.Get the price of the first product
		String value = driver.findElement(By.xpath("//span[text()='54,999']")).getText();
	
		
		System.out.println("MRP:"+value);
		//driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).click();
		
		 //4.Print the number of customer ratings for the first displayed product
		String review  = driver.findElement(By.xpath("//span[text()='11,975']")).getText();
		System.out.println("Review count"+review);
		//5. Mouse Hover on the star
		//Thread.sleep(3000);
		WebElement star = driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-icon-star-small')])[2]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(star).perform();
		Thread.sleep(3000);
		//6. Get the percentage of ratings for the 5 star
		String percent = driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']")).getText();
		System.out.println("percentage"+percent);
		//7. Click the first text link of the first image
	   driver.findElement(By.xpath("//span[text()='OnePlus 9 Pro 5G (Pine Green, 12GB RAM, 256GB Storage)']")).click();
	   Set<String> windows1 = driver.getWindowHandles();
		ArrayList<String> list1 = new ArrayList<String>(windows1);
		driver.switchTo().window(list1.get(1));
		Thread.sleep(3000);
	 //8. Take a screen shot of the product displayed
		File source1 = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File dest1=new File("./snaps/screenshort2.png");
		FileUtils.copyFile(source1, dest1);
		//9. Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		//10. Get the cart subtotal and verify if it is correct.
		driver.findElement(By.xpath("(//span[@class='nav-line-2'])[3]")).click();
		String subtotal = driver.findElement(By.xpath("//div[contains(@class,'a-row a-spacing-mini')]")).getText();
		if(value.equals(subtotal)) {
			System.out.println("Both prices are equal");
		}else {
			System.out.println("Both prices are not equal");
		}

		
		
		
	   
		
		
	}

}
