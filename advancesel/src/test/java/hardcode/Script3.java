package hardcode;

	import java.io.FileInputStream;
import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
	import java.util.Random;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class Script3 {

		public static void main(String[] args) throws IOException, InterruptedException {
			
		
		{
			FileInputStream fis= new FileInputStream("./src/test/resources/testData.properties");
			Properties p= new Properties();
			p.load(fis);
			String Url = p.getProperty("url");
			String userTxtBox = p.getProperty("username");
			String pswd = p.getProperty("password");
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(userTxtBox);
			driver.findElement(By.name("user_password")).sendKeys(pswd);
			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			Random ranNum= new Random();
			int num = ranNum.nextInt(100);
			
			FileInputStream fis1= new FileInputStream("./src/test/resources/testDataFile.xlsx");
			Workbook wb= WorkbookFactory.create(fis1);
			Sheet sheet = wb.getSheet("Organisation");
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			String data = cell.getStringCellValue()+num;
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(data);
			Thread.sleep(3000);
			WebElement dropdown = driver.findElement(By.name("industry"));
			Select sel= new Select(dropdown);
			sel.selectByValue("Healthcare");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			Thread.sleep(2000);
			driver.quit();
		}
	}

}
