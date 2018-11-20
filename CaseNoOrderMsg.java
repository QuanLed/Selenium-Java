package tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

import core.Utils;
import pages.DatHangPage;
import pages.HomePage;

public class CaseNoOrderMsg extends TestCase {
	HashMap<String,String> text01;
	
	public CaseNoOrderMsg(){
		this.dataFile = "E:\\AutoTestLotteria\\repository\\Loteria_Data.xls";
		this.dataSheet = "NoOrder";
	}
	
	@Test
	public void checkNoOrder(){
		q.initBrowser();
		String tblExpected4 = "Expected1";
		text01 = Utils.getTestData(this.dataFile, this.dataSheet, tblExpected4).get(0);
		String expectedMsg = text01.get("Text");
		
		HomePage homePage = new HomePage(q.driver);
		DatHangPage datHangPage = homePage.clickDatHang();
		String actualMsg = datHangPage.getNoOrderMsg();
		
		assertEquals(actualMsg, expectedMsg);
	}
}
