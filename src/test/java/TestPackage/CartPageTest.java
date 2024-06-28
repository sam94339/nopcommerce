package TestPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import Pages.CartPage;
import Pages.LandinPage;
import Pages.ProductPage;
import Pages.Search;

public class CartPageTest extends BaseClass{

	LandinPage lndpg;
	CartPage crtpgobj;
	
	//Success message checking after single product add to cart.
	@Test
	public void addtocartsccsmsgchecking() throws InterruptedException {
		
		lndpg = new LandinPage(driver);
		Assert.assertEquals(lndpg.addtocartprocess(), "The product has been added to your shopping cart 123");
		
	}
	
	//
//	@Test(dependsOnMethods = {"addtocartsccsmsgchecking"}) 
//	public void cartheading() throws InterruptedException{
//		
//		
//		crtpgobj = pdctpgobj.productclickfromCart();
//		Assert.assertEquals(crtpgobj.increasesingleproduct(), "4");
//	}
	
//	@Test(dependsOnMethods = {"productIncrease"})
//	public void termsandcondition() throws InterruptedException {
//		
//		crtpgobj = pdctpgobj.productclickfromCart();
//		Assert.assertEquals(crtpgobj.termsandconditionheading(), "Terms of service");
//	}
}
