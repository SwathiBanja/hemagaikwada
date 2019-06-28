package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Catalog_Request_Page extends BasePage
{
	public WebDriver driver;

	//Initialization
	public Catalog_Request_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Declaration
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Approvers')]")
	WebElement Approval_Field;
	
	@FindBy(how = How.XPATH, using="//span[contains(@class,'tab_caption_text') and contains(text(),'Approvers')]")
	WebElement Approvers_Tab;
	
	@FindBy(how = How.XPATH, using="//a[contains(@aria-label,'Preview record: REQ')]/ancestor::td/following-sibling::td[1]")
	WebElement State_Column_From_Req_To;
	
	@FindBy(how = How.ID, using="cell_edit_value")
	WebElement Click_on_State_to_Select_Apparove;
	
	@FindBy(how = How.ID, using="cell_edit_ok")
	WebElement Click_on_Right_Option;
	
	@FindBy(how = How.ID, using="cell_edit_cancel")
	WebElement Click_on_Close_Option;
	
	@FindBy(how=How.XPATH, using="//span//button[contains(text(),'Update')]")
	WebElement Update_Button;
	
	@FindBy(how = How.XPATH, using="//span[contains(@class,'tab_caption_text') and contains(text(),'Requested')]")
	WebElement Requested_Item_Tab;
	
	/*
	 * @FindBy(how = How.XPATH, using = "") WebElement Request_Item_tab;
	 * 
	 * @FindBy(how = How.XPATH, using = "") WebElement Request_Item_tab;
	 * 
	 * @FindBy(how = How.XPATH, using = "") WebElement Request_Item_tab;
	 */
	
	//Utilization
	public void Approval_to_Approved(String approved)
	{
		verifyElementIsPresent(driver, Approval_Field);
		Approval_Field.clear();
	}
	
	public void State_Requested_Approval()
	{
		verifyElementIsPresent(driver, State_Column_From_Req_To);
		Actions action = new Actions(driver);
		action.doubleClick(State_Column_From_Req_To).build().perform();
		
	}
	public void To_Select_Approve_Dropdown(int no)
	{
		verifyElementIsPresent(driver, Click_on_State_to_Select_Apparove);
		
		Select osel = new Select(Click_on_State_to_Select_Apparove);		
		osel.selectByIndex(no);
		
		verifyElementIsPresent(driver, Click_on_Right_Option);
		Click_on_Right_Option.click();
		
     }
	
	public void Update_Button_Click()
	{
		verifyElementIsPresent(driver, Update_Button);
		Update_Button.click();
	}
	
	public void Requested_Item_Tab()
	{
		verifyElementIsPresent(driver, Requested_Item_Tab);
		Requested_Item_Tab.click();
	}
	
	public void Approvers_Tab()
	{
		verifyElementIsPresent(driver, Approvers_Tab);
		Approvers_Tab.click();
	}
	
	
}
