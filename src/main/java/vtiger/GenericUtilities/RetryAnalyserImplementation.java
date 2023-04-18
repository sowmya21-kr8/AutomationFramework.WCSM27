package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this is an implementatiom class for IRetryAnalyser interface of testng
 * @author Admin
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
int count=0;
int retryCount=4;

	public boolean retry(ITestResult result) {
		while(count<retryCount)
		{
			count++;
			return true;
		}
	
		return false;
	}

}
