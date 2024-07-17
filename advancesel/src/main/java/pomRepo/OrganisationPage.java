package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage 
{

		public OrganisationPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrganisationLink() {
			return organisationLink;
		}

		public WebElement getCreateOrganisation() {
			return createOrganisation;
		}

		public WebElement getNameTxtBox() {
			return nameTxtBox;
		}

		public WebElement getIndustryDropdown() {
			return industryDropdown;
		}
		

	@FindBy(linkText="Organizations")
	private WebElement organisationLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganisation;
	
	@FindBy(name = "accountname")
	private WebElement nameTxtBox;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="assigntype")
	private WebElement groupRadioButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}
	
	public WebElement getPhoneTxtBox() {
		return PhoneTxtBox;
	}

	public WebElement getEmailTxtBox() {
		return EmailTxtBox;
	}


	@FindBy(name="phone")
	private WebElement PhoneTxtBox;
	
	@FindBy(name="email1")
	private WebElement EmailTxtBox;
	
	@FindBy(xpath="//span[text()='Creating New Organization']")
	private WebElement createOrgTxt;

	public WebElement getCreateOrgTxt() {
		return createOrgTxt;
	}

	
	}
	

	
	
	


