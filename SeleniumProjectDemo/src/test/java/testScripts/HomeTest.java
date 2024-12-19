package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	HomePage homepage;
	@Test
	public void verifyTheUserIsAbleToLogOut() throws IOException {
		String usernamefield = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordfield = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamefield).enterPassword(passwordfield);
		///loginpage.enterPassword(passwordfield);
		homepage=loginpage.signIn();
		//HomePage homepage = new HomePage(driver);
		homepage.clickAdmin().logoutButton();//chaining of method
		boolean login = homepage.isLoginPageDisplayed();
		Assert.assertTrue(login, Constants.LOGOUT);
	}
}
