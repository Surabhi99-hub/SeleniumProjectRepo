package testScripts;

import org.testng.annotations.Test;

import constants.Constants;

import org.testng.Assert;
import java.awt.AWTException;
import java.io.IOException;

import pages.HomePage;

//import org.testng.Assert;
//import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	HomePage homepage;
	SubCategoryPage subcatpage;
	@Test
	public void subCategory() throws AWTException, IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		// String name=ExcelUtility.getStringData(1, 0, "AddSubCategory");
		String name = ExcelUtility.getStringData(2, 0, "AddSubCategory");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		//loginpage.enterPassword(passwordvalue);
		homepage=loginpage.signIn();
		subcatpage=homepage.SubCatMoreInfo();
		//SubCategoryPage subcatpage = new SubCategoryPage(driver);
		subcatpage.newButton().addCategory().addSubcategory(name).addImage().save();
		//subcatpage.newButton();
		//subcatpage.addCategory();
		//subcatpage.addSubcategory(name);
		//subcatpage.addImage();
		//subcatpage.save();
		boolean alertmessage = subcatpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage,Constants.ADDSUBCATEGORY);
	}
}
