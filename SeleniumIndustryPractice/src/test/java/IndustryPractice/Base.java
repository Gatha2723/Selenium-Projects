package IndustryPractice;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	 static WebDriver driver;  //declaring the driver
	 static Properties prop;
	
	
	public void BrowserSetup() throws IOException {
		WebDriverManager.chromedriver().setup();   // will check the chrome version and download the chrome driver for same.
		driver = new ChromeDriver();   // will launch the browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		FileInputStream fis = new FileInputStream("E:/Harsha Learning/JAVA Project/SeleniumIndustryPractice/src/test/java/IndustryPractice/configrepo.properties");
		prop = new Properties();
		prop.load(fis);
		driver.get(prop.getProperty("Url"));
	}
	
	public void teardown() throws InterruptedException
	{
		driver.close();
		Thread.sleep(1000);
		driver.quit();
	}
	

}
