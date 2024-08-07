package TestPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import BasePackage.Retry;
import Pages.LandinPage;

public class HomeTest extends BaseClass{
	
	LandinPage landingpageobj;
	
	@Test(groups = {"Group2"})
	public void categorylinkTest() {
		
		landingpageobj = new LandinPage(driver);
		Assert.assertEquals(landingpageobj.fstcatglink(), "https://demo.nopcommerce.com/electronics");
		Assert.assertEquals(landingpageobj.sndcatglink(), "https://demo.nopcommerce.com/apparel");
		Assert.assertEquals(landingpageobj.thrdcatglink(), "https://demo.nopcommerce.com/digital-downloads");
	}
	
	@Test
	public void heading() {
		
		landingpageobj = new LandinPage(driver);
		Assert.assertEquals(landingpageobj.fstheadingtext(), "Welcome to our store");
		Assert.assertEquals(landingpageobj.sndhndttxt(), "Featured products Test");
	}
	
	@Test(retryAnalyzer = Retry.class)
	public void homecontent() {
		
		landingpageobj = new LandinPage(driver);
		Assert.assertEquals(landingpageobj.fstcnttxt(), "Online shopping is the process consumers go through to purchase products or services over the Internet. You can edit this in the admin site.");
		Assert.assertEquals(landingpageobj.sndcnttxt(), "If you have questions, see the Documentation, or post in the Forums at nopCommerce.com");
	}

}
