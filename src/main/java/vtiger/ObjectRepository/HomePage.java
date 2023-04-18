package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(linkText="Organizations")
	private WebElement OrganizationEdt;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsEdt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministrationImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;

	public WebElement getOrganizationEdt() {
		return OrganizationEdt;
	}

	public WebElement getContacts() {
		return ContactsEdt;
	}
	
   public WebElement getAdministrationImg() {
		return AdministrationImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
/**
 * this method will click on organizations link
 */
	public void clickOnOrganizationsLink()
	{
		OrganizationEdt.click();
	}
	  /**
	   * this method will click on contacts link
	   */
	public void clickOnContactsLink()
	{
		ContactsEdt.click();
	}
	/**
	 * this method will perform signout operation on web app
	 * @param driver
	 */
	public void logoutApp(WebDriver driver)
	{
	mouseHoverAction(driver,AdministrationImg);
	SignOutLink.click();
	}

}
