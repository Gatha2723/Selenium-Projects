package practice.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {
WebDriver driver;
	
	@Test
	public void browserSetUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.google.com/");
		String handle1 = driver.getWindowHandle();
		Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demoqa.com/");
		String handle2 = driver.getWindowHandle();
		Thread.sleep(3000);
		driver.switchTo().window(handle1);
		driver.close();
		Thread.sleep(1000);
		//driver.switchTo().window(handle2);
		
		
		
			
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.open('https://demoqa.com/','_blank')");
		
		
	}

}
