package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.TestBase;

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
	public List<WebElement> getProductName(){
		List<WebElement> resultList = q.driver.findElements(getLocation("TXT_PRODUCTLIST"));
		return resultList;
	}
	public String moveToFacebook(){
		String thucDonTitle = q.driver.getTitle();
		TestBase scrollToEnd = new TestBase();
		scrollToEnd.scrollEndPage();
		FooterPage footer = new FooterPage(null);
		footer.clickFaceBook();
		for(String winHandle : q.driver.getWindowHandles()){
			if(winHandle != thucDonTitle){
				String current = winHandle;
				q.driver.switchTo().window(current);
			}
		}
		String fanPageTitle = q.driver.getTitle();
		return fanPageTitle;
	}
}
