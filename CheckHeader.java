package tests;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.CompareData;
import core.Utils;
import pages.HeaderPage;

public class CheckHeader extends TestCase {
	
	HashMap<String,String> header01;
	HashMap<String,String> header02;
	HashMap<String,String> header03;
	HashMap<String,String> header04;
	HashMap<String,String> header05;
	HashMap<String,String> header06;
	HashMap<String,String> header07;
	HashMap<String,String> header08;
	HashMap<String,String> header09;
	HashMap<String,String> header10;
	
	public CheckHeader(){
		this.dataFile = "E:\\AutoTestLotteria\\repository\\Loteria_Data.xls";
		this.dataSheet = "Header";
	}
	
	@Test
	public void checkHeader(){
		q.initBrowser();
		String tblHeader = "MenuHeader";
		header01 = Utils.getTestData(this.dataFile, this.dataSheet, tblHeader).get(0);
		String menuHeader1 = header01.get("Text");
		header02 = Utils.getTestData(this.dataFile, this.dataSheet, tblHeader).get(1);
		String menuHeader2 = header02.get("Text");
		header03 = Utils.getTestData(this.dataFile, this.dataSheet, tblHeader).get(2);
		String menuHeader3 = header03.get("Text");
		header04 = Utils.getTestData(this.dataFile, this.dataSheet, tblHeader).get(3);
		String menuHeader4 = header04.get("Text");
		header05 = Utils.getTestData(this.dataFile, this.dataSheet, tblHeader).get(4);
		String menuHeader5 = header05.get("Text");
		header06 = Utils.getTestData(this.dataFile, this.dataSheet, tblHeader).get(5);
		String menuHeader6 = header06.get("Text");
		header07 = Utils.getTestData(this.dataFile, this.dataSheet, tblHeader).get(6);
		String menuHeader7 = header07.get("Text");
		header08 = Utils.getTestData(this.dataFile, this.dataSheet, tblHeader).get(7);
		String menuHeader8 = header08.get("Text");
		header09 = Utils.getTestData(this.dataFile, this.dataSheet, tblHeader).get(8);
		String menuHeader9 = header09.get("Text");
		header10 = Utils.getTestData(this.dataFile, this.dataSheet, tblHeader).get(9);
		String menuHeader10 = header10.get("Text");
		
		CompareData eHeader = new CompareData();
		eHeader.text1 = menuHeader1;
		eHeader.text2 = menuHeader2;
		eHeader.text3 = menuHeader3;
		eHeader.text4 = menuHeader4;
		eHeader.text5 = menuHeader5;
		eHeader.text6 = menuHeader6;
		eHeader.text7 = menuHeader7;
		eHeader.text8 = menuHeader8;
		eHeader.text9 = menuHeader9;
		eHeader.text10 = menuHeader10;
		
		HeaderPage header = new HeaderPage(q.driver);
		ArrayList<String> menuHeader = header.checkHeader();
//		In ra ArrayList
//		System.out.println(menuHeader);
		
		CompareData aHeader = new CompareData();
		aHeader.text1 = menuHeader.get(0);
		aHeader.text2 = menuHeader.get(1);
		aHeader.text3 = menuHeader.get(2);
		aHeader.text4 = menuHeader.get(3);
		aHeader.text5 = menuHeader.get(4);
		aHeader.text6 = menuHeader.get(5);
		aHeader.text7 = menuHeader.get(6);
		aHeader.text8 = menuHeader.get(7);
		aHeader.text9 = menuHeader.get(8);
		aHeader.text10 = menuHeader.get(9);
		
//		In ra cac gia tri trong Object 
//		System.out.println(eHeader.toString());
		
		Assert.assertTrue(EqualsBuilder.reflectionEquals(aHeader, eHeader));
	}
}
