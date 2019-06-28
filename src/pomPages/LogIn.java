package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn
{
public static WebDriver driver;
	
	//Initialization
	public LogIn(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signInBtn;
	
	@FindBy(linkText = "Forgot your Password?")
	WebElement forgotPwdLink;
	
	@FindBy(linkText = "Get a ServiceNow Account")
	WebElement snAccnt;
	
	@FindBy(xpath="//iframe[@id='gsft_main']")
	WebElement Iframe;
	
	
	//utilization
	public void username()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.clear();
		userName.sendKeys("swathi.banjaa@gmail.com");
		
	}
	
	public void password()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(password));
		password.clear();
		password.sendKeys("Thanvi@123");
	}
	
	public void SignInBtn()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(signInBtn));
		signInBtn.click();
		
	}
	public void forgotPwdLink()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(forgotPwdLink));
		forgotPwdLink.click();
		
	}
	public void snAccnt()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(snAccnt));
		snAccnt.click();
		
	}
   
	public void Iframe()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(Iframe));
		driver.switchTo().frame(Iframe);		
		
	}

}
