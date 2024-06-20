package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class Search extends AbstractClass{

	WebDriver driver;
	public Search(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".ui-menu-item-wrapper")
	List<WebElement> searchreslt;
	
	public ProductPage produtsearch(String name, String fullname) throws InterruptedException {
		
		searchfield.sendKeys(name);
		Thread.sleep(4000);
		
		for(int i=0; i<searchreslt.size(); i++) {
			
			String prdnam = searchreslt.get(i).getText();
			if(prdnam.contains(fullname)) {
				
				searchreslt.get(i).click();
			}
		}
		ProductPage prdctpageobj = new ProductPage(driver);
		return prdctpageobj;
	}
	

}
