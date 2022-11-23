package amazon.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.typesafe.config.Config;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.pages.AmazonSortOrder;
import amazon.pages.HomePage;
import amazon.pages.ProductInfoPage;
import amazon.pages.ResultsPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestCase1 {

	private static Config config = EnvFactory.getInstance().getConfig();
	private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
	private WebDriver driver = DriverFactory.getDriver();

	private HomePage homePage = new HomePage(driver);
	private ResultsPage resultPage = new ResultsPage(driver);
	private ProductInfoPage productPage = new ProductInfoPage(driver);
	@Tag("smokeTest")
	@DisplayName("This test is for demo purpose only to open Amazon.in and click on the hamburger menu.")
	@Test
	void assertLabelIsCorrect() throws InterruptedException {
		driver.get(HOME_PAGE_URL);
		// assertEquals("Amazon.com. Spend less. Smile more.", driver.getTitle());
		homePage.getHambergerMenu().click();
		Thread.sleep(1000);
		homePage.findMenuItem("TV, Appliances, Electronics").click();
		Thread.sleep(2000);
		homePage.findMenuItem("Televisions").click();
		Thread.sleep(2000);
		resultPage.findMenuItem("Samsung").click();
		Thread.sleep(4000);
		resultPage.changeSortOrder(AmazonSortOrder.PRICE_H2L);
		resultPage.selectSecondResultItem();
		assertEquals("About this item",productPage.findLable());
		driver.quit();
	}
}
