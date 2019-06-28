package Scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateIncidentScript
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
	  public void exece() throws AWTException
	  {  
		  WebDriverWait wait = new WebDriverWait(driver,40);

		  driver.manage().deleteAllCookies();
		  driver.manage().window().maximize();
		  driver.get("https://dev83429.service-now.com/navpage.do");
		  String mainhandler = driver.getWindowHandle();
		   WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		   driver.switchTo().frame(iframe1);
		   WebElement uname = driver.findElement(By.xpath("//label[text()='User name']/following-sibling::input[@type='text']"));
		   uname.clear();
		   uname.sendKeys("admin");
		   WebElement pwd = driver.findElement(By.xpath("//input[@id='user_password']"));
		   pwd.clear();
		   pwd.sendKeys("Thanvi@123");
		   
		   Robot robot = new Robot();
		   
			  
		   driver.findElement(By.xpath("//button[text()='Login']")).click();
		   WebElement filter = driver.findElement(By.xpath("//input[@id='filter']"));
		   wait.until(ExpectedConditions.visibilityOf(filter));
		   filter.sendKeys("incident");
		   
		   robot.keyPress(KeyEvent.VK_ENTER);
		   
		   WebElement CreateInst = driver.findElement(By.xpath("//*[@id=\"14641d70c611228501114133b3cc88a1\"]/div/div"));
		   wait.until(ExpectedConditions.visibilityOf(CreateInst));
		   CreateInst.click();
		   
		   WebElement CallerSearchIcon = driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']"));
		   CallerSearchIcon.click();
		   
		   Set<String> handlers = driver.getWindowHandles();
		   for(String handler:handlers)
		   {
			   if(handler==mainhandler)
			   {
				   break;				   
			   }
			   else
			   {
				   driver.switchTo().window(handler);
			   }
		   }
		   WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		   
		   
		   WebElement caller = driver.findElement(By.xpath("//input[@name='ba6922b7dbc13300094f2737489619ac_text']"));
		   caller.sendKeys("*System Administrator");
		   
		   
		  
		  
	  }

}
