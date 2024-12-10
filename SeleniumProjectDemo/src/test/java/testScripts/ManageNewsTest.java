package testScripts;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	@Test
	public void manageNews() throws IOException {
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		ManageNewsPage managenews= new ManageNewsPage(driver);
		managenews.moreInfo();
		managenews.newButton();
		//String message="Welcome to 7rmart Supermarket";
		String message=ExcelUtility.getStringData(1, 0, "ManageNews");
		managenews.enterText(message);
		managenews.saveButton();
		boolean alertmessage=managenews.isAlertDisplayed();
		AssertJUnit.assertTrue(alertmessage);
	}
}
