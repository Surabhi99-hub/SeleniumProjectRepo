package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test
	public void manageNews() throws IOException {
		// String usernamevalue="admin";
		// String passwordvalue="admin";
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String message = ExcelUtility.getStringData(1, 0, "ManageNews");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		//loginpage.enterPassword(passwordvalue);
		homepage=loginpage.signIn();
		managenewspage=homepage.newsMoreInfo();
		//ManageNewsPage managenews = new ManageNewsPage(driver);
		managenewspage.newButton().enterText(message).saveButton();
		//managenewspage.newButton();
		//managenewspage.enterText(message);
		//managenewspage.saveButton();
		boolean alertmessage = managenewspage.isAlertDisplayed();
		Assert.assertTrue(alertmessage,Constants.ADDNEWS);
	}
}
