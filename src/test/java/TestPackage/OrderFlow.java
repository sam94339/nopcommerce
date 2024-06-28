package TestPackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import Pages.CartPage;
import Pages.CheckoutLoginPage;
import Pages.CheckoutPage;
import Pages.LandinPage;
import Pages.ProductPage;
import Pages.Search;

public class OrderFlow extends BaseClass{
	
	Search scrhobj;
	ProductPage productpageobj;
	CartPage crtpgobj;
	LandinPage lndpgobj;
	CheckoutLoginPage loginpgobj;
	CheckoutPage checkoutpgobj;
	
	String paymenttype;

	//Product Search 
	@Test
	public void searchproduct() throws InterruptedException{
		
		scrhobj = new Search(driver);
		productpageobj = scrhobj.produtsearch("Apple", "Apple MacBook Pro 13-inch");
		Assert.assertEquals(productpageobj.productname(), "Apple MacBook Pro 13-inch");

	}
	
	//Add to cart success message validation.
	@Test
	public void successaddtocartmessage() throws InterruptedException {
		
		scrhobj = new Search(driver);
		productpageobj = scrhobj.produtsearch("Apple", "Apple MacBook Pro 13-inch");
		productpageobj.addtocartprocess();
		Assert.assertEquals(productpageobj.successaddtocart(), "The product has been added to your shopping cart");
	}
	
	@Test(dataProvider = "dataprovider", groups = {"Group1"})
	public void checkoutguest(HashMap<String, String>Input) throws InterruptedException {
		
		lndpgobj = new LandinPage(driver);
		lndpgobj.addtocartprocess();
		crtpgobj = lndpgobj.headercartclick();
		loginpgobj = crtpgobj.proceedtocheckout();
		checkoutpgobj = loginpgobj.guestbtnclck();
		Assert.assertEquals(checkoutpgobj.pageheadingmethod(), "Checkout");
		checkoutpgobj.billingInfoadd(Input.get("fname"), Input.get("lname"), Input.get("email"), "", Input.get("country"), 
				Input.get("city"), Input.get("Address1"), "", Input.get("Zip"), Input.get("phn"), "");
		checkoutpgobj.shippinginfo(Input.get("shippingmethod"));
		checkoutpgobj.paymentinfo(Input.get("paymentmethod"), Input.get("cardtype"), Input.get("holdername"), Input.get("card number"), 
				Input.get("month"), Input.get("year"), Input.get("cvv"));
		Assert.assertEquals(checkoutpgobj.orderconfirmstate(), "M8_HTC_5L");
		checkoutpgobj.afterorder();
		Thread.sleep(3000);
		
	}
	
	@DataProvider
	public Object[][] dataprovider() throws IOException {
		
		
		List<HashMap<String, String>> data = getData(System.getProperty("user.dir")+"//src//test//java//DataPackage//guestorderflow.json");
		
		
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
//	HashMap<String, String> map = new HashMap<String, String>();
//	map.put("fname", "Soumyadeep");
//	map.put("lname", "Ghosh");
//	map.put("email", "soumyadeep@yopmail.com");
//	map.put("country", "India");
//	map.put("city", "Kolkata");
//	map.put("Address1", "Maniktala");
//	map.put("Zip", "700005");
//	map.put("phn", "1234567890");
//	map.put("shippingmethod", "Next Day Air ($0.00)");
//	map.put("paymentmethod", "Credit Card");
//	map.put("cardtype", "Amex");
//	map.put("holdername", "Test User");
//	map.put("card number", "378282246310005");
//	map.put("month", "02");
//	map.put("year", "2026");
//	map.put("cvv", "133");
//	
//	HashMap<String, String> map1 = new HashMap<String, String>();
//	map1.put("fname", "Soumya");
//	map1.put("lname", "Test");
//	map1.put("email", "test@yopmail.com");
//	map1.put("country", "India");
//	map1.put("city", "Bangalor");
//	map1.put("Address1", "Abc");
//	map1.put("Zip", "12345");
//	map1.put("phn", "2345633789");
//	map1.put("shippingmethod", "2nd Day Air ($0.00)");
//	map1.put("paymentmethod", "Check / Money Order");
//	map1.put("cardtype", "");
//	map1.put("holdername", "");
//	map1.put("card number", "");
//	map1.put("month", "");
//	map1.put("year", "");
//	map1.put("cvv", "");
	
}
