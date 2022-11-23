package amazon.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ProductInfoPage extends BaseAmazonPage{

	public ProductInfoPage(WebDriver driver) {
		super(driver);
		
	}

	
	public String findLable()
	{
		String label =  driver.findElement(By.cssSelector("h1[class=\"a-size-base-plus a-text-bold\"]")).getText();
		//System.out.println("Label:",label);
		return label;
	}	
	



}
