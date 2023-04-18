package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	//declaration
	@FindBy(name="accountname")
	private WebElement OrganizationNameEdt;

	@FindBy(name="industry")
	private WebElement IndustryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//utilization
	public WebElement getOrganizationNameEdt() {
		return OrganizationNameEdt;
	}

     public WebElement getIndustryDropdown() {
		return IndustryDropdown;
	}
    
     public WebElement getSaveBtn() {
		return SaveBtn;
	}
    
     //initializatios
    public CreateNewOrganizationPage(WebDriver driver) //constructpr
	{
		PageFactory.initElements(driver,this);
	}
/**
 * this method will create organization with mandatory information
 * @param ORGNAME
 */
public void createNewOrganization(String ORGNAME)
{
	OrganizationNameEdt.sendKeys(ORGNAME);
	SaveBtn.click();
}

/**
 * this method will create organization with industry dropdown
 * @param ORGNAME
 * @param INDUSTRY
 */
public void createNewOrganization(String ORGNAME,String INDUSTRY)
{
	OrganizationNameEdt.sendKeys(ORGNAME);
	handleDropdown(IndustryDropdown ,INDUSTRY );
	SaveBtn.click();
}

}
