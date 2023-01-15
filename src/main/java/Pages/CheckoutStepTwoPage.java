package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutStepTwoPage extends TestBase {

	@FindBy(id = "finish") private WebElement finishBtn;
	@FindBy(id = "contents_wrapper") private WebElement allInfo;
	@FindBy(xpath = "//footer[@class='footer']") private WebElement footerContent;
	public CheckoutStepTwoPage() {
		PageFactory.initElements(driver, this);
	}
	public String contentTest() {
		return allInfo.getText();
		
	}
	public String verifyFooter() {
		return footerContent.getText();
	}
	
	public String finish() {
		finishBtn.click();
		return driver.getCurrentUrl();
	}
}
