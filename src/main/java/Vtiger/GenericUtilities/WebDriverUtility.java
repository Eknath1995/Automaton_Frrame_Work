package Vtiger.GenericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * This method will maximise the window
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this method will minimise the window
	 * @param driver
	 */
	public void minimiseWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will fullScreen the window
	 * @param driver
	 */
	public void FullSreenwindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This method will wait 10 second for particular element to load.
	 * @param driver
	 */
	public void WaitForpageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait 10 second for particular element to visible.
	 * @param driver
	 * @param element
	 */
	public void WaitForElementTobeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 *  This method will wait 10 second for particular element to Clickable.
	 * @param driver
	 * @param element
	 */
	public void WaitForElementTobeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle drop down using index
	 * @param element
	 * @param index
	 */
	public void HandleDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop down using value
	 * @param element
	 * @param value
	 */
	public void HandleDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle drop down using visible text.
	 * @param text
	 * @param element
	 */
	public void HandleDropDown(String text,WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method willperform Mouse Hover action on a web element. 
	 * @param driver
	 * @param element
	 */
	public void MouseHover(WebDriver driver,WebElement element ) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	
	/**
	 * This method will perform right click anywhere on the web page 
	 * @param driver
	 */
	public void RightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();;
	}
	
	/**
	 * This method will perform right click on a perticular web page 
	 * @param driver
	 * @param element
	 */
	public void RightClick(WebDriver driver,WebElement element ) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();;
		}
	
	/**
	 * This method will perform Double click anywhere on the web page
	 * @param driver
	 */
	public void DoubleClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();;
	}
	
	/**
	 * This method will perform Double click on a perticular web page 
	 * @param driver
	 * @param element
	 */
	public void DoubletClick(WebDriver driver,WebElement element ) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();;
		}
	
	/**
	 * This method will perform Drag And Drop operation. 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void DragAndDropAction(WebDriver driver, WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();;
	}
	
	/**
	 * This method will move the cursor by offset and click.
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void MovetheCursorAndClick(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).click().perform();;
	}
	
	/**
	 * This method will scroll down for 500 unit
	 * @param driver
	 */
	public void ScrollAction(WebDriver driver) {
		JavascriptExecutor js= ( JavascriptExecutor)driver;
		js.executeScript("window.scrollby(0,500);", "");
	}
	
	/**
	 * This method will scroll down until a perticular web element.
	 * @param driver
	 * @param element
	 */
	public void ScrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js= ( JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	/**
	 * This method will accept the alert popup.
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the alert popup.
	 * @param driver
	 */
	public void dismisstAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get the alert text and return it to caller.
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle frame using index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame using name or id
	 * @param driver
	 * @param nameorID
	 */
	public void handleFrame(WebDriver driver, String nameorID) {
		driver.switchTo().frame(nameorID);
	}
	
	/**
	 * This method will handle frame using Frame element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This ,ethod will switch to immediate parent frame
	 * @param driver
	 */
	public void switchTOParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to default page
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will help to switch the control from one window to another window
	 * @param driver
	 * @param partialwindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialwindowTitle) {
	//step 1: capture all the window IDs
		Set<String> allwinIDs = driver.getWindowHandles();
		
	//step 2: Navigate through each window
		for(String id : allwinIDs ) {
			//step 3: switch To each and capture the title
			String activeTitle = driver.switchTo().window(id).getTitle();
			//step 4: compare the title with required
			if(activeTitle.contains(partialwindowTitle)) { //true
				break;
			}}}
	
	public String captureScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;  
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshots\\"+screenshotName+".png");
		Files.copy(src, dest);
		
		return dest.getAbsolutePath(); // used for extent reporting
	}
	}


















