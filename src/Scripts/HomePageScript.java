package Scripts;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pomPages.Home;
import pomPages.LogIn;
import pomPages.ManagingInstance;

public class HomePageScript
{

public static WebDriver driver;

@BeforeTest
public void launchApp()
{
System.setProperty("webdriver.chrome.driver", "D:\\Swathi\\Selenium\\chromedriver_win32\\chromedriver.exe");
ChromeOptions options = new ChromeOptions();
options.addArguments("disable-infobars");
driver = new ChromeDriver(options);
}
@Test	
   public static void HomePage() throws InterruptedException
   {	 
	   
	   driver.manage().window().maximize();
	
		   driver.get("https://developer.servicenow.com/");
		   
		   Home hm=new Home(driver);
		   LogIn lp = new LogIn(driver);
		   ManagingInstance mi = new ManagingInstance(driver);
		   String mainWinHandler = driver.getWindowHandle();
		   hm.Login();
		   lp.username();
		   lp.password();
		   lp.SignInBtn();
		   mi.MangeinstanceMseHover();
		   mi.instance();
		   mi.clickInstance();
		   Thread.sleep(3000);
		   Set<String> handler2 = driver.getWindowHandles();
		   for(String handler:handler2)
		   {
			   if(handler==mainWinHandler)
			   {		   
				   break;
			   }
			   else
			   {
				   driver.switchTo().window(handler); 
				   
			   }
		   }   
			   
		   mi.instUsername();
		   mi.instPwd();
		   mi.LoginBtn();
		   
		   
		   
	   }	
}
