package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.UtilityMethod;

public class InventoryPageTest extends TestBase {
	LoginPage login2;
	InventoryPage inventory;
	@BeforeMethod (alwaysRun = true)
	public void setup() throws Exception 
	{
		initialization();
		inventory = new InventoryPage();
		login2 = new LoginPage();
		login2.verifyLogin();
	}
	@Test(enabled = true,groups="sanity")
	public void verifyProductsLogoTest() throws Exception 
	{
		boolean actProd = inventory.verifyProductsLabel();
		Assert.assertEquals(actProd, true);
	}
	
	@Test(enabled = false)
	public void verifyBotIconTest() throws Exception 
	{
		boolean actBot = inventory.verifyPeekLogo();
		Assert.assertEquals(actBot, true);
	}
	@Test(enabled = false)
	public void verifyTwitterIconTest() throws Exception 
	{
		boolean actTwitter = inventory.verifyTwitterIcon();
		Assert.assertEquals(actTwitter, true);
	}
	@Test(enabled = false)
	public void verifyFacebookIconTest() throws Exception 
	{
		boolean actFacebook = inventory.verifyFacebookIcon();
		Assert.assertEquals(actFacebook, true);
	}
	@Test(enabled = false)
	public void verifyLinkedInIconTest() throws Exception {
	
		boolean actLinkedin = inventory.verifyLinkedInIcon();
		Assert.assertEquals(actLinkedin, true);
	}
	@Test(enabled = false)
	public void verifySwagBotFooterTest() {
		boolean result = inventory.verifySwagBotFooter();
		Assert.assertEquals(result, true);
	}
	@Test(enabled = true,groups="failed")
	public void verifyAddToCartBackPackTest() throws Exception {
		String result = inventory.verifyAddToCartBackPack();
		Thread.sleep(1000);
		Assert.assertEquals(result, "5");
	}
	@Test(groups="failed")
	public void verifyClickOnCartTest() {
	String expRes = "https://www.saucedemo.com/cart.htmlh";
	String actRes = inventory.verifyClickOnCart();
	Assert.assertEquals(actRes, expRes);
	}
	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult a) throws Exception {
		if(ITestResult.FAILURE == a.getStatus())
			UtilityMethod.captureScreenshot(a.getName());
		driver.close();
	}
	
}
