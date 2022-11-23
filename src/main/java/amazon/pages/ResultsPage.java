package amazon.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage extends BaseAmazonPage {

	public ResultsPage(WebDriver driver) {
		super(driver);

	}

	public WebElement SelectBrand(String brandName)

	{
		return driver.findElement(By.linkText(brandName));
	}
	
	public void changeSortOrder(AmazonSortOrder option) throws InterruptedException
	{
		driver.findElement(By.id("a-autoid-0-announce")).click();
		
		
		switch(option) 
		{
		case PRICE_H2L :  driver.findElement(By.id("s-result-sort-select_2")).click();
						  Thread.sleep(2000);
						 	break;
		
		
		
		}
		
	}
	
	public void selectSecondResultItem() throws InterruptedException
	{
		
		
		WebElement element = driver.findElement(By.cssSelector("div[data-index=\"2\"]"));
			element.click();
			Thread.sleep(2000);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			Thread.sleep(2000);
	}
	
	
}
