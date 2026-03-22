package practice.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Methods 
{
	WebDriver driver;
	WebDriverWait wait;
	
	
	@BeforeTest
	public void setup() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://demoqa.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("a[href='/elements']")).click();
		//Thread.sleep(3000);
	}
	
	@Test (priority=0)
	public void textbox() throws InterruptedException
	{
		driver.findElement(By.cssSelector("a[href='/text-box']")).click();
		WebElement user=driver.findElement(By.id("userName"));
		user.sendKeys("Sachin Tendulkar");
		Thread.sleep(1000);
		driver.findElement(By.id("userEmail")).sendKeys("SachinTendulkar@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("currentAddress")).sendKeys("Dadar East, Mumbai");
		Thread.sleep(1000);
		driver.findElement(By.id("permanentAddress")).sendKeys("Same as above");
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
	}
	
	@Test (priority=2)
	public void checkbox() throws InterruptedException
	{
		driver.findElement(By.cssSelector("a[href='/checkbox']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[1]/span[2]")).click(); //firstexpansion
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[3]/span[2]")).click();	//secondexpansion
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[4]/span[2]")).click(); //thridexpansion
		Thread.sleep(1000);
		boolean result1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[5]/span[3]")).isSelected(); 
		System.out.println(result1);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[5]/span[3]")).click();  //actual checkbox
		boolean result2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[5]/span[3]")).isSelected();
		System.out.print(result2);
	}
	
	@Test (priority=3)
	public void radioButton()
	{
		driver.findElement(By.cssSelector("a[href='/radio-button']")).click();
		boolean radioenabled = driver.findElement(By.id("impressiveRadio")).isEnabled();
		System.out.println(radioenabled);
		driver.findElement(By.id("impressiveRadio")).click();
		boolean radiodisplay = driver.findElement(By.id("impressiveRadio")).isSelected();
	    System.out.print(radiodisplay);
	}
	
	@Test (priority=1)
	public void webTableEditRecord() throws InterruptedException
	{
		driver.findElement(By.cssSelector("a.router-link[href='/webtables']")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div[2]/div[3]/div/div[3]/select")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div[2]/div[3]/div/div[3]/select/option[5]")).click();
		driver.findElement(By.id("searchBox")).sendKeys("Alden");
		Thread.sleep(1000);
		driver.findElement(By.id("basic-addon2")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("edit-record-2")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id='salary']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id='salary']")).sendKeys("15000");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[id='submit']")).click();
		Thread.sleep(1000);
		WebElement searchbar = driver.findElement(By.id("searchBox"));
		searchbar.sendKeys(Keys.CONTROL+"a");
		searchbar.sendKeys(Keys.DELETE);
		driver.findElement(By.id("delete-record-3")).click();
		
	}
	
	
	
	@Test (priority=4)
	public void buttons() throws InterruptedException
	{
		driver.findElement(By.cssSelector("a[href='/buttons']")).click();
		//Thread.sleep(1000);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));
		button.isEnabled();
		System.out.println(button);
		button.click();
	}
	
	@AfterTest 
	public void closebrowser()
	{
		driver.close();
	}
}
