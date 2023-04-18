package vtiger.Contact.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass {
	@Test
public void createContactWithOrgTest() throws IOException
{
	String LASTNAME=eUtil.readDataFromExcelSheet("Contact", 4, 2);
	String ORGNAME=eUtil.readDataFromExcelSheet("Contact", 4, 3)+jUtil.getRandomNumber();
	
	//Step 5: Navigate to Organizations link
	    HomePage hp= new HomePage(driver);
	    hp.clickOnOrganizationsLink();
	    
	    
	    
		
		//Step 6: Click on Create Organization Look up Image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrganizationLookUpImg();
		
		//Step 7: Create organization with mandatory Fields
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//Step 8: Validate for Organization
	    OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	    String OrgHeader=oip.getOrgHeader();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader+" ---- Organization created");
		}
		else
		{
			System.out.println(" ----Organization creation Failed ----");
		}
		
		//step9: navigate to contacts link
		hp.clickOnContactsLink();
		
		//step 10: click on create contact look up image
	    ContactsPage cp=new ContactsPage(driver);
	    cp.clickOnCreateContactLookUpImg();
		
		//step11: create contact
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		wUtil.takeScreenshot(driver, "Screenshot1");
		
		//step 12: validate for Contact
				ContactsInfoPage cip=new ContactsInfoPage(driver);
				String ContactHeader=cip.getContactHeader();
				if(ContactHeader.contains(LASTNAME))
				{
					System.out.println(ContactHeader+" ---- Contact created");
				}
				else
				{
					System.out.println(" ----Contact creation Failed ----");
				}		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
}
