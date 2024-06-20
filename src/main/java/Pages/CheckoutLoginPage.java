package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class CheckoutLoginPage extends AbstractClass{

	WebDriver driver;
	
	public CheckoutLoginPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".button-1.checkout-as-guest-button")
	WebElement guestbtn;
	
	public void guestbtnclck() {
		
		guestbtn.click();
		
	}
	
	

}
