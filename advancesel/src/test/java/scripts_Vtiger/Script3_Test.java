package scripts_Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericlib.BaseClass;
import pomRepo.ContactPage;
import pomRepo.LoginPage;
import pomRepo.OrganisationPage;

public class Script3_Test extends BaseClass{

	@Test(groups="contact")
	public void script3() throws EncryptedDocumentException, IOException {
		
		ContactPage cp= new ContactPage(driver);
		cp.getContactslink().click();
		test.log(Status.INFO, "user has clicked on contact link");
		cp.getCreateContacts().click();
		test.log(Status.INFO, "user has clicked on create contact");
		cp.getLastnametxtbox().sendKeys(um.getDataFromExcelFile("Contact", 0, 0));
		test.log(Status.INFO, "user has entered data");
		OrganisationPage op= new OrganisationPage(driver);
		op.getSaveButton().click();
		test.log(Status.INFO, "user has clicked on save button");
	}
}

