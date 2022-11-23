package amazon.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.typesafe.config.Config;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.pages.AmazonSortOrder;
import amazon.pages.HomePage;
import amazon.pages.ProductInfoPage;
import amazon.pages.ResultsPage;
import amazon.utils.CommonUtils;

public class TestAmazonLabel {

	private static Config config = EnvFactory.getInstance().getConfig();
	private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
	private WebDriver driver = DriverFactory.getDriver();

	private HomePage homePage = new HomePage(driver);
	private ResultsPage resultPage = new ResultsPage(driver);
	private ProductInfoPage productPage = new ProductInfoPage(driver);
	private CommonUtils coUtils = new CommonUtils(driver);
	WebElement element;

	@Tag("smokeTest")
	@DisplayName("This test is to assert a label on the product detail page after navigation.")
	@Test
	void assertLabelIsCorrect() throws InterruptedException {
		//Open amazon.in
		driver.get(HOME_PAGE_URL);
		//Click on Hamburger Menu
		element = homePage.getHambergerMenu();
		coUtils.highlightAndClick(element);
		//Click on TV, Appliances, Electronics Menu Item
		element = homePage.findMenuItem("TV, Appliances, Electronics");
		coUtils.highlightAndClick(element);
		//Click on Televisions sub menu
		element = homePage.findMenuItem("Televisions");
		coUtils.highlightAndClick(element);
		//Apply filter Samsung from the Brands section
		element = resultPage.findMenuItem("Samsung");
		coUtils.highlightAndClick(element);
		//Sort results from Price High to Low
		resultPage.changeSortOrder(AmazonSortOrder.PRICE_H2L);
		//Click on Second Item from results
		resultPage.clickResultItem(2);
		//Switch to the new tab
		coUtils.switchTab(1);
		//Assert the label 
		assertEquals("About this item", productPage.findLable());
		//Close All Tabs
		driver.quit();
	}
}
