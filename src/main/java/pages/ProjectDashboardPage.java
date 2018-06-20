package pages;

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
	
	private WebDriver driver;
	
	public ProjectDashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goTo() {
		driver.navigate().to(url);
	}

	public void clickCreateNewProjectButtonOnSelectPlatformModal() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement createNewProjectButton = driver.findElement(By.cssSelector("button.common.primary.rught.sub-header-button"));
		wait.until(ExpectedConditions.elementToBeClickable(createNewProjectButton));
		createNewProjectButton.click();	
	}
	
	public void clickIOSPlatformIconOnSelectPlatformModal() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.className(iosPlatformIconClassName)));
		WebElement iOSPlatformIcon = driver.findElement(By.className(iosPlatformIconClassName));
		iOSPlatformIcon.click();
	}
	
	public void clickNextButtonOnPlatformModal() {
		WebElement buttonTag = driver.findElement(By.tagName("button"));
		buttonTag.findElement(By.name("Next")).click();		
	}
	
}
