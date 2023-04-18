package vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class consists of generic methods related to webdriver actions
 * @author Admin
 *
 */
public class WebDriverUtility {
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * this method will wait for 20seconds for the page load
	 * @param driver
	 */
public void waitForPageLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
/**
 * this method will wait until a particular web element is visible
 * @param driver
 * @param element
 */
public void waitForElementTovisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * this method will wait until a particular web element is clickable
 * @param driver
 * @param element
 */
public void waitForElementToBeClickableWebDriver(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(element)); 
}
/**
 * this method will handle dropdown by index
 * @param element
 * @param index
 */
public void handleDropDown(WebElement element,int index)
{
	Select s=new Select(element);
	s.selectByIndex(index);
}
/**
 * this method will handle dropdown by value
 * @param element
 * @param value
 */
public void handleDropdown(WebElement element, String value)
{
	Select s=new Select(element);
	s.selectByValue(value);
}
/**
 * this method will handle dropdown by visible text
 * @param text
 * @param element
 */
public void handleDropdown(String text,WebElement element)
{
	Select s=new Select(element);
	s.selectByVisibleText(text);
}

/**
 * this method will perform mousehover action on a particular webelement
 * @param driver
 * @param element
 */
public void mouseHoverAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * this method will perform right click action anywhere on the page
 * @param driver
 */
public void rightClickaction(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.contextClick().perform();
}
/**
 * this method will perform right click action on a particular web element
 * @param driver
 * @param element
 */
public void rightClickAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * this method will perform double click action anywhere on the page
 * @param driver
 */
public void doubleClickAction(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
/**
 * this method will perform double click action on a particular web element
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}
/**
 * this method will perform drag and drop from one element to another
 * @param driver
 * @param srcElement
 * @param dstElement
 */
public void dragAndDropAction(WebDriver driver,WebElement srcElement,WebElement dstElement)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(srcElement, dstElement);
}
/**
 * this method will press the enter key
 * @throws AWTException
 */
public void pressEnterKey() throws AWTException
{
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
}
/**
 * this method will release the enter key
 * @throws AWTException
 */
public void releaseEnterKey() throws AWTException
{
	Robot r=new Robot();
	r.keyRelease(KeyEvent.VK_ENTER);
}
/**
 * this method will handle frames with index
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * this method will handle frames with name or id attribute value
 * @param driver
 * @param nameOrId
 */
public void handleFrame(WebDriver driver,String nameOrId)
{
	driver.switchTo().frame(nameOrId);
}
/**
 * this method will handle frames with web element
 * @param driver
 * @param element
 */
public void handleFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}
/**
 * this method will switch to immediate parent frame
 * @param driver
 */
public void handleParentFrame(WebDriver driver)
{
	driver.switchTo().parentFrame();
}
/**
 * this method will switch to default frame
 * @param driver
 */
public void handleDefaultFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * this method will accept alert pop up
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * this method will dismiss alert pop up
 * @param driver
 */
public void dismisAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * this method will capture and return the alert text
 * @param driver
 * @return
 */
public String getAlertText(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}
public String takeScreenshot(WebDriver driver,String screenshotName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg=new File(".\\Screenshots"+screenshotName+".png");
	FileUtils.copyFile(src, trg);
	
	return trg.getAbsolutePath();//used in extent reports
}
/**
 * this method will switch to window based on partial window title
 * @param driver
 * @param partialWinTitle
 */
public void switchToWindow(WebDriver driver,String partialWinTitle)
{
	//step 1: capture all the window IDs
	Set<String> winIds=driver.getWindowHandles();
	//step2: use a for each loop and navigate to each window
	for(String win:winIds)
	{
		//step3: capture the title of each window
		String currentTitle=driver.switchTo().window(win).getTitle();
		//step4: compare the current title with partial window title
		if(currentTitle.contains(partialWinTitle))
		{
			break;
		}
	}
}
/**
 * this method will scroll randomly downwards
 * @param driver
 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * this method will scroll down until the particular web element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	 

}

