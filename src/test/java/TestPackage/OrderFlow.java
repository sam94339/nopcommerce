package TestPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import Pages.CartPage;
import Pages.CheckoutLoginPage;
import Pages.LandinPage;
import Pages.ProductPage;
import Pages.Search;

public class OrderFlow extends BaseClass{
	
	Search scrhobj;
	ProductPage productpageobj;
	CartPage crtpgobj;
	LandinPage lndpgobj;
	CheckoutLoginPage loginpgobj;

	//Product Search 
	@Test( enabled=false )
	public void searchproduct() throws InterruptedException{
		
		scrhobj = new Search(driver);
		productpageobj = scrhobj.produtsearch("Apple", "Apple MacBook Pro 13-inch");
		Assert.assertEquals(productpageobj.productname(), "Apple MacBook Pro 13-inch");

	}
	
	//Add to cart success message validation.
	@Test( enabled=false )
	public void successaddtocartmessage() throws InterruptedException {
		
		scrhobj = new Search(driver);
		productpageobj = scrhobj.produtsearch("Apple", "Apple MacBook Pro 13-inch");
		productpageobj.addtocartprocess();
		Assert.assertEquals(productpageobj.successaddtocart(), "The product has been added to your shopping cart");
	}
	
	@Test
	public void checkoutguest() throws InterruptedException {
		
		lndpgobj = new LandinPage(driver);
		lndpgobj.addtocartprocess();
		crtpgobj = lndpgobj.headercartclick();
		loginpgobj = crtpgobj.proceedtocheckout();
		
	}
	
	
	
}
