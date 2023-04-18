package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement OrganizationNameLookUpEdt;
	
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement SaveBtn;
    
    @FindBy(name="search_text")
    private WebElement OrgSearchEdt;
    
    @FindBy(name="search")
    private WebElement OrgSearchBtn;

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getOrganizationNameLookUpEdt() {
		return OrganizationNameLookUpEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}

	public WebElement getOrgSeaechBtn() {
		return OrgSearchBtn;
	}
    
    public CreateNewContactPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
    
    //business library
    /**
     * this mwthod will 
     * @param LASTNAME
     */
    public void createNewContact(String LASTNAME)
    {
    	LastNameEdt.sendKeys(LASTNAME);
    	SaveBtn.click();
    }
    /**
     * this method will create contact with Organization
     * @param driver
     * @param LASTNAME
     * @param ORGNAME
     */
    public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME)
    {
    	LastNameEdt.sendKeys(LASTNAME);
    	OrganizationNameLookUpEdt.click();
    	switchToWindow(driver,"Accounts");
    	OrgSearchEdt.sendKeys(ORGNAME);
    	OrgSearchBtn.click();
    	driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();
    	switchToWindow(driver,"Contacts");
    	SaveBtn.click();
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
