package BasePackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import DataPackage.ExtentReportNG;

public class Listeners extends BaseClass implements ITestListener{
		
	ExtentReports report = ExtentReportNG.exereport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentLocal = new ThreadLocal<ExtentTest>(); //This for make unique thread for individual test cases for paralla test run 
	
	@Override		
    public void onTestStart(ITestResult arg0) {					
        
		test = report.createTest(arg0.getMethod().getMethodName());
		extentLocal.set(test); //unique thread id for individual test cases.;
    }
	
	@Override		
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }
	
    @Override		
    public void onTestFailure(ITestResult arg0) {					
        
    	extentLocal.get().fail(arg0.getThrowable());
    	try {
			driver = (WebDriver) arg0.getTestClass().getRealClass().getField("driver")
					.get(arg0.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String path = null;
    	try {
			path = sceernshotTaken(arg0.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	test.addScreenCaptureFromPath(path, arg0.getMethod().getMethodName());
        		
    }		

    @Override		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }					
    
    @Override		
    public void onFinish(ITestContext arg0) {					
        
    	report.flush();
        		
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }	

}
