package code;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericlib.ExcelUtil;
import genericlib.JavaUtil;
import genericlib.Webdriverutil;
import pomRepo.LoginPage;
import pomRepo.OrganisationPage;

public class Script_org 
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
		OrganisationPage op=new OrganisationPage(driver);
		op.getOrganisationLink().click();
		op.getCreateOrganisation().click();
		op.getNameTxtBox().sendKeys(um.getDataFromExcelFile("Organisation",0,0));
		Thread.sleep(2000);
		JavaUtil ja =new JavaUtil();
		int num=ja.getRandomNumber();
		op.getNameTxtBox().sendKeys(um.getDataFromExcelFile("Organisation", 0, 0)+num);
		Thread.sleep(2000);
		wb.selectDropdownByValue(op.getIndustryDropdown(), "Healthcare");
		Thread.sleep(3000);
		op.getSaveButton().click();
	}

}
