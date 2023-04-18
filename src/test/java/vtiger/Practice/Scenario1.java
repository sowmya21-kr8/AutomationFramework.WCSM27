package vtiger.Practice;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.IConstantsUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class Scenario1 {
public static void main(String[] args) throws IOException {

	//step1: read all the necessary data
	 //read the data from property file
	 FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	 Properties pobj=new Properties();
	 pobj.load(fisp);
	 String BROWSER=pobj.getProperty("browser");
	 String URL=pobj.getProperty("url");
	 String USERNAME=pobj.getProperty("username");
	 String PASSWORD=pobj.getProperty("password");
	 
	 Random r=new Random();
	 int num=r.nextInt(10000);
	 
	
	System.out.println(BROWSER);
	WebDriver driver=null;
	//step1 launch the browser
	 if(BROWSER.equalsIgnoreCase("chrome"))
	 {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	 }
	 else if(BROWSER.equalsIgnoreCase("firefox"))
	 {
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	 }
	 else
	 {
		 System.out.println("invalid browser name");
	 }
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(URL);
	//step2 login into the application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    driver.findElement(By.name("user_password")).sendKeys(PASSWORD,Keys.TAB,Keys.ENTER);
    //step3 navigate to contacts link
    driver.findElement(By.linkText("Contacts")).click();
    //step4 Click on Create contact look Up Image
    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
    //step5 Create Contact with Mandatory fields
    driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sowmya"+num);
    //step6 save
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    //step7 verify
    String ContactHeader=driver.findElement(By.className("dvHeaderText")).getText();
    if(ContactHeader.contains("Sowmya"))
    {
    	System.out.println(ContactHeader+"TC is passed");
    }
    else 
    {
    	System.out.println(ContactHeader+"TC is failed");
    }
    WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("SignOut is successful");
	driver.quit();
}
    
    
}


