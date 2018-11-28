package tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.CompareData;
import core.Utils;
import pages.HomePage;
import pages.SearchPopupPage;
import pages.SearchResultsPage;

public class SearchTest extends TestCase {
	
	public SearchTest(){
		this.dataFile = "E:\\AutoTestLotteria\\repository\\Loteria_Data.xls";
		this.dataSheet = "SearchTest";
	}
	
	public ArrayList<String> textSearch(){
	
		String tblDataSearch = "SearchText";
		HashMap<String,String> searchData = Utils.getTestData(this.dataFile, this.dataSheet, tblDataSearch).get(0);
		String searchText1 = searchData.get("SearchData");
		HashMap<String,String> searchProduct = Utils.getTestData(this.dataFile, this.dataSheet, tblDataSearch).get(1);
		String searchText2 = searchProduct.get("SearchData");
	
		ArrayList<String> dataSearch = new ArrayList<String>();
		dataSearch.add(searchText1);
		dataSearch.add(searchText2);
		
		return dataSearch;
	}
	public ArrayList<String> eSearchMsg(){
		
		String tblExpected1 = "Expected1";
		HashMap<String,String> text01 = Utils.getTestData(this.dataFile, this.dataSheet, tblExpected1).get(0);
		String expected1 = text01.get("Text");
		HashMap<String,String> text02 = Utils.getTestData(this.dataFile, this.dataSheet, tblExpected1).get(1);
		String expected2 = text02.get("Text");
		HashMap<String,String> text03 = Utils.getTestData(this.dataFile, this.dataSheet, tblExpected1).get(2);
		String expected3 = text03.get("Text");
		
		ArrayList<String> expectedSearchMsg = new ArrayList<String>();
		expectedSearchMsg.add(expected1);
		expectedSearchMsg.add(expected2);
		expectedSearchMsg.add(expected3);
		return expectedSearchMsg;
	}
	
	@BeforeTest
	public void openBrowser(){
		super.openBrowser();
	}
	
	@AfterTest
	public void closeBrowser(){
		super.closeBrowser();
	}
	
	@Test
	public void checkSearchNews(){
		
		HomePage homePage = new HomePage(q.driver);
		SearchPopupPage searchPopupPage = homePage.clickSearch();
		SearchResultsPage searchResultsPage = searchPopupPage.searchTextNoResult(this.textSearch().get(0));
		ArrayList<String> actualSearchMsg = searchResultsPage.getSearchMsg();
		
		CompareData ojbExpected = new CompareData();
		ojbExpected.text1 = this.eSearchMsg().get(0);
		ojbExpected.text2 = this.eSearchMsg().get(1);
		ojbExpected.text3 = this.eSearchMsg().get(2);
		
		CompareData objActual = new CompareData();
		objActual.text1 = actualSearchMsg.get(0);
		objActual.text2 = actualSearchMsg.get(1);
		objActual.text3 = actualSearchMsg.get(2);
		
		Assert.assertTrue(EqualsBuilder.reflectionEquals(objActual, ojbExpected));
	}
	
	@Test
	public void checkSearchProduct(){

		HomePage homePage = new HomePage(q.driver);
		SearchPopupPage searchPopupPage = homePage.clickSearch();
		SearchResultsPage searchResultsPage = searchPopupPage.searchProduct(this.textSearch().get(1));
		List<WebElement> resultList = searchResultsPage.getProductName();
		
		boolean resultProductName = true;
		for (WebElement result:resultList){
			if (!result.getText().contains(this.textSearch().get(1).toUpperCase())){
				resultProductName = false;
			}
		}
		assertTrue(resultProductName);
	}
	
	@Test
	public void checkSearchProductNoResult(){
		HomePage homePage = new HomePage(q.driver);
		SearchPopupPage searchPopupPage = homePage.clickSearch();
		SearchResultsPage searchResultsPage = searchPopupPage.searchProductNoResult(this.textSearch().get(0));
		ArrayList<String> actualSearchMsg = searchResultsPage.getSearchMsg();

		CompareData ojbExpected = new CompareData();
		ojbExpected.text1 = this.eSearchMsg().get(0);
		ojbExpected.text2 = this.eSearchMsg().get(1);
		ojbExpected.text3 = this.eSearchMsg().get(2);
		
		CompareData objActual = new CompareData();
		objActual.text1 = actualSearchMsg.get(0);
		objActual.text2 = actualSearchMsg.get(1);
		objActual.text3 = actualSearchMsg.get(2);
		
		Assert.assertTrue(EqualsBuilder.reflectionEquals(objActual, ojbExpected));
	}
}
