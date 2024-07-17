package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUsertxtbox() {
		return usertxtbox;
	}

	public WebElement getPswdtxtbox() {
		return pswdtxtbox;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}


	@FindBy(name="user_name")
	private WebElement usertxtbox;
	
	@FindBy(name="user_password")
	private WebElement pswdtxtbox;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	
	@FindBy(xpath="//div[text()='Powered by vtiger CRM - 5.4.0']")
	private WebElement text;
	
	public WebElement getText() {
		return text;
	}
    
	
	public WebElement getAdminbutton() {
		return adminbutton;
	}

	public WebElement getLogout() {
		return logout;
	}


	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminbutton;
	
	@FindBy(linkText="Sign Out")
	private WebElement logout;
	

}
