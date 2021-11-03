package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.LoginPage;
import page.MyAccountPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	
	@Test
	@Parameters({"userName", "password"})
	public void validuserShouldBeAbleToLogin(String username, String password) throws InterruptedException {
		driver = BrowserFactory.init();
		Thread.sleep(1500);
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password.toString());
		loginPage.pressLoginButton();
		Thread.sleep(2000);
		
		MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
		myAccountPage.verifyMyAccountPage();
		
		BrowserFactory.tearDown();
		
	}
	
}
