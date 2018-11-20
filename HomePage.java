package pages;

import org.openqa.selenium.WebDriver;


public class HomePage extends Page {
	public HomePage(WebDriver driver){
		super(driver);
		this.repoFile = "E:\\AutoTestLotteria\\repository\\Loteria_Locator.xls";
		this.locationSheet = "HomePage";
		// load object location
		this.initLocationMap();
	}
	public DatHangPage clickDatHang() {
		q.driver.findElement(getLocation ("MENU_DATHANG")).click();
		return new DatHangPage(q.driver);
	}
	public SearchPopupPage clickSearch() {
		q.driver.findElement(getLocation ("ICON_SEARCH")).click();
		return new SearchPopupPage(q.driver);
	}
	
}
