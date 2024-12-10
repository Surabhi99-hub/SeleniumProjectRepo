package testScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.io.IOException;

//import org.testng.Assert;
//import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base{
	@Test
	public void subCategory() throws AWTException, IOException {
		String usernamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		SubCategoryPage subcatpage= new SubCategoryPage(driver);
		subcatpage.SubCatmoreInfo();
		subcatpage.newButton();
		subcatpage.addCategory();
		//String name=ExcelUtility.getStringData(1, 0, "AddSubCategory");
		String name=ExcelUtility.getStringData(2, 0, "AddSubCategory");
		subcatpage.addSubcategory(name);
		subcatpage.addImage();
		subcatpage.save();
		boolean alertmessage=subcatpage.isAlertDisplayed();
		AssertJUnit.assertTrue(alertmessage);
	}
}
