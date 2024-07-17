package pomRepo;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaign_Page 
{
	public Campaign_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='javascript:;']")
	private WebElement moreOption;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	public WebElement getMoreOption() {
		return moreOption;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getCreateCampaings() {
		return createCampaings;
	}

	public WebElement getCampaingsName() {
		return campaingsName;
	}

	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampaings;
	
	@FindBy(name = "campaignname")
	private WebElement campaingsName;
}
