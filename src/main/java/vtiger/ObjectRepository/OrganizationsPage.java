package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrganizationsPage {
	
	//declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;

	//utilization
	public WebElement getCreateOrganizationEdt() {
		return CreateOrgLookUpImg;
	}
	
	//initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//business library
	/**
	 * this method will check on create org look up image
	 */
	public void clickOnCreateOrganizationLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}

}
