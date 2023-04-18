package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consist of generic methods related to property file
 * @author Sowmya
 */
public class PropertyFileUtility {
/**
 * this method will read data from property file
 * @param
 * @return
 * @throws IOException 
 * @throws IOException
 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.propertyFilePath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
		}
	}

