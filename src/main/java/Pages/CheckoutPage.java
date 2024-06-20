package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class CheckoutPage extends AbstractClass{

	public WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".page-title")
	WebElement pageheading;
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement billingfstname;
	
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement billinglstname;
	
	@FindBy(id = "BillingNewAddress_Email")
	WebElement billingeml;
	
	@FindBy(id = "BillingNewAddress_Company")
	WebElement billingcmpny;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement billingcountry;
	
	@FindBy(id = "BillingNewAddress_StateProvinceId")
	WebElement billingstate;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement billingcity;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement billingaddress1;
	
	@FindBy(id = "BillingNewAddress_Address2")
	WebElement billingaddress2;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement billingzipcode;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement billingphnnumber;
	
	@FindBy(id = "BillingNewAddress_FaxNumber")
	WebElement billingfax;
	
	

}
