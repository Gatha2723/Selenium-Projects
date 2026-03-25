package IndustryPractice;





import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base{
	
	WebDriver driver;
	public String currentUrl ="https://practicetestautomation.com/logged-in-successfully/";
	
	Base main = new Base();
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="submit")
	WebElement submitbutton;
	
	@FindBy(linkText ="Log out")
	WebElement logoutbutton;
	
	
	public void login(String user,String pwd) throws InterruptedException, IOException
	{
	   username.sendKeys(user);	
	   Thread.sleep(1000);
	   password.sendKeys(pwd);
	   main.captureshots("Loginpage");
	   Thread.sleep(1000);
	   submitbutton.click();
	   
	}
	
	public void logout()
	{
		logoutbutton.click();
	}
	
}
