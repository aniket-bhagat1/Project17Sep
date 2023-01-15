package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckoutStepOnePage;
import Pages.CheckoutStepTwoPage;
import Pages.FinishPage;
import Pages.InventoryPage;
import Pages.LoginPage;

public class FinishPageTest extends TestBase {
	LoginPage login;
	FinishPage finish;
	InventoryPage inventory;
	CartPage cart;
	CheckoutStepOnePage checkout1;
	CheckoutStepTwoPage check2;
	@BeforeMethod (alwaysRun = true)
	public void setup() throws Exception {
			initialization();
			finish = new FinishPage();
		 	login = new LoginPage();
			inventory = new InventoryPage();
			cart = new CartPage();
			checkout1 = new CheckoutStepOnePage();
			check2 = new CheckoutStepTwoPage();
			login.verifyLogin();
			inventory.verifyClickOnCart();
			cart.verifyCheckoutStepOne();	
			checkout1.customerInfo();
			check2.finish();
			
	}
	
	
	@Test
	public void verifyText() {
		String res = finish.verifyText();
		System.out.println(res);
	}
	@Test
	public void verifySwagBotImg() {
		boolean actRes = finish.verifySwagBotImg();
		Assert.assertEquals(actRes, true);
	}
	
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}
}
