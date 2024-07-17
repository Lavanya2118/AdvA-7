package scripts_Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericlib.BaseClass;
import pomRepo.Campaign_Page;
import pomRepo.OrganisationPage;



public class Script4_Test extends BaseClass
{
	
	@Test
	public void script4() throws EncryptedDocumentException, IOException {
		Campaign_Page cp= new Campaign_Page(driver);
		cp.getMoreOption().click();
		cp.getCampaignsLink().click();
		cp.getCreateCampaings().click();
		cp.getCampaingsName().sendKeys(um.getDataFromExcelFile("campaign", 0, 0));
		OrganisationPage op= new OrganisationPage(driver);
		op.getSaveButton().click();
	}
}

