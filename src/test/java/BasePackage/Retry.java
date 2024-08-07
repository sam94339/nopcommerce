package BasePackage;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//This class is for failed test for multiple times.

public class Retry implements IRetryAnalyzer{

	int count = 0;
	int max = 2;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<max) {
			
			count++;
			return true;
		}
		return false;
	}

}
