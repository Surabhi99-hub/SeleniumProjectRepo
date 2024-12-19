package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	private WebElement newsbuttonnew;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement textfield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement newsbuttonsave;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public ManageNewsPage newButton() {
		newsbuttonnew.click();
		return this;
	}

	public ManageNewsPage enterText(String text) {
		textfield.sendKeys(text);
		return this;
	}

	public ManageNewsPage saveButton() {
		newsbuttonsave.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
