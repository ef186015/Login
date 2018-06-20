package pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectDashboardPage {
	
	public String url = "https://sapp.dropsource.biz/dashboard/projects";
	private String createNewProjectButtonClassName = "sub-header-button";
	private String iosPlatformIconClassName = "icon-ios";
	private String androidPlatformIconClassName = "icon-android";
	private String projectNameInputFieldID = "input-name";
	private String inputValidationFieldErrorsClassName = "inputValidationErrors";
	
	private WebDriver driver;
	
	public ProjectDashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goTo() {
		driver.navigate().to(url);
	}

	public void clickCreateNewProjectButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//Used Css instead of text because this button will have different text depending on the existence of projects
		WebElement createProjectButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.common.primary.right.sub-header-button")));
		createProjectButton.click();	
	}
	
	public void clickIOSPlatformIconOnDialog() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement dialogBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dialog")));
		WebElement iOSPlatformIcon = dialogBox.findElement(By.className(iosPlatformIconClassName));
		iOSPlatformIcon.click();
	}
	
	public void clickNextButtonOnDialog() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement nextButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Next']")));
		nextButton.click();	
	}
	
	public void clickStartFreeTrialButtonOnDialog() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement startTrialButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Start 30-day free trial']")));
		startTrialButton.click();	
	}
	
	public void enterProjectNameOnDialog(String projectName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement projectNameInputField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(projectNameInputFieldID))));
		projectNameInputField.sendKeys(projectName);		
	}
	
	public void clickCreateButtonOnDialog() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Create']"))));
		createButton.click();
		if(isProjectCreationSuccessful()) {
			System.out.println("Project Created Successfully");
		} else {
			System.out.println("There was a problem creating the project");
		}
	}
	
	private boolean isProjectCreationSuccessful() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		if(wait.until(ExpectedConditions.presenceOfElementLocated(By.className("toast-success-notification"))) != null) {
			return true;
		}
		return false;	
	}
	
	public void openEditorForMyProject(String projectName) throws InterruptedException {
		List<WebElement> projectRows = driver.findElements(By.className("table-content-row"));
		for (WebElement rows : projectRows) {
			if(rows.getAttribute("data-test").equals("project-" + projectName)) {
				rows.findElement(By.className("open-button")).click();
				Thread.sleep(10000);
			} else {
				System.out.println("Unable to find your project in the dashboard listing");
			}
		}	
	}
	
}
