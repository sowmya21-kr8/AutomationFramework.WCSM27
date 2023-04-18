package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	// step1: create object of generic utilities
		public ExcelFileUtility eUtil=new ExcelFileUtility();
		public PropertyFileUtility pUtil=new PropertyFileUtility();
		public JavaUtility jUtil=new JavaUtility();
		public WebDriverUtility wUtil=new WebDriverUtility();
		
		public WebDriver driver=null;
		public static WebDriver sDriver;//this is for listeners
		
		
		@BeforeSuite(alwaysRun=true)
		public void bsConfig() {
			System.out.println("-----database connection is successful-------");
		}
         
		//@Parameters("browser")
		//@BeforeTest
		@BeforeClass(alwaysRun=true)
		public void bcConfig() throws IOException {
			String BROWSER=pUtil.readDataFromPropertyFile("browser");
			String URL=pUtil.readDataFromPropertyFile("url");
			if(BROWSER.equalsIgnoreCase("chrome"))
			 {
				 WebDriverManager.chromedriver().setup();
				 driver=new ChromeDriver();
				 System.out.println("------"+BROWSER+" launched");
			 }
			 else if(BROWSER.equalsIgnoreCase("firefox"))
			 {
				 WebDriverManager.firefoxdriver().setup();
				 driver=new FirefoxDriver();
				 System.out.println("------"+BROWSER+" launched");
			 }
			 else
			 {
				 System.out.println("invalid browser name");
			 }
			sDriver=driver;//this is for listeners
			 wUtil.maximizeWindow(driver);
				wUtil.waitForPageLoad(driver);
				driver.get(URL);
			
		}
		
		@BeforeMethod(alwaysRun=true)
		public void bmCongig() throws IOException {
			String USERNAME=pUtil.readDataFromPropertyFile("username");
			String PASSWORD=pUtil.readDataFromPropertyFile("password");
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			System.out.println("Login to app is successful");
		}
		
		@AfterMethod(alwaysRun=true)
		public void amConfig() {
			HomePage hp=new HomePage(driver);
			hp.logoutApp(driver);
			System.out.println("SignOut is successful");
			System.out.println("-----logout of app is successful");
		}
		
		//@AfterTest
		@AfterClass(alwaysRun=true)
		public void acConfig() {
			driver.quit();
			System.out.println("-----browser closed-----");
		}
		@AfterSuite(alwaysRun=true)
		public void asConfig() {
			System.out.println("-----database closed successful");
		}
	}


