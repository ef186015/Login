import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.LoginPageErrorMessages;
import utils.TestUtils;

import static org.testng.Assert.assertEquals;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginPageErrorMessages {
	
private WebDriver driver;
	
  @BeforeTest
  public void getChromeDriver() {
	  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	 this.driver = new ChromeDriver();
  }
  
  @Test(description="Verify that the when a user enters an email in an invalid format the correct UI validation error is displayed.")
  public void testInvalidEmailAddressErrorMessage() {		
	LoginPage loginPage = new LoginPage(driver);
	loginPage.goTo();
	for(String email: TestUtils.InvalidEmailsArray) {
		loginPage.enterUsername(email);	
		assertEquals(loginPage.getEmailTooltipErrorText(), LoginPageErrorMessages.notValidEmailErrorText);
		loginPage.clearEmailTextField();
		}
	}
  
  @Test(description="Verify that when a user leaves the password field blank prior to or upon attempting login the correct UI validation error is displayed.")
  public void testPasswordFieldBlankErrorMessage() {
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.goTo();
	  //Use Case: User enters text then deletes text in the password field
	  loginPage.leavePasswordFieldBlank();
	  assertEquals(loginPage.getPasswordTooltipErrorText(), LoginPageErrorMessages.passwordFieldBlankErrorText);
	  //Use Case: User clicks login without entering any credentials
	  driver.navigate().refresh();
	  loginPage.clickLoginButton();
	  assertEquals(loginPage.getPasswordTooltipErrorText(), LoginPageErrorMessages.passwordFieldBlankErrorText);
  }
  
  @Test(description="Verify that when a user leaves the email field blank prior to or upon attempting login the correct UI validation error is displayed.")
  public void testEmailFieldBlankErrorMessage() {
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.goTo();
	//Use Case: User enters text then deletes text in the email field
	  loginPage.leaveEmailFieldBlank();
	  assertEquals(loginPage.getEmailTooltipErrorText(), LoginPageErrorMessages.emailFieldBlankErrorText);	
	//Use Case: User clicks login without entering any credentials
	  driver.navigate().refresh();
	  loginPage.clickLoginButton();
	  assertEquals(loginPage.getEmailTooltipErrorText(), LoginPageErrorMessages.emailFieldBlankErrorText);	
  }
  
  @Test(description="Verify that when a user enters an email address not associated with a DropSource account the correct UI validation error is displayed.")
  public void testEmailDoesNotExistErrorMessage() {
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.goTo();
	  loginPage.enterUsername("noaccount" + RandomStringUtils.randomNumeric(3) + "@email.com");
	  loginPage.enterPassword("P@$$word12345");
	  loginPage.clickLoginButton();
	  assertEquals(loginPage.getEmailTooltipErrorText(), LoginPageErrorMessages.emailDoesNotExistErrorText); 
  }
  
  @Test(description="Verify that when a user enters a password that does not meet requirements the correct UI validation error is displayed.")
  public void testPasswordDoesNotMeetRequirementsErrorMessage() {
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.goTo();
	  for(String password: TestUtils.InvalidPasswordsArray) {
		  loginPage.enterPassword(password);
		  assertEquals(loginPage.getPasswordTooltipErrorText(), LoginPageErrorMessages.passwordRequirementErrorText);
		  loginPage.clearPasswordTextField();
	  }  
  }
  
  @AfterTest
  public void closeBrowser() {
	  this.driver.close();
  }
  
}
