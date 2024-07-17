package code;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericlib.ExcelUtil;
import genericlib.Webdriverutil;
import pomRepo.ContactPage;
import pomRepo.LoginPage;
import pomRepo.OrganisationPage;

public class Script_Contact
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
		ContactPage cp=new ContactPage(driver);
		cp.getContactslink().click();
		cp.getCreateContacts().click();
		cp.getLastnametxtbox().sendKeys(um.getDataFromExcelFile("Contact", 0, 0));
		Thread.sleep(2000);
		lp.getAdminbutton().click();

}
}
