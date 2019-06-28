package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InstanceAuto 
{
	 public WebDriver driver;
		
	  @BeforeTest
	  public void launchApp()
	  {
		  System.setProperty("webdriver.chrome.driver", "D:\\Swathi\\Selenium\\chromedriver_win32\\chromedriver.exe");
		  ChromeOptions option = new ChromeOptions();
		  option.addArguments("disable-infobars");
		  
		   driver = new ChromeDriver(option);
		   driver.get("https://dev83429.service-now.com/?_ga=2.72139923.1864238307.1556789337-1798747764.1556789337");
	  }
	  
	  @Test
	  public void exece()
	  {  
		  Assert.assertEquals("ServiceNow", driver.getTitle());
		  System.out.println("Assertion of titles is passed");
		  WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		  driver.switchTo().frame(iframe);
		  WebElement uname = driver.findElement(By.xpath("//label[text()='User name']/following-sibling::input[@type='text']"));
		  uname.clear();
		  uname.sendKeys("admin");
		  WebElement pwd = driver.findElement(By.xpath("//input[@id='user_password']"));
		  pwd.clear();
		  pwd.sendKeys("Thanvi@123");
		  
		  WebElement signInBtn = driver.findElement(By.xpath("//button[text()='Login']"));
		  signInBtn.click();
		  
		  
	  }
		

}
