package helperAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class LearningPriority
{
	@Test(priority=1)
	public void logout() {
		Reporter.log("user has logout",true);
	}
	

}
