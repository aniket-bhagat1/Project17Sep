package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartPage extends TestBase{

	@FindBy(xpath = "//span[@class='title']") private WebElement yourCartLabel;
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogoSwagLab;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterIcon;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookIcon;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedInIcon;
	@FindBy(xpath = "//img[@alt='Swag Bot Footer']") private WebElement swagBotImg;
	@FindBy(xpath = "//div[@class='cart_footer']") private WebElement cartFooter;
	@FindBy(id = "checkout") private WebElement checkoutBtn;
	@FindBy(id = "remove-sauce-labs-backpack") private WebElement removeBackPack;
	@FindBy(id = "remove-sauce-labs-bike-light") private WebElement removeBikeLight;
	@FindBy(xpath = "//span[text()='2']") private WebElement cartCount;
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyYourCartLabel() {
		return yourCartLabel.isDisplayed();
	}
	public boolean verifyAppLogoSwagLab() {
		return appLogoSwagLab.isDisplayed();
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
	public boolean verifySwagBotImg() {
		return swagBotImg.isDisplayed();
	}
	
	public String verifyCartFooter() {
		return cartFooter.getText();
	}
	public String verifyProductsRemoved() {
		removeBackPack.click();
		removeBikeLight.click();
		return cartCount.getText();
	}
	public String verifyCheckoutStepOne() throws Exception {
		checkoutBtn.click();
		Thread.sleep(1000);
		return driver.getCurrentUrl();
	}
}
