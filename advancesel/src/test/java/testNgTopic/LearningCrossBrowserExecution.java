package testNgTopic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericlib.ExcelUtil;
import genericlib.Webdriverutil;

public class LearningCrossBrowserExecution {
 WebDriver driver;
 Webdriverutil wb = new Webdriverutil();
 ExcelUtil um = new ExcelUtil();
 @Parameters("browser")
 @Test
 public void launch(@Optional("edge")String bname) throws IOException {
	 
	 if(bname.contains("chrome")) {
		 driver=new ChromeDriver();
		 wb.maximizeTheWindow(driver);
		 driver.get(um.getDataFromPropertyFile("url"));
	 }
	 else if(bname.contains("edge")) {
		 driver=new ChromeDriver();
		 wb.maximizeTheWindow(driver);
		 driver.get(um.getDataFromPropertyFile("url"));
	 }
 }
 
 

}
