package practice.selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	
	WebDriver driver;
	
	@BeforeTest
	public void browserSetUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/alerts");
		Thread.sleep(3000);
	}
	
	@Test
	public void altertest() throws InterruptedException
	{
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String AlertMessage = alert.getText();
		System.out.println(AlertMessage);
		Thread.sleep(2000);
		alert.accept();
	
        Thread.sleep(2000);
		
	    driver.findElement(By.id("timerAlertButton")).click();
	    Thread.sleep(6000);
	    String AlertMessageWithWait = alert.getText();
	    System.out.print(AlertMessageWithWait);
	    Thread.sleep(3000);
	    alert.accept();
	    
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("confirmButton")).click();
	    Thread.sleep(3000);
	    String AlertMessageWithConfirmation = alert.getText();
	    System.out.print(AlertMessageWithConfirmation);
	    Thread.sleep(3000);
	    alert.dismiss();
	    
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("promtButton")).click();
	    Thread.sleep(3000);
	    String AlertMessagewithPrompt = alert.getText();
	    System.out.println(AlertMessagewithPrompt);
	    Thread.sleep(2000);
	    alert.sendKeys("Rohina");
	    Thread.sleep(1000);
	    alert.accept();
	
	}
	
	
	

}
