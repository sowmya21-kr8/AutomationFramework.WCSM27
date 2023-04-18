package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement CreateContactLookUpImg;

	public WebElement getCreateContactEdt() {
		return CreateContactLookUpImg;
	}
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//business library
	/**
	 * this method will clock on create contact lookup image
	 */
	public void clickOnCreateContactLookUpImg()
	{
		CreateContactLookUpImg.click();
	}
}
