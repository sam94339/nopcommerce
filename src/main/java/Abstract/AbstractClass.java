package Abstract;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {
	
	WebDriver driver;
	
	public AbstractClass(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	//Top Header Elements
	
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement register;
	
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	WebElement login;
	
	@FindBy(xpath = "//span[contains(text(),'Wishlist')]")
	WebElement wishlist;
	
	@FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
	protected
	WebElement cart;
	
	@FindBy(id = "customerCurrency")
	WebElement currency;
	
	//Mid Header Element
	
	@FindBy(xpath = "//img[@alt = 'nopCommerce demo store']")
	WebElement logo;
	
	@FindBy(xpath = "//input[@placeholder = 'Search store']")
	protected
	WebElement searchfield;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchbtn;
	
	//Menu List
	
	//1st list
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[1]")
	WebElement computer;
	
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[1]/ul/li/a[contains(text(), 'Desktop')]")
	WebElement Desktop;
	
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[1]/ul/li/a[contains(text(), 'Notebooks ')]")
	WebElement Notebooks;

	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[1]/ul/li/a[contains(text(), 'Software')]")
	WebElement Software;
	
	//2nd list
	
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[2]")
	WebElement Electronics;
	
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[2]/ul/li/a[contains(text(), 'Camera & photo ')]")
	WebElement camera;
	
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[2]/ul/li/a[contains(text(), 'Cell phones ')]")
	WebElement cellphone;
	
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[2]/ul/li/a[contains(text(), 'Others')]")
	WebElement others;
	
	//3rd list
	
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[3]")
	WebElement Apparel;
	
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[3]/ul/li/a[contains(text(), 'Shoes')]")
	WebElement shoes;
	
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[3]/ul/li/a[contains(text(), 'Clothing')]")
	WebElement Clothing;
	
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[3]/ul/li/a[contains(text(), 'Accessories')]")
	WebElement Accessories;
	
	//4th
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[4]")
	WebElement DigitalDownload;
	
	//5th
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[5]")
	WebElement Books;
	
	//6th
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[6]")
	WebElement Jewelery;
	
	//7th
	@FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[7]")
	WebElement GiftCard;
	
	//Popumessage cross button
	@FindBy(css = ".close")
	public
	WebElement crossbutton;
	
	//Popupmessage
	@FindBy(id = "bar-notification")
	public
	WebElement ntfbar;
	
	
	
	public void explicitwait(WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void actonmethod(WebElement ele) {
		
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}

}
