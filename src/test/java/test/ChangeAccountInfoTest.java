package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.LoginPage;
import page.MyAccountPage;
import page.YourPersonalInfoPage;
import util.BrowserFactory;

public class ChangeAccountInfoTest {

	WebDriver driver;
	
	@Test
	@Parameters({"userName", "password", "firstName", "lastName", "email", "dobDay", "dobMonth", "dobYear"})
	public void validUserShouldBeAbleToChangeAccountInfo(String username, String password, String firstname, String lastname, String email, String day, String month, String year) throws InterruptedException {
		driver = BrowserFactory.init();
		
		LoginPage loginPage = 
				PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.pressLoginButton();
		
		MyAccountPage myAccountPage = 
				PageFactory.initElements(driver, MyAccountPage.class);
		myAccountPage.verifyMyAccountPage();
		myAccountPage.clickMyPersonalInfoButton();
		
		YourPersonalInfoPage yourPersonalInfoPage = 
				PageFactory.initElements(driver, YourPersonalInfoPage.class);
		yourPersonalInfoPage.enterFirstName(firstname);
		yourPersonalInfoPage.enterLastName(lastname);
		yourPersonalInfoPage.enterEmail(email);
		yourPersonalInfoPage.enterDOB(day, month, year);
		Thread.sleep(2000);
		
		BrowserFactory.tearDown();
	}
	
}
