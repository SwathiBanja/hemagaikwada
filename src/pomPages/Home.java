package pomPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home extends BasePage
{
	public WebDriver driver ;
	/* public static WebDriverWait wait = null; */
	//wait1 = new WebDriverWait(driver,30);
	
	//Initialization
	public Home(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//span[text()='|']/preceding-sibling::a[text()='Log In']")
	WebElement Login;
	
	@FindBy(xpath="//a[text()='Feedback']/parent::li[@class='dp-hdr-nav-list-item list-item-feedback']")
	WebElement feedback;
	
	@FindBy(xpath="//iframe[@id='gsft_main']")
	WebElement iframe;	
	
	@FindBy(xpath="//span[text()='|']/preceding-sibling::a[text()='Register']")
	WebElement Register;
	
	@FindBy(id="dp-search")
	WebElement searchIcon; 
	
	@FindBy(xpath="//h1[contains(text(),'Build and Extend')]")
	WebElement ExtentAppli;
	
	@FindBy(xpath="//p[contains(text(),'Harness')]")
	WebElement secondText;
	
	@FindBy(xpath="//a[text()='Learn']/preceding-sibling::a")
	WebElement learnLink;
	
	@FindBy(xpath="//a[text()='Build']")
	WebElement buildLink;
	
	@FindBy(xpath="//a[text()='Discuss']")
	WebElement discussLink;
	
	@FindBy(xpath="//a[text()='Deploy']")
	WebElement deployLink;
	   
	@FindBy(linkText="Start building")
	WebElement tartbuildLink; 
	
	@FindBy(how = How.XPATH, using="//span[contains(@class,'input-group-addon-transparent icon-search ')]")
	WebElement Global_Search;
	

	
	//Utilization
	public void Login()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(Login));
		System.out.println(Login+ "  Found");
		Login.click();
	}
	public void Register()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(Register));
		System.out.println(Register+ "  Found");
		Register.click();
	}
	
	public void searchIcon()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(searchIcon));
		searchIcon.click();
	}
	
	public void Global_Search(String str) throws InterruptedException
	{
		verifyElementIsPresent(driver, Global_Search);
		System.out.println("Element ");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		  Actions action = new Actions(driver);
		  Thread.sleep(4000);
		  action.click(Global_Search).sendKeys(str, Keys.ENTER).build().perform();
		 /*
		 * // Global_Search.click(); Thread.sleep(4000); Global_Search.sendKeys(str);
		 */	
	}
	
	public void switch_to_frame()
	{
		verifyElementIsPresent(driver, iframe);
		driver.switchTo().frame(iframe);
	}
	

	
	
	   

}
