package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
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
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue).signIn();//chaining of method
		//loginpage.enterPassword(passwordvalue);
		//loginpage.signIn();
		boolean isHomePageAvailable=loginpage.isHomePageDisplayed();
		Assert.assertTrue(isHomePageAvailable,Constants.LOGINPAGEVALIDCREDENTIALS);
	}
	
	@Test
	public void  verifyTheUserIsAbleToLoginUsingInvalidUsername() throws IOException {
		//String usernamevalue="User";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(2, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue).signIn();
		//loginpage.enterPassword(passwordvalue);
		//loginpage.signIn();
		boolean alertmessage=loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage,Constants.INVALIDUSERNAMEALERT);
	}
	
	@Test
	public void  verifyTheUserIsAbleToLoginUsingInvalidPassword() throws IOException {
		//String usernamevalue="admin";
		//String passwordvalue="12345";
		String usernamevalue=ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(3, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue).signIn();
		//loginpage.enterPassword(passwordvalue);
		//loginpage.signIn();
		boolean alertmessage=loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage,Constants.INVALIDPASSWORDALERT);
	}
	
	@Test(dataProvider ="LoginProvider")
	public void  verifyTheUserIsAbleToLoginUsingInvalidCredentials(String usernamevalue,String passwordvalue) throws IOException {
		//String usernamevalue="User";
		//String passwordvalue="12345";
		//String usernamevalue=ExcelUtility.getStringData(4, 0, "LoginPage");
		//String passwordvalue=ExcelUtility.getStringData(4, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue).signIn();
		//loginpage.enterPassword(passwordvalue);
		//loginpage.signIn();
		boolean alertmessage=loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage,Constants.INVALIDCREDENTIALSALERT);
	}
	@DataProvider(name="LoginProvider")
	public Object[][] getDataFromTestData() throws IOException{
		return new Object[][] {{ExcelUtility.getStringData(4, 0,"LoginPage"),ExcelUtility.getStringData(4,1,"LoginPage")}};
	}
}
