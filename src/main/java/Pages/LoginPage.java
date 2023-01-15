package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase{
	
	@FindBy(xpath = "//div[@class = 'login_logo']") private WebElement loginLogo;
	@FindBy(xpath = "//div[@class = 'bot_column']") private WebElement botLogo;
	@FindBy(xpath = "//input[@name='user-name']") private WebElement userName;
	@FindBy(xpath = "//input[@name='password']") private WebElement password;
	@FindBy(id = "login-button") private WebElement loginButton;
	@FindBy(xpath = "//a[@href=\"https://twitter.com/saucelabs\"]") private WebElement twitterIcon;
	@FindBy(xpath = "//a[@href=\"https://www.facebook.com/saucelabs\"]") private WebElement facebookIcon;
	@FindBy(xpath = "//a[@href=\"https://www.linkedin.com/company/sauce-labs/\"]") private WebElement linkedInIcon;
	@FindBy(xpath = "//span[text()='Products']") private WebElement productsLogo;
	@FindBy(xpath = "//div[@class=\"peek\"]") private WebElement botIcon;
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLoginLogo() {
		return loginLogo.isDisplayed();
	}
	public boolean verifyBotLogo() {
		return botLogo.isDisplayed();
	}

	
	public String verifyTitle()
	{
		return driver.getTitle();
		
	}
	public String verifyLink()
	{
		return driver.getCurrentUrl();
	}
	
	
	public void verifyLogin() throws Exception {
//		userName.sendKeys(ReadData.readPropertiesFile("username"));
		userName.sendKeys(ReadData.readExcelFile(0, 0));
		password.sendKeys(ReadData.readPropertiesFile("password"));
		loginButton.click();

	}
	public String verifyInventoryURL() {
		return driver.getCurrentUrl();
	}
	
	public String verifyInventoryTitle() {
		return driver.getTitle();
	}
	public boolean verifyProductsLogo() {
		return productsLogo.isDisplayed();
	}
	public boolean verifyBotIcon() {
		return botIcon.isDisplayed();
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
	
}
