package week4.Assignment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop1 {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
    ChromeDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://jqueryui.com/droppable");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.switchTo().frame(0);
    WebElement drop = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
    Thread.sleep(3000);
       WebElement toDrop = driver.findElement(By.xpath("//p[text()='Drop here']"));
    Actions builder=new Actions(driver);
        builder.dragAndDrop(drop,toDrop).perform();


}
}
