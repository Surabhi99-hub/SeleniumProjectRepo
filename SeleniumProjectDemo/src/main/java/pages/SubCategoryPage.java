package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class SubCategoryPage {
	WebDriver driver;
	public SubCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver , this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category' and @class=' nav-link']")private WebElement moreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newbutton;
	@FindBy(xpath="//select[@id='cat_id']")private WebElement category;
	@FindBy(xpath="//input[@id='subcategory']")private WebElement subcategory;
	@FindBy(xpath="//input[@id='main_img']")private WebElement image;
	@FindBy(xpath="//button[@type='submit']")private WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	
	public void SubCatmoreInfo() {
		moreinfo.click();
	}
	public void newButton() {
		newbutton.click();
	}
	public void addCategory() {
		PageUtility pageutility=new PageUtility();
		//pageutility.selectByVisibleText(category, "Appliances");
		pageutility.selectByVisibleText(category, "cate1");
	}
	public void addSubcategory(String name) {
		subcategory.sendKeys(name);
	}
	public void addImage() throws AWTException {
		FileUploadUtility fileutility=new FileUploadUtility();
		//fileutility.fileuploadUsingRobotclass(image, Constants.FridgeIMG);
		fileutility.fileUploadUsingSendkeys(image, Constants.bouquet);
	}
	public void save() {
		//savebutton.click();
		PageUtility pageutility=new PageUtility();
		pageutility.clickElementUsingJSExecutor(driver,savebutton);
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
