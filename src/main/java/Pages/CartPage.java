package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class CartPage extends AbstractClass{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".page-title")
	WebElement pgttl;
	
	@FindBy(css = ".quantity.up")
	List<WebElement> uparrow;
	
	@FindBy(css = ".qty-input")
	List<WebElement> prdctqnty;
	
	@FindBy(id = "checkout")
	WebElement chkot;
	
	@FindBy(id = "termsofservice")
	WebElement tandccheckbox;
	
	@FindBy(id = "read-terms")
	WebElement tandcreadbtn;
	
	@FindBy(id = "ui-id-6")
	WebElement tandcpopupheading;
	
	
	public String pageTitle() {
		
		String title = pgttl.getText();
		return title;
	}
	
	public String increasesingleproduct() {
		
		String quantity = null;
		
		for(int i = 0; i<uparrow.size(); i++) {
			
			for(int k = 0; k<2; k++) {
				
				uparrow.get(i).click();
			}
			
		}
		
		for(int j = 0; j<prdctqnty.size(); j++) {
			
			quantity = prdctqnty.get(j).getAttribute("value");
		}
		
		return quantity;
	}
	
	public String termsandconditionheading() throws InterruptedException {
		
		tandcreadbtn.click();
		Thread.sleep(2000);
		String headingtext = tandcpopupheading.getText();
		return headingtext;
	}
	
	public CheckoutLoginPage proceedtocheckout() {
		
		tandccheckbox.click();
		chkot.click();
		CheckoutLoginPage loginpgobj = new CheckoutLoginPage(driver);
		return loginpgobj;
		
	}
	
	

}
