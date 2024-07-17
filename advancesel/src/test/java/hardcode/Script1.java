package hardcode;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Script1 {

		public static void main(String[] args) throws IOException, InterruptedException {
			FileInputStream fis= new FileInputStream("./src/test/resources/testData.properties");
			Properties p= new Properties();
			p.load(fis);
			String Url = p.getProperty("url");
			String usernameTxtBox = p.getProperty("username");
			String pswTxtBox = p.getProperty("password");
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(usernameTxtBox);
			Thread.sleep(2000);
			driver.findElement(By.name("user_password")).sendKeys(pswTxtBox);
			Thread.sleep(2000);
			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			Thread.sleep(2000);
			driver.quit();
		}
	

}
