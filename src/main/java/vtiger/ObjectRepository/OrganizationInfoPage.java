package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	
	@FindBy(className="dvHeaderText")
	WebElement OrgHeaderEdt;

	public WebElement getOrgHeaderEdt() {
		return OrgHeaderEdt;
	}
	 public OrganizationInfoPage(WebDriver driver)
	 {
		PageFactory.initElements(driver,this); 
	 }
	 
	 //business library
	 /**
	  * this method will get header text and return it to caller
	  * @return
	  */
public  String getOrgHeader()
{
	return OrgHeaderEdt.getText();
}
}
