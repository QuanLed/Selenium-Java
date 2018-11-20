package tests;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.CompareData;
import core.Utils;
import pages.HomePage;
import pages.SearchPopupPage;
import pages.SearchResultsPage;

public class CaseSearchMsg extends TestCase {
	HashMap<String,String> searchData;
	HashMap<String,String> text01;
	HashMap<String,String> text02;
	HashMap<String,String> text03;
	
	public CaseSearchMsg(){
		this.dataFile = "E:\\AutoTestLotteria\\repository\\Loteria_Data.xls";
		this.dataSheet = "SearchData";
	}
	
	@Test
	public void verifySearchMsg(){
		q.initBrowser();
		String tblDataSearch = "SearchText";
		searchData = Utils.getTestData(this.dataFile, this.dataSheet, tblDataSearch).get(0);
		String tblExpected1 = "Expected1";
		text01 = Utils.getTestData(this.dataFile, this.dataSheet, tblExpected1).get(0);
		String expected1 = text01.get("Text");
		String tblExpected2 = "Expected2";
		text02 = Utils.getTestData(this.dataFile, this.dataSheet, tblExpected2).get(0);
		String expected2 = text02.get("Text");
		String tblExpected3 = "Expected3";
		text03 = Utils.getTestData(this.dataFile, this.dataSheet, tblExpected3).get(0);
		String expected3 = text03.get("Text");
		
		ArrayList<String> expectedSearchMsg = new ArrayList<String>();
		expectedSearchMsg.add(expected1);
		expectedSearchMsg.add(expected2);
		expectedSearchMsg.add(expected3);
		
		HomePage homePage = new HomePage(q.driver);
		SearchPopupPage searchPopupPage = homePage.clickSearch();
		SearchResultsPage searchResultsPage = searchPopupPage.searchText(searchData.get("SearchData"));
		ArrayList<String> actualSearchMsg = searchResultsPage.getSearchMsg();
		
		CompareData ojbExpected = new CompareData();
		ojbExpected.text1 = expectedSearchMsg.get(0);
		ojbExpected.text2 = expectedSearchMsg.get(1);
		ojbExpected.text3 = expectedSearchMsg.get(2);
		
		CompareData objActual = new CompareData();
		objActual.text1 = actualSearchMsg.get(0);
		objActual.text2 = actualSearchMsg.get(1);
		objActual.text3 = actualSearchMsg.get(2);
		
		Assert.assertTrue(EqualsBuilder.reflectionEquals(objActual, ojbExpected));
	}
}
