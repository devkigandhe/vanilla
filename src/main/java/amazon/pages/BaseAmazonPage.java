package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import amazon.utils.CommonUtils;

public class BaseAmazonPage {

	protected WebDriver driver;
	private final String csHamburgerMenu = "#nav-hamburger-menu > span";
	protected CommonUtils cu;

	public BaseAmazonPage(WebDriver driver) {
		this.driver = driver;
		this.cu = new CommonUtils(driver);
	}

	//

	public WebElement getHambergerMenu() {
		return cu.fluentWait(By.cssSelector(csHamburgerMenu));
	}

	public WebElement findMenuItem(String menuItemText) {

		return cu.fluentWait(By.linkText(menuItemText));

	}

}
