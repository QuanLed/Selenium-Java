package pages;

import org.openqa.selenium.WebDriver;

public class SearchPopupPage extends Page {
	public SearchPopupPage(WebDriver driver) {
		super(driver);
		this.repoFile = "E:\\AutoTestLotteria\\repository\\Loteria_Locator.xls";
		this.locationSheet = "SearchPopupPage";
		// load object location
		this.initLocationMap();
	}
	public SearchResultsPage searchTextNoResult(String searchData) {
		q.driver.findElement(getLocation("TXT_SEARCHTEXT")).sendKeys(searchData);
		q.driver.findElement(getLocation("BTN_TINTUC")).click();
		q.driver.findElement(getLocation("BTN_SEARCH")).click();
		return new SearchResultsPage(q.driver);
	}
	public SearchResultsPage searchProduct(String searchProduct) {
		q.driver.findElement(getLocation("TXT_SEARCHTEXT")).sendKeys(searchProduct);
		q.driver.findElement(getLocation("BTN_SANPHAM")).click();
		q.driver.findElement(getLocation("BTN_SEARCH")).click();
		return new SearchResultsPage(q.driver);
	}
	public SearchResultsPage searchProductNoResult(String searchData) {
		q.driver.findElement(getLocation("TXT_SEARCHTEXT")).sendKeys(searchData);
		q.driver.findElement(getLocation("BTN_SANPHAM")).click();
		q.driver.findElement(getLocation("BTN_SEARCH")).click();
		return new SearchResultsPage(q.driver);
	}
}
