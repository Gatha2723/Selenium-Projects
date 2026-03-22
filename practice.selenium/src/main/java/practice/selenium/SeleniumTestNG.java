package practice.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTestNG {
	
	WebDriver driver;
	WebDriverWait wait;
	@BeforeTest
	public void setup() 
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	
	@Test
	public void loginTest() throws InterruptedException
	{
		//driver.get("https://facebook.com/");
	  //  driver.findElement(By.name("email")).sendKeys("xyz");
	    //Thread.sleep(2000);
	   // driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/div[1]/div/div[4]/div/a/div/div[1]/div/span/span")).click();
	    
	    driver.get("https://www.netflix.com/in/");
	    WebElement Email = driver.findElement(By.name("email"));
	    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
	    Email.sendKeys("abc@gmail.com");
		
	}
	
	
}
