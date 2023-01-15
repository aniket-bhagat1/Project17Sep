package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckoutStepOnePage;
import Pages.InventoryPage;
import Pages.LoginPage;

public class CheckoutStepOnePageTest extends TestBase{
	LoginPage login;
	InventoryPage inventory;
	CartPage cart;
	CheckoutStepOnePage checkout1;
	@BeforeMethod (alwaysRun = true)
	public void setup() throws Exception {
		initialization();
		login = new LoginPage();
		inventory = new InventoryPage();
		cart = new CartPage();
		checkout1 = new CheckoutStepOnePage();
		login.verifyLogin();
		inventory.verifyClickOnCart();
		cart.verifyCheckoutStepOne();	
	}
	
	@Test
	public void customerInfoTest() throws Exception {
		String actRes = checkout1.customerInfo();
		String expRes = "https://www.saucedemo.com/checkout-step-two.html";
		Assert.assertEquals(actRes, expRes);
	}
	@Test (groups="sanity")
	public void verifyAppLogoTest() {
		boolean actRes = checkout1.verifyAppLogo();
		Assert.assertEquals(actRes, true);
	}
	@Test
	public void verifyFooterImgTest() {
		boolean actRes = checkout1.verifyFooterImg();
		Assert.assertEquals(actRes, true);
	}
	
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}
}
