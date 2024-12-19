package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")
	private WebElement logout;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']")
	private WebElement managenewsmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category' and @class=' nav-link']")
	private WebElement subcatmoreinfo;
	
	public ManageNewsPage newsMoreInfo() {
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}
	
	public SubCategoryPage SubCatMoreInfo() {
		subcatmoreinfo.click();
		return new SubCategoryPage(driver);
	}
	
	public HomePage clickAdmin() {
		admin.click();
		return this;
	}

	public HomePage logoutButton() {
		logout.click();
		return this;
	}

	public boolean isLoginPageDisplayed() {
		return signin.isDisplayed();
	}
}
