package testNgTopic;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderProgram {

	@DataProvider
	public String[][] getdata(){
		String[][] data= new String[2][3];
		data[0][0]="raghav";
		data[0][1]="A+";
		data[0][2]="raghav@gmail.com";
		
		data[1][0]="lavs";
		data[1][1]="O+";
		data[1][2]="lavs@gmail.com";
		
		return data;
	}
	@Test(dataProvider= "getdata")
	public void details(String name,String bloodgroup,String email) {
	
	  Reporter.log(name,true);
	  Reporter.log(bloodgroup,true);
	  Reporter.log(email,true);
	
	
		
		
	}
}

