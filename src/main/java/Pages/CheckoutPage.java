package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Abstract.AbstractClass;

public class CheckoutPage extends AbstractClass{

	public WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Billing
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
	
	@FindBy(xpath = "//div[@id = 'billing-buttons-container']/button[2]")
	WebElement billingcontinuebtn;
	
	//Shipping
	@FindBy(css = ".method-name")
	List<WebElement> shippingmethod;
	
	@FindBy(css = ".button-1.shipping-method-next-step-button")
	WebElement shippingcontinuebtn;
	
	@FindBy(xpath = "//div[@id = 'shipping-method-buttons-container']/p/a")
	WebElement shippingback;
	
	//Payment
	@FindBy(xpath = "//input[@name = 'paymentmethod']")
	List<WebElement> radiobtn;
	
	@FindBy(xpath = "//div[@class = 'payment-details']/label")
	List<WebElement> paymenttype;
	
	@FindBy(css = ".button-1.payment-method-next-step-button")
	WebElement paymentcontinuebtn;
	
	@FindBy(xpath = "//div[@id = 'payment-method-buttons-container']/p/a")
	WebElement paymentback;
	
	//Payment Information
	
	@FindBy(xpath = "//div[@id = 'payment-info-buttons-container']/p/a")
	WebElement paymentinfoback;
	
	@FindBy(css = ".button-1.payment-info-next-step-button")
	WebElement paymentinfocontinuebtn;
	
	//Using Check
	
	@FindBy(xpath ="//td/p[1]")
	WebElement paymenttext;
	
	//Using Credit Card
	
	@FindBy(id = "CreditCardType")
	WebElement cardtype;
	
	@FindBy(id = "CardholderName")
	WebElement cardholdername;
	
	@FindBy(id = "CardNumber")
	WebElement cardnumber;
	
	@FindBy(id = "ExpireMonth")
	WebElement expireMonth;
	
	@FindBy(id = "ExpireYear")
	WebElement expireYear;
	
	@FindBy(id = "CardCode")
	WebElement cardCode;
	
	//Confirm Order
	
	@FindBy(xpath = "//td[@class = 'sku']/span")
	List<WebElement> productsku;
	
	@FindBy(xpath = "//div[@class = 'billing-info']/div")
	WebElement billinginfo;
	
	@FindBy(xpath = "//div[@class = 'shipping-info']/div")
	WebElement shippinginfo;
	
	@FindBy(css = ".button-1.confirm-order-next-step-button")
	WebElement cnfrmordercontinuebtn;
	
	@FindBy(xpath = "//div[@id = 'confirm-order-buttons-container']/p/a")
	WebElement continuorderback;
	
	//Order Completed
	
	@FindBy(xpath = "//h1[contains(text(),'Thank you')]")
	WebElement thankyoumsg;
	
	@FindBy(xpath = "//div[@class = 'section order-completed']/div[@class = 'title']")
	WebElement successordermessage;


	public String pageheadingmethod() {
		
		String checckoutpageheding = pageheading.getText();
		return checckoutpageheding; 
	}
	
	public void billingInfoadd(String Firstname, String Lastname, String email, String company, String country,
			                      String city, String Address1, String Address2, String zipcode, String phnnumber, String fax) 
	{
		
		billingfstname.sendKeys(Firstname);
		billinglstname.sendKeys(Lastname);
		billingeml.sendKeys(email);
		billingcmpny.sendKeys(company);
		
		Select objSelect =new Select(billingcountry);
		objSelect.selectByVisibleText(country);
		
		billingcity.sendKeys(city);
		billingaddress1.sendKeys(Address1);
		billingaddress2.sendKeys(Address2);
		billingzipcode.sendKeys(zipcode);
		billingphnnumber.sendKeys(phnnumber);
		billingfax.sendKeys(fax);
		billingcontinuebtn.click();
	}
	
	public void shippinginfo(String shippingtypename) {
		
		for(int i = 0; i<shippingmethod.size(); i++) {
			
			String shippingtype = shippingmethod.get(i).getText();
			if(shippingtype.equalsIgnoreCase(shippingtypename)) {
				
				shippingmethod.get(i).click();
			}
		}
		
		shippingcontinuebtn.click();
		
	}
	
	public void paymentinfo(String methodname, String creditcardtype, String holdername, 
			String crdno, String month, String year, String code) {
		
		for(int i = 0; i<paymenttype.size(); i++) {
			
			String paymentmethodname = paymenttype.get(i).getText();
			
			if(paymentmethodname.equalsIgnoreCase(methodname)) {
				
				radiobtn.get(i).click();
				paymentcontinuebtn.click();
				
				if(paymentmethodname.equalsIgnoreCase("Credit Card")) {
					
					Select objSelect1 =new Select(cardtype);
					objSelect1.selectByVisibleText(creditcardtype);
					cardholdername.sendKeys(holdername);
					cardnumber.sendKeys(crdno);
					
					Select objSelect2 =new Select(expireMonth);
					objSelect2.selectByVisibleText(month);
					
					Select objSelect3 =new Select(expireYear);
					objSelect3.selectByVisibleText(year);
					
					cardCode.sendKeys(code);
					paymentinfocontinuebtn.click();
				}
				else if(paymentmethodname.equalsIgnoreCase("Check / Money Order")){
					
					Assert.assertEquals(paymenttext.getText(), "Mail Personal or Business Check, Cashier's Check or money order to:");
					paymentinfocontinuebtn.click();
				}
			}
			
		}
	}
	
	public String orderconfirmstate() {
		
		String pdctsku = null;
		Assert.assertEquals(billinginfo.getText(), "Billing Address");
		Assert.assertEquals(shippinginfo.getText(), "Shipping Address");
		for(int i = 0; i<productsku.size(); i++) {
			
			String sku = productsku.get(i).getText();
			if(sku.equalsIgnoreCase("M8_HTC_5L")) {
				
				pdctsku = productsku.get(i).getText();
			}
		}
		
		cnfrmordercontinuebtn.click();
		return pdctsku;
	}
	
	public void afterorder() {
		
		Assert.assertEquals(thankyoumsg.getText(), "Thank you");
		Assert.assertEquals(successordermessage.getText(), "Your order has been successfully processed!");
	}
	
	
}
