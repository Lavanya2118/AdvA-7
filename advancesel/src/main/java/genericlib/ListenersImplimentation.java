package genericlib;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersImplimentation extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Test Script Excution Stared",true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test Script Failed",true);
		Reporter.log(result.getName());
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(IConstant.screenShotPath);
		try {
			FileHandler.copy(source, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Script Passed",true);
	}
	
}

