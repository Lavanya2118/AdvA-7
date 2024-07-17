package genericlib;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pomRepo.LoginPage;

@Listeners(ListenersImplimentation.class)
public class BaseClass
{
	public static WebDriver driver;
	public static Webdriverutil wb= new Webdriverutil();
	public static ExcelUtil um= new ExcelUtil();
	public static JavaUtil ja= new JavaUtil();
	public static LoginPage lp;
	public static ExtentSparkReporter reporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		Reporter.log("Report generation",true);
		reporter=new ExtentSparkReporter(IConstant.reportPath);
		reports=new ExtentReports();
		reports.attachReporter(reporter);
	}
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws IOException, InterruptedException {
		driver= new ChromeDriver();
		wb.maximizeTheWindow(driver);
		//test.log(Status.INFO, "window is maximized");
		wb.implicitlyWait(driver);
		Thread.sleep(2000);
		driver.get(um.getDataFromPropertyFile("url"));
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) throws IOException, InterruptedException {
		test = reports.createTest(method.getName());
		Reporter.log(method.getName(),true);
		LoginPage lp= new LoginPage(driver);
		lp.getUsertxtbox().sendKeys(um.getDataFromPropertyFile("username"));
		test.log(Status.INFO, "user has entered username");
		Thread.sleep(2000);
		lp.getPswdtxtbox().sendKeys(um.getDataFromPropertyFile("password"));
		test.log(Status.INFO, "user has entered password");
		lp.getLoginbutton().click();
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		LoginPage lp= new LoginPage(driver);
		lp.getAdminbutton().click();
		lp.getLogout().click();
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		wb.closeBrowser(driver);
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		Reporter.log("Report",true);
		reports.flush();
	}
}


