package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import amazon.utils.CommonUtils;

public class ProductInfoPage extends BaseAmazonPage {

	public ProductInfoPage(WebDriver driver) {
		super(driver);

	}

	CommonUtils cu = new CommonUtils(driver);

	public String findLable() throws InterruptedException {
		WebElement element = cu.fluentWait(By.cssSelector("h1[class=\"a-size-base-plus a-text-bold\"]"));
		cu.highlightAndClick(element);
		Thread.sleep(1000);
		String label = element.getText();
		// System.out.println("Label:",label);
		return label;
	}

}
