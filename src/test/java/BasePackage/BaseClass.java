package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pages.LandinPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public LandinPage landingpage;
	
	public WebDriver initialization() throws IOException {
		
		Properties pop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\DataPackage\\getdata.properties");
		pop.load(file);
		
		String browsername = pop.getProperty("browser");
		
		if(browsername.contains("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browsername.contains("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browsername.contains("safari")){
			
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		
		else {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public List<HashMap<String, String>> getData(String filepath) throws IOException {
		
		String jsonData =FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>(){
			
		});
		
		return data;
	}
	
	public String sceernshotTaken(String testcaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(System.getProperty("user.dir") + "//ExtentReport" + testcaseName + ".png" );
		FileUtils.copyFile(SrcFile, DestFile);
		
		return System.getProperty("user.dir") + "//ExtentReport" + testcaseName + ".png";
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandinPage gotoLandingpage() throws IOException{
		
		driver = initialization();
		landingpage = new LandinPage(driver);
		landingpage.goTo();
		return landingpage;
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		
		driver.close();	
		
	}
	
	

}
