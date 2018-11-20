package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends Page {
	public SearchResultsPage(WebDriver driver){
		super(driver);
		this.repoFile = "E:\\AutoTestLotteria\\repository\\Loteria_Locator.xls";
		this.locationSheet = "SearchResultsPage";
		this.initLocationMap();
	}
	public ArrayList<String> getSearchMsg(){
		String msg1 = q.driver.findElement(getLocation("TXT_ROW1")).getText();
		String msg2 = q.driver.findElement(getLocation("TXT_ROW2")).getText();
		String msg3 = q.driver.findElement(getLocation("TXT_ROW3")).getText();
		ArrayList<String> textMsg = new ArrayList<String>();
		textMsg.add(msg1);
		textMsg.add(msg2);
		textMsg.add(msg3);
		return textMsg;
	}
}
