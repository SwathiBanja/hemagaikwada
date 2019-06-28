package pomPages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;



public class BasePage 
{
	public WebDriver driver;
	
	
  public void verifyElementIsPresent(WebDriver driver, WebElement ele)
  {
	  WebDriverWait wait = new WebDriverWait(driver,30);
	  try
	  {
	  wait.until(ExpectedConditions.visibilityOf(ele));
	  Reporter.log("Element is Present");
	  System.out.println("Element is Present");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  Reporter.log("Element is not Present");
		  System.out.println("Element is not Present");
	  }
	  
  }
  
  public void verify_title(WebDriver driver, WebElement ele, String act_title)
  {
	  try
	  {
	  String exp_title = driver.getTitle();
	  Assert.assertEquals(exp_title, act_title);
	  System.out.println("Titles are matched");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  System.out.println("Titles are not matched");
	  }
  }
  
  public void Switch_to_next_window(WebDriver driver)
  {
	  
		String Windowhandler = driver.getWindowHandle();
		Set<String> windowhandlers = driver.getWindowHandles();
		
		for(String handler:windowhandlers)
		{
			if(handler == Windowhandler)
			{
				System.out.println(Windowhandler);
				break;
			}
			else
			{
				driver.switchTo().window(handler);
				System.out.println(handler);
			}
			
		}
		
		
  }

}
