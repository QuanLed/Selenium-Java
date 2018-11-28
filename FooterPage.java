package pages;

import org.openqa.selenium.WebDriver;

public class FooterPage extends Page {
	
	public FooterPage (WebDriver driver){
		super(driver);
		this.repoFile = "E:\\AutoTestLotteria\\repository\\Loteria_Locator.xls";
		this.locationSheet = "Footer";
		this.initLocationMap();
	}
	
	public void clickFaceBook(){
		q.driver.findElement(getLocation("ICON_FACEBOOK")).click();
	}
}
