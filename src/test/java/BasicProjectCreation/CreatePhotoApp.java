package BasicProjectCreation;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ConfigurePageModal;
import pages.LoginPage;
import pages.ProjectDashboardPage;
import pages.ProjectEditorPage;

public class CreatePhotoApp {
	
	private String email = "dropsourceqa.automation+staging@gmail.com";
	private String password = "P@$$word123";
	
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
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.titleIs("Dashboard - Dropsource"));
		 ProjectDashboardPage newPage = new ProjectDashboardPage(driver);
		 this.projectDashboardPage = newPage;
	  }
	  
	  @Test(description="Verify that a basic project can be created")
	  public void testSimpleAppCreation() throws InterruptedException {		
		String myProjectName = "AutoProjIOSPhotoApp" + System.currentTimeMillis();  
		String firstPageName = "Page 1";
		//Make this a method -> create new project: iOS or Android parameter passed
		projectDashboardPage.clickCreateNewProjectButton();
		projectDashboardPage.clickIOSPlatformIconOnDialog();
		projectDashboardPage.clickNextButtonOnDialog();	
		projectDashboardPage.clickNextButtonOnDialog();	
		projectDashboardPage.enterProjectNameOnDialog(myProjectName);
		projectDashboardPage.clickCreateButtonOnDialog();
		
		//Make this a method -> Open Project Editor: project Name passed
		Thread.sleep(5000);
		projectDashboardPage.openEditorForMyProject(myProjectName);
		//need a better solution for thread.sleep
		Thread.sleep(10000);
		ArrayList<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleIs("Editor - Dropsource"));
		ProjectEditorPage projectEditorPage = new ProjectEditorPage(driver);
		
		//Make this a method -> Add Page: parameter project type?  navigation type?
		projectEditorPage.clickPagesMenuButton();
		Thread.sleep(1000);
		projectEditorPage.clickAddNewPageButton();
		//Thread.sleep(1000);
		ConfigurePageModal configurePageModal = new ConfigurePageModal(driver);
		configurePageModal.clickNavigationBarCheckboxOnDialog();
		configurePageModal.clickNextButtonOnDialog();
		configurePageModal.enterPageNameOnDialog(firstPageName);
		configurePageModal.clickCreateButtonOnDialog();
		Thread.sleep(5000);
		
		//Make this a method -> Add Element to Page (will add to an arbitrary spot and will need constraints)
		projectEditorPage.clickElementsMenuButton();
		Thread.sleep(1000);
		projectEditorPage.dragAndDropLabelToCanvas();
		Thread.sleep(5000);
		}

	  @AfterTest
	  public void closeBrowser() {
		  ArrayList<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		  this.driver.close();
		  this.driver.switchTo().window(browserTabs.get(0));
		  this.driver.close();
	  }
}
