package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;

public class CartPageTest extends TestBase {
	LoginPage login;
	InventoryPage inventory;
	CartPage cart;
	@BeforeMethod (alwaysRun = true)
	public void setup() throws Exception {
		initialization();
		login = new LoginPage();
		inventory = new InventoryPage();
		cart = new CartPage(); 
		login.verifyLogin();
	//	inventory.verifyClickOnCart();
	}
	
	
	@Test(enabled = false)
	public void verifyAppLogoSwagLabTest() {
		boolean result = cart.verifyAppLogoSwagLab();
		Assert.assertEquals(result, true);
	}
	@Test(enabled = false)
	public void verifyYourCartLabelTest() {
		boolean result = cart.verifyYourCartLabel();
		Assert.assertEquals(result, true);
	}
	@Test(enabled = false)
	public void verifyTwitterIconTest() {
		boolean result = cart.verifyTwitterIcon();
		Assert.assertEquals(result, true);
	}
	@Test(enabled = false)
	public void verifyFacebookIconTest() {
		boolean result = cart.verifyFacebookIcon();
		Assert.assertEquals(result, true);
	}
	@Test(enabled = false)
	public void verifyLinkedInIconTest() {
		boolean result = cart.verifyLinkedInIcon();
		Assert.assertEquals(result, true);
	}
	@Test(enabled = false)
	public void verifySwagBotImgTest() {
		boolean result = cart.verifySwagBotImg();
		Assert.assertEquals(result, true);
	}
	@Test(enabled = false)
	public void verifyCartFooterTest() {
		String result = cart.verifyCartFooter();
		System.out.println(result);
	}
	@Test
	public void verifyProductsRemovedTest() throws Exception {
		String rest = inventory.verifyAddToCartBackPack();
		System.out.println(rest);
		String result = cart.verifyProductsRemoved();
		Assert.assertEquals(result, "2");
		Reporter.log(result);
	}
	@Test(enabled = false)
	public void verifyCheckoutStepOneTest() throws Exception {
		String actResult = cart.verifyCheckoutStepOne();
		String expResult = "https://www.saucedemo.com/checkout-step-one.html";
		Assert.assertEquals(actResult, expResult);
		Reporter.log("Url Of the Webpage : " + actResult);
	}
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}
}
