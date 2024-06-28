package DataPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports exereport() {
		
		String extentreportfolder = System.getProperty("user.dir") + "\\ExtentReport\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentreportfolder);
		reporter.config().setReportName("Nopcommerce Test Report");
		reporter.config().setDocumentTitle("Automation Report");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Testr", "Soumyadeep Ghosh");
		return report;
		
	}

}
