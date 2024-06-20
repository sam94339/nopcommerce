package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class LandinPage extends AbstractClass{

	public WebDriver driver;
	public LandinPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".topic-block-title")
	WebElement fstHeadig;
	
	@FindBy(xpath = "//div[@class = 'topic-block-body']/p[1]")
	WebElement fstcontent;
	
	@FindBy(xpath = "//div[@class = 'topic-block-body']/p[2]")
	WebElement sndcontent;
	
	@FindBy(xpath = "//div[@class = 'category-item']/h2/a[contains(text(), 'Electronics')]")
	WebElement fstcategory;
	
	@FindBy(xpath = "//div[@class = 'category-item']/h2/a[contains(text(), 'Apparel')]")
	WebElement sndcategory;
	
	@FindBy(xpath = "//div[@class = 'category-item']/h2/a[contains(text(), 'Digital downloads')]")
	WebElement thrdcategory;
	
	@FindBy(xpath = "//div[@class = 'product-grid home-page-product-grid']/div[@class = 'title']")
	WebElement sndheading;
	
	@FindBy(css = ".product-title")
	List<WebElement> productnames;
	
	@FindBy(css = ".button-2.product-box-add-to-cart-button")
	List<WebElement> addtocartbtn;
	
	public void goTo() {
		
		driver.get("https://demo.nopcommerce.com/");
		
	}
	
	public String fstcatglink() {
		
		String link1 = fstcategory.getAttribute("href");
		return link1;
	}
	
	public String sndcatglink() {
		
		String link2 = sndcategory.getAttribute("href");
		return link2;
	}
	
	public String thrdcatglink() {
		
		String link3 = thrdcategory.getAttribute("href");
		return link3;
	}
	
	public String fstheadingtext() {
		
		String fsthdg = fstHeadig.getText();
		return fsthdg;
	}
	
	public String fstcnttxt() {
		
		String fstcnt = fstcontent.getText();
		return fstcnt;
	}
	
	public String sndcnttxt() {
		
		String sndcnt = sndcontent.getText();
		return sndcnt;
	}
	
	public String sndhndttxt() {
		
		String sndhdng = sndheading.getText();
		return sndhdng;
	}
	
	public String addtocartprocess() {
		
		for(int i = 0; i<productnames.size(); i++) {
			
			String name = productnames.get(i).getText();
			
			if(name.equalsIgnoreCase("HTC One M8 Android L 5.0 Lollipop")) {
				
				addtocartbtn.get(i).click();
			}
		}
		
		explicitwait(ntfbar);
		String sccsntfmssg = ntfbar.getText();
		return sccsntfmssg; 
	}
	
	public CartPage headercartclick() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(1090,22)", "");
		
	    crossbutton.click();
		cart.click();
		CartPage crtpg = new CartPage(driver);
		return crtpg;
	}
	

}
