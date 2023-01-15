package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class CheckoutStepOnePage extends TestBase {

	@FindBy(id = "first-name") private WebElement firstName;
	@FindBy(id = "last-name") private WebElement lastName;
	@FindBy(id = "postal-code") private WebElement postalCode;
	@FindBy(id = "continue") private WebElement continueBtn;
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogoSwagLab;
	@FindBy(xpath = "//img[@class='footer_robot']") private WebElement footerImg;
	
	public CheckoutStepOnePage() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyAppLogo() {
		return appLogoSwagLab.isDisplayed();
	}
	public boolean verifyFooterImg() {
		return footerImg.isDisplayed();
	}
	
	public String customerInfo() throws Exception {
		firstName.sendKeys(ReadData.readPropertiesFile("firstName"));
		lastName.sendKeys(ReadData.readPropertiesFile("lastName"));
		postalCode.sendKeys(ReadData.readPropertiesFile("postalCode"));
		continueBtn.click();
		Thread.sleep(1000);
		return driver.getCurrentUrl();
	}
	
}
