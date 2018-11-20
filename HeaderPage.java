package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class HeaderPage extends Page {

	public HeaderPage(WebDriver driver){
		super(driver);
		this.repoFile = "E:\\AutoTestLotteria\\repository\\Loteria_Locator.xls";
		this.locationSheet = "Header";
		this.initLocationMap();
	}
	
	public ArrayList<String> checkHeader(){
		ArrayList<String> menuHeader = new ArrayList<String>();
		menuHeader.add(q.driver.findElement(getLocation("ICON_HOME")).getCssValue("background-image"));
		menuHeader.add(q.driver.findElement(getLocation("MENU_THUCDON")).getText());
		menuHeader.add(q.driver.findElement(getLocation("MENU_DATHANG")).getText());
		menuHeader.add(q.driver.findElement(getLocation("MENU_KHUYENMAI")).getText());
		menuHeader.add(q.driver.findElement(getLocation("ICON_LOTTERIA")).getAttribute("src"));
		menuHeader.add(q.driver.findElement(getLocation("MENU_STORE")).getText());
		menuHeader.add(q.driver.findElement(getLocation("MENU_FRANCHISING")).getText());
		menuHeader.add(q.driver.findElement(getLocation("ICON_SEARCH")).getCssValue("background-image"));
		menuHeader.add(q.driver.findElement(getLocation("ICON_CART")).getCssValue("background-image"));
		menuHeader.add(q.driver.findElement(getLocation("ICON_LANGUAGE")).getText());
		
		return menuHeader;
		
	}
	
//	public String encodeUtf8(String inputString) throws Exception{
//		byte[] strbytes = inputString.getBytes("UTF-8"); 
//		return new String(strbytes, "UTF-8"); 
//	}
}
