package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class FinishPage extends TestBase{

	@FindBy(id = "checkout_complete_container") private WebElement text;
	@FindBy(xpath = "//img[@alt='Swag Bot Footer']") private WebElement swagBotImg;
	
	public FinishPage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyText() {
		return text.getText();
	}
	public boolean verifySwagBotImg() {
		return swagBotImg.isDisplayed();
	}
}
