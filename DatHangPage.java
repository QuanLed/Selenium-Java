package pages;

import org.openqa.selenium.WebDriver;

public class DatHangPage extends Page {
	public DatHangPage(WebDriver driver) {
		super(driver);
		this.repoFile = "E:\\AutoTestLotteria\\repository\\Loteria_Locator.xls";
		this.locationSheet = "DatHangPage";
		// load object location
		this.initLocationMap();
	}
	public String getNoOrderMsg() {
		String actualResult = q.driver.findElement(getLocation("TXT_RESULTTEXT")).getText();
		return actualResult;
	}
}
