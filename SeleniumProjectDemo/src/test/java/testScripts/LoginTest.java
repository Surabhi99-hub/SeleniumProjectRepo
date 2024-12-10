package testScripts;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(description="Login with valid username and password",retryAnalyzer=retry.Retry.class,groups={"Regression"})
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		boolean isHomePageAvailable=loginpage.isHomePageDisplayed();
		AssertJUnit.assertTrue(isHomePageAvailable);
	}
	
	@Test
	public void  verifyTheUserIsAbleToLoginUsingInvalidUsername() throws IOException {
		//String usernamevalue="User";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(2, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		boolean alertmessage=loginpage.isAlertDisplayed();
		AssertJUnit.assertTrue(alertmessage);
	}
	
	@Test
	public void  verifyTheUserIsAbleToLoginUsingInvalidPassword() throws IOException {
		//String usernamevalue="admin";
		//String passwordvalue="12345";
		String usernamevalue=ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getIntegerData(3, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		boolean alertmessage=loginpage.isAlertDisplayed();
		AssertJUnit.assertTrue(alertmessage);
	}
	
	@Test
	public void  verifyTheUserIsAbleToLoginUsingInvalidCredentials() throws IOException {
		//String usernamevalue="User";
		//String passwordvalue="12345";
		String usernamevalue=ExcelUtility.getStringData(4, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getIntegerData(4, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		boolean alertmessage=loginpage.isAlertDisplayed();
		AssertJUnit.assertTrue(alertmessage);
	}

}
