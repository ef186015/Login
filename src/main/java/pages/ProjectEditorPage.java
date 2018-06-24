package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectEditorPage {
	
	private WebDriver driver;
	private String elementsButtonClassName = "icon-elements";
	private String pagesButtonClassName = "icon-pages";
	private String variablesButtonClassName = "icon icon-variables";
	private String addNewPageIconClassName = "icon-add";
	private String changesSuccessfullySavedIconClassName = "icon-success";
	private String labelElementXpath = "//div[@data-test='draggables-ui-kit_ui-label']";
	
	private String pageCanvasCssSelector = "css=div.canvas-element-dnd > div.canvas-element-selectable > div.canvas-element.";
	private String pageCanvasXpath= "//div[@class='canvas-element-dnd']";
	
	private String testButtonXpath = "//button[text()='test']";
	
	public ProjectEditorPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickPagesMenuButton() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement pagesButton = wait.until(ExpectedConditions.elementToBeClickable(By.className(pagesButtonClassName)));
		pagesButton.click();
	}
	
	public void clickElementsMenuButton() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement pagesButton = wait.until(ExpectedConditions.elementToBeClickable(By.className(elementsButtonClassName)));
		pagesButton.click();
	}
	public void clickAddNewPageButton() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement addNewPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.className(addNewPageIconClassName)));
		addNewPageButton.click();
	}
	
	public boolean isSaveSuccessful(int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		if(wait.until(ExpectedConditions.presenceOfElementLocated(By.className(changesSuccessfullySavedIconClassName))) != null) {
			System.out.println("Change Successfully Saved in Editor");
			return true;
		}
		return false;	
	}
	
	public void dragAndDropLabelToCanvas() {
		driver.manage().window().maximize();
		WebElement label = driver.findElement(By.xpath(labelElementXpath));
		Mouse mouse = ((HasInputDevices) driver).getMouse();
		Locatable locatableLabel = (Locatable) driver.findElement(By.xpath(labelElementXpath));
		mouse.mouseDown(locatableLabel.getCoordinates());

		try {
			Robot robot = new Robot();
			robot.mouseMove(label.getLocation().getX(), label.getLocation().getY());
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(500);
			robot.mouseMove(747, 382);
			robot.delay(500);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			System.out.println("Element moved");
			
		} catch (AWTException e) {
			System.out.println("Unable to drag and drop the element.");
			e.printStackTrace();
		}
	}
	

}
