package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckoutStepOnePage;
import Pages.CheckoutStepTwoPage;
import Pages.InventoryPage;
import Pages.LoginPage;

public class CheckoutStepTwoPageTest extends TestBase {
	CheckoutStepTwoPage check2;
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
		check2 = new CheckoutStepTwoPage();
		login.verifyLogin();
		inventory.verifyClickOnCart();
		cart.verifyCheckoutStepOne();	
		checkout1.customerInfo();
		
	}
	
	@Test
	public void finish() {
		String actRes = check2.finish();
		String expRes = "https://www.saucedemo.com/checkout-complete.html";
		Assert.assertEquals(actRes, expRes);
	}
	@Test
	public void contentTest() {
		String actRes = check2.contentTest();
		System.out.println(actRes);
	}
	@Test 
	public void verifyFooter() {
		String actRes = check2.verifyFooter();
		System.out.println(actRes);
	}
	
	
	
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}
	
	
}
