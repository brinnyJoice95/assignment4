package week4.Assignment1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Merge {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.xpath("//div[@for='crmsfa']")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath(" (//img[@alt='Lookup'])[1]")).click();
		Set<String> windows1 = driver.getWindowHandles();
		ArrayList<String> list1 = new ArrayList<String>(windows1);
		driver.switchTo().window(list1.get(1));
		Thread.sleep(2000);
		driver.findElement(By.name("firstName")).sendKeys("Brinny");
		driver.findElement(By.xpath("//a[@class='linktext']")).click();

		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(2000);
		driver.switchTo().window(list1.get(0));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windows2 = driver.getWindowHandles();
		ArrayList<String> list2 = new ArrayList<String>(windows2);
		driver.switchTo().window(list2.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Joice");
		driver.findElement(By.xpath("//a[text()='13993']")).click();

		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form[@action='mergeContacts']")).click();
	
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Alert");

	}

	
}
