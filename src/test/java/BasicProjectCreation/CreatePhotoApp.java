package BasicProjectCreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProjectDashboardPage;

public class CreatePhotoApp {
	
	String email = "dropsourceqa.automation+staging@gmail.com";
	String password = "P@$$word123";
	
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
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.titleIs("Dashboard - Dropsource"));
		 ProjectDashboardPage newPage = new ProjectDashboardPage(driver);
		 this.projectDashboardPage = newPage;
	  }
	  
	  @Test(description="Verify that a basic project can be created")
	  public void testPhotosApp() throws InterruptedException {		
		String myProjectName = "AutoProjIOSPhotoApp1234";  
		projectDashboardPage.clickCreateNewProjectButton();
		projectDashboardPage.clickIOSPlatformIconOnDialog();
		projectDashboardPage.clickNextButtonOnDialog();	
		projectDashboardPage.clickNextButtonOnDialog();	
		projectDashboardPage.enterProjectNameOnDialog(myProjectName);
		projectDashboardPage.clickCreateButtonOnDialog();
		projectDashboardPage.openEditorForMyProject(myProjectName);
		}

	  @AfterTest
	  public void closeBrowser() {
		  this.driver.close();
	  }
}
