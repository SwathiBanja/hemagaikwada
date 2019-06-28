package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Incident extends BasePage
{
	public WebDriver driver;
	
	
	//Initialization
	public void Incident(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	//Declaration
	@FindBy(xpath="//input[@id='filter']")
	WebElement SearchFilter;
	
	
	  @FindBy(xpath="//span[text()='Incident']/parent::a") 
	  WebElement incident;
	  
	  @FindBy(xpath="//*[@id=\"14641d70c611228501114133b3cc88a1\"]/div/div")
	  WebElement CreateIncident;
	  
	 

	//Utilization
	public void SearchFilter()
	{
		verifyElementIsPresent(driver, SearchFilter);
	    SearchFilter.sendKeys("incident");
	    SearchFilter.click();		
	}
	public void incidentsServiceDesk()
	{
		verifyElementIsPresent(driver, incident);
	    SearchFilter.sendKeys("incident");
	    incident.click();		
	}
	public void CreteIncident()
	{
		verifyElementIsPresent(driver, CreateIncident);
		CreateIncident.click();
	}
	

}
