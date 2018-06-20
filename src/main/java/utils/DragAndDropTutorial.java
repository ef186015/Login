package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTutorial {
	
	WebDriver driver;
	
	public void setUp() {
		
	}

	public void dragAndDrop() {
		//may need to switch to iFrame if Editor is in one
		Actions action = new Actions(driver);
		//action.dragAndDropBy(source, xOffset, yOffset)
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
