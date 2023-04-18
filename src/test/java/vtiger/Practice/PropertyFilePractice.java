package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
public static void main(String[] args) throws IOException {
	//step1: load the file in java readable format using FileInputStream
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	//step2: create an object of  Properties
	Properties pobj=new Properties();
	//step3: load FileInputStream into properties
	pobj.load(fis);
	//step4: using the keys read the value
	String BROWSER=pobj.getProperty("browser");
	System.out.println(BROWSER);
}
}
