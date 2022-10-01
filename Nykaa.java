package week4.Assignment1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 2) Mouseover on Brands and Search L'Oreal Paris
		//
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brand).perform();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("Loreal");
		Thread.sleep(3000);
		WebElement loreal = driver.findElement(By.xpath("//div[@class='css-ov2o3v']//a"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(loreal).perform();
		loreal.click();

		// 3) Click L'Oreal Paris
		// 4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String nykaaTitle = driver.getTitle();
		System.out.println(nykaaTitle);
		// 5) Click sort By and select customer top rated
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
         Thread.sleep(2000);
		// 6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("//span[@class='title']")).click();
		// 7) Click->Concern->Color Protection

		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath(" //span[text()='Color Protection']")).click();
		// 8)check whether the Filter is applied with Shampoo
		WebElement shampoo = driver.findElement(By.className("css-11gn9r6"));
		System.out.println("Filter applied:" + shampoo.getText());

		// 9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Colour Protect Shampoo')]")).click();

		// 10) GO to the new window and
		Set<String> windows1 = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windows1);
		driver.switchTo().window(list.get(1));
		Thread.sleep(3000);

		// select size as 175ml
         
		driver.findElement(By.xpath("//option[text()='175ml']"));
		// 11) Print the MRP of the product
		WebElement price = driver.findElement(By.xpath("//span[text()='₹189']"));
		System.out.println("MRP:" + price.getText());

		// 12) Click on ADD to BAG
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();

		// 13) Go to Shopping Bag
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
         Thread.sleep(3000);
       //		14) Print the Grand Total amount
		WebElement grandTotal = driver.findElement(By.xpath("//span[text()='₹259']"));
		System.out.println("GrandTotal:" + grandTotal.getText());
		grandTotal.click();

		// 15) Click Proceed
		driver.findElement(By.xpath("//button[contains(@class,'btn full fill ')]")).click();
		// 16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		// 17) Check if this grand total
		
		
	}
}
