package BasicProjectCreation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProjectDashboardPage;

public class CreatePhotoApp {
	
	String email = "eflannagan+premium@dropsource.com";
	String password = "Zerbert2";
	
	private WebDriver driver;
	private ProjectDashboardPage projectDashboardPage;
	
	  @BeforeTest
	  public void LoginAsUser() throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		 this.driver = new ChromeDriver();
		 LoginPage loginPage = new LoginPage(driver);
		 loginPage.goTo();
		 loginPage.enterUsername(email);
		 loginPage.enterPassword(password);
		 loginPage.clickLoginButton();
		 ProjectDashboardPage newPage = new ProjectDashboardPage(driver);
		 this.projectDashboardPage = newPage;
	  }
	  
	  @Test(description="Verify that a basic project can be created")
	  public void testPhotosApp() {		
		projectDashboardPage.clickCreateNewProjectButtonOnSelectPlatformModal();
		projectDashboardPage.clickIOSPlatformIconOnSelectPlatformModal();
		projectDashboardPage.clickNextButtonOnPlatformModal();		
		}

	  @AfterTest
	  public void closeBrowser() {
		  this.driver.close();
	  }
}
