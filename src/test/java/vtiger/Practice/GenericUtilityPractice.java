package vtiger.Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class GenericUtilityPractice {
	public static void main(String[] args) throws IOException, InterruptedException {
		PropertyFileUtility pfu=new PropertyFileUtility();
		String data1=pfu.readDataFromPropertyFile("browser");
		String data2=pfu.readDataFromPropertyFile("url");
		String data3=pfu.readDataFromPropertyFile("username");
		String data4=pfu.readDataFromPropertyFile("password");
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data4); 
		
		ExcelFileUtility efu=new ExcelFileUtility();
		String value=efu.readDataFromExcelSheet("Organization", 1, 2);
		System.out.println(value);
		efu.writeIntoExcel("Organization", 10, 7, "theertha");
		System.out.println("data added");
		
		JavaUtility jUtil=new JavaUtility();
		System.out.println(jUtil.getRandomNumber());
		System.out.println(jUtil.getSystemDate());
		System.out.println(jUtil.getSystemDateInFormat());
		
		WebDriverManager.firefoxdriver().setup();
		WebDriverUtility wUtil=new WebDriverUtility();
		WebDriver driver=new FirefoxDriver();
		wUtil.maximizeWindow(driver);
		Thread.sleep(2000);
		wUtil.minimizeWindow(driver);
	}

}
