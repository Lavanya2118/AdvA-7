package genericlib;


	import java.time.Duration;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class Webdriverutil 
	{
		WebDriver driver;
	/**
	 * this below method is used to maximize the window
	 * @param driver
	 */
		public static void maximizeTheWindow(WebDriver driver) {
			driver.manage().window().maximize();
		}
		
		/**
		 * This below method is used to refresh the page
		 * @param driver
		 */
		public void refershThePage(WebDriver driver) {
			driver.navigate().refresh();
		}
		
		/**
		 * This below method is used to forward the page
		 * @param driver
		 */
		public void forwardThePage(WebDriver driver) {
			driver.navigate().forward();
		}
		
		/**
		 * this below method is used for Implicitly wait
		 * @param driver
		 */
		public void implicitlyWait(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		
		/**
		 * this method is used for explicit wait
		 * @param driver
		 * @param element
		 */
		public void elementToBeClickWait(WebDriver driver, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		/**
		 * this method is to switch the frame using webelement
		 * @param driver
		 * @param element
		 */
		public void switchToFrame(WebDriver driver, WebElement element) {
			driver.switchTo().frame(element);
		}
		
		/**
		 * this method is used to switch back driver control to main page
		 * @param driver
		 */
		public void switchBackToParentPage(WebDriver driver) {
			driver.switchTo().parentFrame();
		}
		
		/**
		 * this method is used to select the dropdown using value
		 * @param dropdown
		 * @param value
		 */
		public void selectDropdownByValue(WebElement dropdown, String value) {
			Select sel= new Select(dropdown);
			sel.selectByValue(value);
		}
		
		/**
		 * this method is used to select the dropdown using visible text
		 * @param dropdown
		 * @param value
		 */
		public void selectDropdownByVisibleText(WebElement dropdown, String visibleText) {
			Select sel= new Select(dropdown);
			sel.selectByValue(visibleText);
		}
		
		/**
		 * this method is used to deselect the dropdown using visible text
		 * @param dropdown
		 * @param visibleText
		 */
		public void deselectDropdownByVisibleText(WebElement dropdown, String visibleText) {
			Select sel= new Select(dropdown);
			sel.deselectByVisibleText(visibleText);
		}
		
		/**
		 * this method is used to handle your alert popup
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		/**
		 * this method is used to click on cancel button present in popup
		 * @param driver
		 */
		public void dismissAlert(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		
		/**
		 * this method is used to click on element using actions class
		 * @param element
		 */
		public void clickOnElement(WebElement element) {
			Actions actions= new Actions(driver);
			actions.click(element).perform();
		}
		
		/**
		 * this method is used to double click on element
		 * @param element
		 */
		public void doubleClick(WebElement element) {
			Actions actions= new Actions(driver);
			actions.doubleClick(element).perform();
		}
		
		/**
		 * this method is used to perform right click action
		 * @param element
		 */
		public void contextClick(WebElement element) {
			Actions actions= new Actions(driver);
			actions.contextClick(element).perform();
		}
		
		/**
		 * this method is used to scroll window up using JavascriptExecutor
		 * @param driver
		 */
		public void scrollUp(WebDriver driver) {
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,-500);");
		}
		
		/**
		 * this method is used to scroll window down using JavascriptExecutor
		 * @param driver
		 */
		public void scrollDown(WebDriver driver) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500);");
		}
		
		/**
		 * this method is used to close the browser
		 * @param driver
		 */
		public void closeBrowser(WebDriver driver) {
			driver.quit();
		}
	}


