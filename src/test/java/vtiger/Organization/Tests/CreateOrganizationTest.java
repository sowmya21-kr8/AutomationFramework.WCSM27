package vtiger.Organization.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
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
public class CreateOrganizationTest extends BaseClass {
	
	@Test
	public void createOrgTest() throws IOException {
		
		
		String ORGNAME=eUtil.readDataFromExcelSheet("Organization", 1, 2)+jUtil.getRandomNumber();
		
			//Step 5: Navigate to Organizations link
		    HomePage hp= new HomePage(driver);
		    hp.clickOnOrganizationsLink();
		    Reporter.log("navigated to organizations link");
			
			//Step 6: Click on Create Organization Look up Image
			OrganizationsPage op=new OrganizationsPage(driver);
			op.clickOnCreateOrganizationLookUpImg();
			Reporter.log("clicked on Organization look up");
			
			//Step 7: Create organization with mandatory Fields
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.createNewOrganization(ORGNAME);
			Reporter.log("Organization created",true);
			
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
	
			@Test
			public void demo()
			{
				System.out.println("abc");
			}
	}


