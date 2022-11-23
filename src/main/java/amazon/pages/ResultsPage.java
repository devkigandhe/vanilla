package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import amazon.utils.CommonUtils;

public class ResultsPage extends BaseAmazonPage {

	public ResultsPage(WebDriver driver) {
		super(driver);

	}

	CommonUtils coUtils = new CommonUtils(driver);

	public WebElement SelectBrand(String brandName)

	{
		return driver.findElement(By.linkText(brandName));
	}

	public void changeSortOrder(AmazonSortOrder option) throws InterruptedException {
		WebElement element = coUtils.fluentWait(By.id("a-autoid-0-announce"));
		coUtils.highlightAndClick(element);

		switch (option) {
		case PRICE_H2L:
			element = coUtils.fluentWait(By.id("s-result-sort-select_2"));
			coUtils.highlightAndClick(element);

			break;
		case AVG_REVIEW:
		case FEATURE:
		case NEWEST:
		case PRICE_L2H:
		default:
			throw new InvalidArgumentException("Capability not implemented yet");
		}

	}

	public void clickResultItem(int dataIndex) throws InterruptedException {

		WebElement element = coUtils.fluentWait(By.cssSelector("div[data-index=\"" + dataIndex + "\"]"));
		coUtils.highlightAndClick(element);

	}

}
