package testScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;

public class Base {
	public WebDriver driver;
	public  ScreenshotUtility scrshot;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver =new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver =new EdgeDriver();	
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver =new FirefoxDriver();
		}
		else
		{
			throw new Exception("browser is not correct");
		}
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");	
		driver.manage().window().maximize();
	}
	@AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenshotUtility();
			scrshot.captureFailureScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}
}
