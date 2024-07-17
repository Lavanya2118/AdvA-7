package hardcode;


	import java.io.IOException;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import genericlib.ExcelUtil;
	import genericlib.Webdriverutil;


public class Script5 
{
	public static void main(String[] args) throws IOException {
		Webdriverutil wb= new Webdriverutil();
		ExcelUtil um= new ExcelUtil();
		WebDriver driver= new ChromeDriver();
		//wb.maximizeTheWindow(driver);  when you are calling nonstatic methods
		Webdriverutil.maximizeTheWindow(driver); //when you are calling static methods
		wb.implicitlyWait(driver);
		driver.get(um.getDataFromPropertyFile("url"));
		driver.findElement(By.name("user_name")).sendKeys(um.getDataFromPropertyFile("username"));
		driver.findElement(By.name("user_password")).sendKeys(um.getDataFromPropertyFile("password"));
		driver.findElement(By.id("submitButton")).click();
	
}

}
