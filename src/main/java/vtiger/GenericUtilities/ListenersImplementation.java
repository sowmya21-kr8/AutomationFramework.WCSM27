package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provides implementation for the ITestListener Interface of TestNg
 * @author Admin
 *
 */
public class ListenersImplementation implements ITestListener {

	
	ExtentReports report;
	ExtentTest test;
	

	public void onStart(ITestContext context) {
		System.out.println("===execution started");
		ExtentSparkReporter htmlreporter=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlreporter.config().setDocumentTitle("Vtiger Execution Report");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("Automation Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlreporter);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "FireFox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Reporter-Name", "admin");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"=== test script failed===");
		System.out.println(result.getThrowable());
		WebDriverUtility wUtil=new WebDriverUtility();
		String screenshotName = methodName+"-"+new JavaUtility().getSystemDateInFormat();
		try {
			String path = wUtil.takeScreenshot(BaseClass.sDriver, screenshotName);
			test.addScreenCaptureFromPath(path); // go the screenshot location and it will 
			                                     // attached to the report
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" === SKIP ===");
		test.log(Status.INFO, result.getThrowable()); // print the exception in report
	}

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
	    test=report.createTest(methodName);
	    test.log(Status.INFO, "===test script execution started===");
	}
	

	public void onFinish(ITestContext context) {
		System.out.println("===execution enede");
		report.flush();//generate report
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"=== PASS ===");
	}
	

}
