package IndustryPractice;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

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
		
		
		public void captureshots(String pagename) throws IOException 
		{
		  String timestamp = new java.text.SimpleDateFormat("yyyymmdd_hhmmss").format(new java.util.Date());
          TakesScreenshot ts = (TakesScreenshot)driver;
          File source = ts.getScreenshotAs(OutputType.FILE);
          String DestinationPath = (System.getProperty("user.dir")+"/Screenshot/"+pagename+"_"+timestamp+"_"+".png");
          File destination = new File (DestinationPath);
          destination.getParentFile().mkdirs();
		  Files.copy(source, destination);
		}
	
	
	public void teardown() throws InterruptedException
	{
		driver.close();
		Thread.sleep(1000);
		driver.quit();
	}
	
}
