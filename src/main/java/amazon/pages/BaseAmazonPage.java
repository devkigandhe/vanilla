package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseAmazonPage {

	protected WebDriver driver;
	private final String csHamburgerMenu = "#nav-hamburger-menu > span";

	public BaseAmazonPage(WebDriver driver) {
		this.driver = driver;
	}

	//

	public WebElement getHambergerMenu() {
		return driver.findElement(By.cssSelector(csHamburgerMenu));
	}
	
	
	public WebElement findMenuItem(String menuItemText) {
		
		return driver.findElement(By.linkText(menuItemText));
		
	}
	
	
	
}
