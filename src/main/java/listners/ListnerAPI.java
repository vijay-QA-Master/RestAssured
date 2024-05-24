package listners;
import java.io.IOException;

import org.testng.ITestListener;

import org.testng.ITestResult;

public class ListnerAPI implements ITestListener
{
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		try {
			System.out.println("Test Got Failed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		try {
			System.out.println("Your Test Got Passed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
