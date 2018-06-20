package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public String url = "https://sapp.dropsource.biz/login";
	private String emailFieldName = "username";
	private String passwordFieldName = "password";
	private String loginButtonClassName = "loginButton";
	private String emailToolTipErrorMessageXpath = "//DIV[@class='box' and @data-reactid='.0.1.1.1.1.0.1.0']";
	private String passwordToolTipErrorMessageXpath = "//DIV[@class='box' and @data-reactid='.0.1.1.2.1.0.1.0']";
	private String createNewProjectButtonClassName = "sub-header-button";
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goTo() {
		driver.navigate().to(url);
	}
	
	public void enterUsername(String username) {
		WebElement emailTextField = driver.findElement(By.name(emailFieldName));
		emailTextField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		WebElement emailTextField = driver.findElement(By.name(passwordFieldName));
		emailTextField.sendKeys(password);
	}
	
	public String getEmailTooltipErrorText() {
		WebDriverWait wait = new WebDriverWait(driver, 6);
		WebElement tooltipErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailToolTipErrorMessageXpath)));
		return tooltipErrorMessage.getText();
	}
	
	public String getPasswordTooltipErrorText() {
		WebDriverWait wait = new WebDriverWait(driver, 6);
		WebElement tooltipErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passwordToolTipErrorMessageXpath)));
		return tooltipErrorMessage.getText();
	}
	
	public void leavePasswordFieldBlank() {
		WebElement passwordTextField = driver.findElement(By.name(passwordFieldName));
		passwordTextField.sendKeys("P");
		passwordTextField.sendKeys("\b");
	}
	
	public void leaveEmailFieldBlank() {
		WebElement emailTextField = driver.findElement(By.name(emailFieldName));
		emailTextField.sendKeys("c");
		emailTextField.sendKeys("\b");
	}
	
	public void clickLoginButton() {
		WebElement loginButton = driver.findElement(By.className(loginButtonClassName));
		loginButton.click();	
	}
	
	public void clearEmailTextField() {
		WebElement emailTextField = driver.findElement(By.name(emailFieldName));
		emailTextField.clear();
	}
	
	public void clearPasswordTextField() {
		WebElement passwordTextField = driver.findElement(By.name(passwordFieldName));
		passwordTextField.clear();
	}
	
	public ProjectDashboardPage getProjectDashboardPage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//WebElement buttonTag = driver.findElement(By.tagName("button"));
		WebElement createNewProjectButton = driver.findElement(By.className("common.primary.right.sub-header-button"));
		wait.until(ExpectedConditions.elementToBeClickable(createNewProjectButton));
		return new ProjectDashboardPage(driver);
	}
}
