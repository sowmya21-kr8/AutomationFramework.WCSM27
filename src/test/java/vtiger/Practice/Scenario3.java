package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3 {
	public static void main(String[] args) throws IOException {
		/* Launch Browser
Login to application with valid credentials
Navigate to Organizations link
Click on Create Organization look Up Image
Create Organization with Mandatory fields
Select "Chemicals" in the industry drop down
Save and Verify
logout of Application*/
		// read all the necessary data
		// read the data from property file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String BROWSER=pObj.getProperty("browser");
        String URL=pObj.getProperty("url");
        String USERNAME=pObj.getProperty("username");
        String PASSWORD=pObj.getProperty("password");
        
        WebDriver driver=null;
        // step1: launch the browser
        if(BROWSER.equalsIgnoreCase("chrome"))
        {
        	WebDriverManager.chromiumdriver().setup();
        	driver=new ChromeDriver();
        }
        else if(BROWSER.equalsIgnoreCase("firefox"))
        {
        	WebDriverManager.firefoxdriver().setup();
        	driver=new FirefoxDriver();
        }
	}

}
