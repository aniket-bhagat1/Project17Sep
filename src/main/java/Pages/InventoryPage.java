package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.UtilityMethod;

public class InventoryPage extends TestBase {
	
	
	@FindBy(xpath = "//a[@href=\"https://twitter.com/saucelabs\"]") private WebElement twitterIcon;
	@FindBy(xpath = "//a[@href=\"https://www.facebook.com/saucelabs\"]") private WebElement facebookIcon;
	@FindBy(xpath = "//a[@href=\"https://www.linkedin.com/company/sauce-labs/\"]") private WebElement linkedInIcon;
	@FindBy(xpath = "//span[text()='Products']") private WebElement productsLable;
	@FindBy(xpath = "//div[@class=\"peek\"]") private WebElement peekLogo;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPack;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLight;
	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt") private WebElement boltTShirt;
	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket") private WebElement fleeceJacket;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement sortProductsDropdown;
	@FindBy(xpath = "//img[@alt='Swag Bot Footer']") private WebElement swagBotFooter;
	@FindBy(xpath = "//span[text()='4']") private WebElement cart1;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement clickOnCart;
	public InventoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyInventoryTitle() {
		return driver.getTitle();
	}
	public boolean verifyProductsLabel() {
		return productsLable.isDisplayed();
	}
	public boolean verifyPeekLogo() {
		return peekLogo.isDisplayed();
	}
	public boolean verifyTwitterIcon() {
		return twitterIcon.isDisplayed();
	}
	public boolean verifyFacebookIcon() {
		return facebookIcon.isDisplayed();
	}
	public boolean verifyLinkedInIcon() {
		return linkedInIcon.isDisplayed();
	}
	public boolean verifySwagBotFooter() {
		return swagBotFooter.isDisplayed();
	}
	public String verifyAddToCartBackPack() throws Exception {
//		Select s = new Select(sortProductsDropdown);
//		s.selectByIndex(2);
		UtilityMethod.selectClass(sortProductsDropdown, 2);
		Thread.sleep(1000);
		backPack.click();
		bikeLight.click();
		boltTShirt.click();
		fleeceJacket.click();
		Thread.sleep(1000);
		return cart1.getText();
	}
	public String verifyClickOnCart() {
		clickOnCart.click();
		return driver.getCurrentUrl();
	}
	
}
