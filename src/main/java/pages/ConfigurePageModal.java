package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class ConfigurePageModal {
	
	private String tabBarCheckboxXpath = "//input[@data-reactid='.0.0.0.1.1.$=1$modal-modal.1.1.0.$=1$choosePageType.0.0.$ui-kit_ui-tab-bar-controller.0.0.0' and @type='checkbox']";
	private String navigationBarCheckboxXpath = "//input[@data-reactid='.0.0.0.1.1.$=1$modal-modal.1.1.0.$=1$choosePageType.0.0.$ui-kit_ui-navigation-controller.0.0.0' and @type='checkbox']";
	private String nextButtonXpath = "//button[text()='Next']";
	private String nameYourPageInputFieldId = "input-name";
	private String createPageButtonXpath = "//button[text()='Create']";
	private String dialogBoxClassName = "dialog";

	
	private WebDriver driver;
	
	public ConfigurePageModal(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickTabBarCheckboxOnDialog() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement dialogBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(dialogBoxClassName)));
		WebElement tabBarCheckbox = dialogBox.findElement(By.xpath(tabBarCheckboxXpath));
		tabBarCheckbox.click();
	}
	
	public void clickNavigationBarCheckboxOnDialog() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement dialogBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(dialogBoxClassName)));
		WebElement navigationBarCheckbox = dialogBox.findElement(By.xpath(navigationBarCheckboxXpath));
		navigationBarCheckbox.click();
	}
	public void clickNextButtonOnDialog() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement dialogBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(dialogBoxClassName)));
		WebElement nextButton = dialogBox.findElement(By.xpath(nextButtonXpath));
		nextButton.click();	
	}
	
	public void enterPageNameOnDialog(String pageName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement pageNameInputField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(nameYourPageInputFieldId))));
		pageNameInputField.sendKeys(pageName);	
	}
	
	public void clickCreateButtonOnDialog() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(createPageButtonXpath))));
		createButton.click();
	}
	
}
