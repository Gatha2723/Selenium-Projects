package practice.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowAction {


WebDriver driver;
	
	@Test
	public void browserSetUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,700)"); // Specific scroll
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //to move to bottom of the page
		//Thread.sleep(1000);
		//js.executeScript("window.scrollTo(0,0)"); //move to the top of the page
		WebElement book = driver.findElement(By.cssSelector("a[href='/books']"));
		js.executeScript("arguments[0].scrollIntoView(true)", book);
			}
}
