package code;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericlib.ExcelUtil;
import genericlib.Webdriverutil;
import pomRepo.LoginPage;

public class Campaign_Page
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
		WebDriver driver=new ChromeDriver();
		Webdriverutil wb=new Webdriverutil();
		ExcelUtil um=new ExcelUtil();
		wb.maximizeTheWindow(driver);
		wb.implicitlyWait(driver);
		driver.get(um.getDataFromPropertyFile("url"));
		LoginPage lp=new LoginPage(driver);
		lp.getUsertxtbox().sendKeys(um.getDataFromPropertyFile("username"));
		lp.getPswdtxtbox().sendKeys(um.getDataFromPropertyFile("password"));
		lp.getLoginbutton().click();
		Thread.sleep(2000);

}
}
