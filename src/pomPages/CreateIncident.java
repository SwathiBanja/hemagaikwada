package pomPages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class CreateIncident extends BasePage
{
	public  WebDriver driver;
	
	
	//initialization 
	public CreateIncident(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//iframe[@id='gsft_main']")
	WebElement iframe;
	
	@FindBy(xpath="//input[@name='sys_display.incident.caller_id']")
	WebElement Caller;
	
	@FindBy(xpath="//button[@id='lookup.incident.caller_id']")	
	WebElement CallerSearch;
	
	@FindBy(xpath="//span[contains(text(),'Press Enter')]/following-sibling::input")
	WebElement callerSearch_window_inputField;
	
	@FindBy(xpath="//select[contains(@id,'select')]")
	WebElement CallerSearch_window_forText_DropDown;
	
	@FindBy(xpath="//select[@id='incident.category']")
	WebElement Category;
	
	@FindBy(xpath = "//input[@id='sys_display.incident.business_service']")
	WebElement businessService;
	
	@FindBy(xpath = "//span[@class='icon icon-search']/parent::button[@id='lookup.incident.business_service']")
	WebElement businessServiceSearch;
	
    @FindBy(xpath="//input[@id='sys_display.incident.cmdb_ci']")
    WebElement configItem;
    
    @FindBy(xpath="//span[@class='icon icon-search']/parent::button[@id='lookup.incident.cmdb_ci']")
    WebElement configItemSearch;
    	
	@FindBy(xpath = "//select[@id='incident.state']")
	WebElement state;		

    @FindBy(xpath="//select[@id='sys_readonly.incident.approval']")
    WebElement Approval;

    @FindBy(xpath="//select[@id='incident.impact']")
    WebElement impact;
    
    @FindBy(xpath="//select[@id='incident.urgency']")
    WebElement urgency;
    
    @FindBy(xpath="//select[@id='incident.priority']")
    WebElement priority;
    
    @FindBy(xpath="//input[@id='sys_display.incident.assignment_group']")
    WebElement assignment_Group;
    
    @FindBy(xpath="//span[@class='icon icon-search']/parent::button[@id='lookup.incident.assignment_group']")
    WebElement assignmentGroupSearch;
    
    @FindBy(xpath="//input[@id='sys_display.incident.assigned_to']")
    WebElement assigned_To;
    
    @FindBy(xpath="//span[@class='icon icon-search']/parent::button[@id='lookup.incident.assigned_to']")
    WebElement assignedToSearch;
        
    @FindBy(xpath="//input[@id='incident.short_description']")
    WebElement ShortDescription;
    
    
    @FindBy(xpath="//textarea[@id='incident.work_notes']")
    WebElement workNotes;
    
    @FindBy(xpath="//span//button[@value='sysverb_insert' and text()='Submit']")
    WebElement submitButton;
    
    @FindBy(xpath="//div[@class='form_action_button_container']//button[@id='resolve_incident']")
    WebElement resolveButton; 
    
    @FindBy(xpath="//span[text()='Related Records']")
    WebElement relatRecordsTab;
    
    @FindBy(xpath="//span[text()='Resolution Information']")
    WebElement resolInfor;
    
    @FindBy(xpath = "//input[@id='filter']")
    WebElement filter;    
	
	@FindBy(xpath="//a[contains(@href,'incident.do')]//div[text()='Create New']")
	WebElement CreateNewIncident;
	
	@FindBy(xpath="//a[contains(text(),'Abel Tuter')]")
	WebElement Input_Value_To_The_caller_Input_filed;

	
	//Utilization
    public void filter()
    {
    	verifyElementIsPresent(driver,filter);
    	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    	filter.sendKeys("incident");
    }
	public void Caller()
	{
		
		verifyElementIsPresent(driver,iframe);
		driver.switchTo().frame(iframe);
		String mainWindowHandler= driver.getWindowHandle();
		System.out.println(mainWindowHandler);
		verifyElementIsPresent(driver, Caller);
		Caller.clear();
		Caller.sendKeys("Jimmie Barninger",Keys.ENTER);
		
		
	}
	public void CallerSearch() throws InterruptedException
	{
		verifyElementIsPresent(driver,iframe);
		driver.switchTo().frame(iframe);
		String mainWindHandler = driver.getWindowHandle();
		System.out.println("The parent window: " +mainWindHandler);
		Thread.sleep(10000);
		verifyElementIsPresent(driver,CallerSearch);
		Actions action = new Actions(driver);
		action.click(CallerSearch).perform();
		CallerSearch.sendKeys(Keys.chord(Keys.CONTROL, "n"));
		  Thread.sleep(6000);
		  Set<String> handlers = driver.getWindowHandles();
		  System.out.println("The size is : " +handlers.size());
		  Iterator<String> it = handlers.iterator();
		//iterate through your windows
		while (it.hasNext()){
		String parent = it.next();
		driver.switchTo().window(parent);
		System.out.println("parent window     "+parent);
		String newwin = it.next();		
		System.out.println("chiild window         "+newwin);
		driver.switchTo().window(newwin);
		
			
			   Input_Value_To_The_caller_Input_filed.click();
			  Thread.sleep(8000);
			 
		//driver.close();
		driver.switchTo().window(parent);
		            }
	
		/*
		 * for(String handler:handlers) {
		 * System.out.println("The Windows Are "+handler);
		 * 
		 * 
		 * if(handler==mainWindHandler) { // driver.switchTo().window(handler); break; }
		 * else {
		 * 
		 * Thread.sleep(5000); // driver.switchTo().window(handler);
		 * 
		 * System.out.println("Child Window:"+handler); verifyElementIsPresent(driver,
		 * Input_Value_To_The_caller_Input_filed);
		 * Input_Value_To_The_caller_Input_filed.click(); }
		 * 
		 * }
		 */
		

		/*
		 * 
		 * verifyElementIsPresent(driver, callerSearch_window_inputField);
		 * callerSearch_window_inputField.click();
		 */
		 // callerSearch_window_inputField.sendKeys("Jimmie Barninger",Keys.ENTER);
		 
		
		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].value='Jimmie Barninger';", CallerSearch);
		 */
		 
		
	}
	public void Category()
	{
		verifyElementIsPresent(driver,Category);
		Select osel = new Select(Category);
		osel.selectByIndex(3);
		
		//Category.click();
		
	}
	public void config_Item()
	{
		verifyElementIsPresent(driver,configItem);
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].value='*BETH-IBM';", configItem);
    	Category.sendKeys(Keys.ENTER);
		 
	}
	public void state()
	{
		verifyElementIsPresent(driver,state);
		Select osel = new Select(state);
		osel.selectByIndex(3);
		state.click();
		
	}
	public void ShortDescription(String shortDescTest)
	{
		verifyElementIsPresent(driver,ShortDescription);
		ShortDescription.sendKeys(shortDescTest);
		
		
	}
	public void workNotes()
	{
		verifyElementIsPresent(driver,workNotes);
		workNotes.sendKeys("IncidentTest");
		
	}
	public void submitButton()
	{
		verifyElementIsPresent(driver,submitButton);
		Actions action = new Actions(driver);
		action.click(submitButton).build().perform();
		
		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].scrollIntoView();", submitButton);
		 */
		
		
	}
	public void CreateNewIncident()
	{
		
		verifyElementIsPresent(driver,CreateNewIncident);
		System.out.println(CreateNewIncident+ "  is present");
		Actions action = new Actions(driver);
		action.click(CreateNewIncident).build().perform();
	}
	

}
