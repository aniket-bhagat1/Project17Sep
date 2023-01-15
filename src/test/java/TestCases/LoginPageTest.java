package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.UtilityMethod;

public class LoginPageTest extends TestBase {
	
	LoginPage login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {
		
		initialization();
		login = new LoginPage();
	}
	
	@Test (priority = 1,groups = "sanity",enabled = false)
	public void verifyLoginLogoTest() {
		boolean loginLogo = login.verifyLoginLogo();
		Assert.assertEquals(loginLogo, true);
	}
	@Test(priority = 2,enabled = true,groups="failed")
	public void verifyBotLogoTest() {
		boolean botLogo = login.verifyBotLogo();
		Assert.assertEquals(botLogo, false);
	}
	
	@Test(priority = 3,enabled = false)
	public void verifyTitleTest() {
		String actResult = login.verifyTitle();
		String expResult = "Swag Labs";
		Assert.assertEquals(actResult, expResult);
	}
	@Test(priority = 4,groups= "sanity",enabled = false)
	public void verifyLinkTest() {
		String actLink = login.verifyLink();
		String expLink = "https://www.saucedemo.com/";
		Assert.assertEquals(actLink, expLink);
	}
	
	@Test (priority = 5,enabled = false)
	public void verifyLoginTest() throws Exception {
		login.verifyLogin();
		Thread.sleep(4000);
	}
	
	@Test(priority = 6,groups="sanity",enabled = true)
	public void verifyInventoryURL() throws Exception {
		login.verifyLogin();
		Thread.sleep(4000);
		String actURL = login.verifyInventoryURL();
		String expURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actURL, expURL);
	}
	@Test(priority = 7,enabled = false)
	public void verifyTitleProductTest() throws Exception {
		login.verifyLogin();
		Thread.sleep(4000);
		String actTitle = login.verifyInventoryTitle();
		String expTitle = "Swag Labs";
		Assert.assertEquals(actTitle, expTitle);
	}
	@Test(priority = 8,enabled = false)
	public void verifyProductsLogoTest() throws Exception {
		login.verifyLogin();
		Thread.sleep(2000);
		boolean actProd = login.verifyProductsLogo();
		Assert.assertEquals(actProd, true);
	}
	@Test(priority = 9,enabled = false)
	public void verifyBotIconTest() throws Exception {
		login.verifyLogin();
		Thread.sleep(2000);
		boolean actBot = login.verifyBotIcon();
		Assert.assertEquals(actBot, true);
	}
	@Test(priority = 10,enabled = false)
	public void verifyTwitterIconTest() throws Exception {
		login.verifyLogin();
		Thread.sleep(2000);
		boolean actTwitter = login.verifyTwitterIcon();
		Assert.assertEquals(actTwitter, true);
	}
	@Test(priority = 11,enabled = false)
	public void verifyFacebookIconTest() throws Exception {
		login.verifyLogin();
		Thread.sleep(2000);
		boolean actFacebook = login.verifyFacebookIcon();
		Assert.assertEquals(actFacebook, true);
	}
	@Test(priority = 12,enabled = false)
	public void verifyLinkedInIconTest() throws Exception {
		login.verifyLogin();
		Thread.sleep(2000);
		boolean actLinkedin = login.verifyLinkedInIcon();
		Assert.assertEquals(actLinkedin, true);
	}
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult a) throws Exception {
		if(ITestResult.FAILURE == a.getStatus())
		UtilityMethod.captureScreenshot(a.getName());
		driver.close();
	}
	
	

}
