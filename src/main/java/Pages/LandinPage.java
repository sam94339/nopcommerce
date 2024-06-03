package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class LandinPage extends AbstractClass{

	WebDriver driver;
	public LandinPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".topic-block-title")
	WebElement fstHeadig;
	
	public void goTo() {
		
		driver.get("https://demo.nopcommerce.com/");
	}
	

}
