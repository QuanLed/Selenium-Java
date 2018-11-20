package core;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Utils {
	public static String[][] getTableObject(String xlFilePath, String sheetName) {
		
		String[][] tabArray = null;
		int ci, cj;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			tabArray = new String[sheet.getRows() - 1][3];
			ci = 0;

			for (int i = 1; i < sheet.getRows(); i++, ci++) {
				cj = 0;
				for (int j = 0; j < 3; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (tabArray);
	}
	public static By getLocation(String locatorValue, String locatorType, String param) {

		By result;
		switch (locatorType) {
		case "id":
			result = By.id(locatorValue);
			break;
		case "xpath":
			result = By.xpath(locatorValue);
			break;
		case "linkText":
			result = By.linkText(locatorValue);
			break;
		case "className":
			result = By.className(locatorValue);
			break;
		case "cssSelector":
			result = By.cssSelector(locatorValue);
			break;
		case "name":
			result = By.name(locatorValue);
			break;
		case "partialLinkText":
			result = By.partialLinkText(locatorValue);
			break;
		case "tagName":
			result = By.tagName(locatorValue);
			break;
		case "xpath_param":
			result = By.xpath(locatorValue.replace("${param}", param));
			break;
		default:
			result = null;
		}
		return result;
	}
	public static List<HashMap<String,String>> getTestData(String xlFilePath, String sheetName, String tableName) {
		List<HashMap<String,String>> listData = new ArrayList<HashMap<String,String>>();
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int startRow, startCol, endRow, endCol;
			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();

//			info("Loaded data from Excel: Row[" + startRow + ".." + endRow + "], Columns[" + startCol + ".." + endCol + "]");

			
			for(int i = startRow + 1; i < endRow; i++)
			{
				HashMap<String,String> valSet = new HashMap<String,String>();
					for(int j = 1; j < endCol; j++)
					{
						valSet.put(sheet.getCell(j, startRow).getContents(), sheet.getCell(j, i).getContents());
					}
					listData.add(valSet);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (listData);
	}
}
