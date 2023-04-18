package vtiger.Organization.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateMultipleOrgTest extends BaseClass {
	ExcelFileUtility eUtil = new ExcelFileUtility();
	JavaUtility jUtil = new JavaUtility();
	@Test(dataProvider = "OrgWithIndustry")
	public void createOrgTest(String ORG, String INDUSTRY) throws IOException{
		
	String ORGNAME = ORG+jUtil.getRandomNumber();
		
			
			//Step 5: Navigate to Organizations link
		    HomePage hp= new HomePage(driver);
		    hp.clickOnOrganizationsLink();
			
			//Step 6: Click on Create Organization Look up Image
			OrganizationsPage op=new OrganizationsPage(driver);
			op.clickOnCreateOrganizationLookUpImg();
			
			//Step 7: Create organization with mandatory Fields
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.createNewOrganization(ORGNAME, INDUSTRY);
			
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
			
			
}

	@DataProvider(name = "OrgWithIndustry")
	public Object[][] getData() throws Exception {
		Object[][] data = eUtil.readDataFromExcelToDataProvider("dataProviderOrg");
		return data;
	}
	}



