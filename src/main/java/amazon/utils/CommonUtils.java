package amazon.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class CommonUtils {

	WebDriver driver;

	public CommonUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void highlightAndClick(WebElement element) throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);

		element.click();

	}

	public WebElement fluentWait(By by) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
		return element;

	}

	public void switchTab(int tabIndex) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabIndex));
	}
}
