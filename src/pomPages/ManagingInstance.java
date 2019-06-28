package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagingInstance
{
public WebDriver driver;
	
	//Initialization
	public ManagingInstance(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Declaration
	@FindBy(id="dp-hdr-br-manage-link")
	WebElement MangeinstanceMseHover;
	
	@FindBy(id="dp-hdr-br-link-instance")
	WebElement instance;
	
	@FindBy(id="instanceReqBtnHInst")
	WebElement mangInstanceBtn;
	
	@FindBy(xpath="//a[@target='_blank' and contains(text(),'https://')]")
	WebElement clickInstance;
	
	@FindBy(xpath = "//input[@id='user_name']")
	WebElement instUsername;
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement instPwd;
	
	@FindBy(xpath="//iframe[@id='gsft_main']")
	WebElement iframe;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement LoginBtn;

	
	
	//Utilization	
	public void MangeinstanceMseHover()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(MangeinstanceMseHover));
		System.out.println(MangeinstanceMseHover+"   is present");
		Actions action = new Actions(driver);
		action.moveToElement(MangeinstanceMseHover).build().perform();
			
	}
	public void instance()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(instance));
		System.out.println(instance+ "  is present");
		instance.click();
	}
	public void mangInstanceBtn()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(mangInstanceBtn));
		System.out.println(mangInstanceBtn+ "  is present");
		mangInstanceBtn.click();
	}
	public void clickInstance()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(clickInstance));
		System.out.println(clickInstance+ "  is present");
		clickInstance.click();
	}
	public void instUsername() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.switchTo().frame(iframe);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(instUsername));
		System.out.println(instUsername+ "  is present");
		instUsername.sendKeys("admin");
	}

	public void instPwd()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(instPwd));
		System.out.println(instPwd+ "  is present");
		instPwd.sendKeys("Thanvi@123");
	}
	public void LoginBtn()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(LoginBtn));
		LoginBtn.click();
	}
	



}
