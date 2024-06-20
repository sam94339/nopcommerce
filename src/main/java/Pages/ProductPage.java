package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class ProductPage extends AbstractClass{

	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(css = ".button-1.add-to-cart-button")
	WebElement addtocartbtn;
	
	@FindBy(xpath = "//input[@class = 'qty-input valid']")
	WebElement quantity;
	
	@FindBy(xpath = "//div[@class = 'product-name']/h1")
	WebElement productname;
	
	
	public String productname() {
		
		String prdtnam = productname.getText();
		return prdtnam;
	}
	
	public void addtocartprocess() {
		
		addtocartbtn.click();
	}
	
	public String successaddtocart() throws InterruptedException {
		
		addtocartbtn.click();
		explicitwait(ntfbar);
		String ntfmsg = ntfbar.getText();
		return ntfmsg;
	}
	
	public CartPage productclickfromCart() throws InterruptedException {
		
		
		crossbutton.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(1090,22)", "");
	    
		actonmethod(cart);
		cart.click();
		CartPage cartpgobj = new CartPage(driver);
		return cartpgobj;
	}
	
	

}
