package Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pomPages.CreateIncident;
import pomPages.ManagingInstance;

public class CreateIncidentPomScript
{
	WebDriver driver;
	
	@BeforeTest
	public void launchApp()
	{
		  System.setProperty("webdriver.chrome.driver", "D:\\Swathi\\Selenium\\chromedriver_win32\\chromedriver.exe");
		  ChromeOptions option = new ChromeOptions();
		  option.addArguments("disable-infobars");

		   driver = new ChromeDriver(option);
			  driver.manage().window().maximize();
			  driver.manage().deleteAllCookies();
		   driver.get("https://dev83429.service-now.com/navpage.do");
	}
	
	@Test
	public void creat_Incident() throws InterruptedException
	{
		/*
		 * String mainHandler = driver.getWindowHandle(); Set<String> handlers =
		 * driver.getWindowHandles(); for(String handler:handlers) {
		 * if(handler==mainHandler) { break; } else { driver.switchTo().window(handler);
		 * } }
		 */
		
		   
		   ManagingInstance mi = new ManagingInstance(driver);
		   mi.instUsername();
		   mi.instPwd();
		   mi.LoginBtn();
		   CreateIncident ci = new CreateIncident(driver);
		   
		   ci.filter();
		   ci.CreateNewIncident();
		  // ci.Caller();
		
		   ci.CallerSearch();
		  // Thread.sleep(10000);
		   			
		   ci.Category();
		   ci.config_Item();
		  
		   ci.ShortDescription("Test");		  
		   ci.submitButton();
	}
	
	/*
	 * @AfterMethod public void Close_Browser() { driver.close(); }
	 */
	

}
