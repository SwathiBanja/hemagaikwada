package Scripts;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreatIncident
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
	   public static void HomePage() throws InterruptedException, AWTException
	   {	 
		WebDriverWait wait = new WebDriverWait(driver,60);
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.get("https://dev83429.service-now.com/navpage.do");
		   WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		   driver.switchTo().frame(iframe);
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
		   
		   robot.mousePress(0);
		   
		   WebElement CreateInst = driver.findElement(By.xpath("//*[@id=\"14641d70c611228501114133b3cc88a1\"]/div/div"));
		   wait.until(ExpectedConditions.visibilityOf(CreateInst));
		   CreateInst.click();
		   
		 
	   }   
}
