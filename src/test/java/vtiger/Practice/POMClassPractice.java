package vtiger.Practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class POMClassPractice {
public static void main(String[] args) throws IOException {
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888/");
	JavaUtility jUtil=new JavaUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	String ORGNAME=eUtil.readDataFromExcelSheet("Contact", 4, 3)+jUtil.getRandomNumber();
	String LASTNAME=eUtil.readDataFromExcelSheet("Contact", 4, 2)+jUtil.getRandomNumber();
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp("admin", "admin");
	HomePage hp= new HomePage(driver);
	hp.clickOnOrganizationsLink();
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrganizationLookUpImg();
	CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
	cop.createNewOrganization(ORGNAME);
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
	hp.clickOnContactsLink();
	ContactsPage cp=new ContactsPage(driver);
	cp.clickOnCreateContactLookUpImg();
	CreateNewContactPage ccp=new CreateNewContactPage(driver);
	ccp.createNewContact(driver, LASTNAME, ORGNAME);
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
hp.logoutApp(driver);
}
}

