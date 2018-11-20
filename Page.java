package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.TestBase;
import core.Utils;

public class Page {
	protected TestBase q;
	protected HashMap<String,By> locationMap;
	protected String repoFile;
	protected String locationSheet;
	// initialize selenium action base
	public Page(){
		q = new TestBase();
	}
	/**
	 * Call constructor if page use internal action
	 * */
	public Page(WebDriver driver){
		this();
		q.driver = driver;
	}
	/**
	 * Load objects location from file into a dictionary of 
	 * <String, By> object
	 * */
	protected void initLocationMap(){
		this.locationMap = new HashMap<String, By>();
		String[][] repoObjects = Utils.getTableObject(this.repoFile, this.locationSheet);
		String strLocationName = null;
		for (int i = 0; i < repoObjects.length; i++) {
			strLocationName = repoObjects[i][0];
			if(!strLocationName.isEmpty()){
				this.locationMap.put(strLocationName,
					 Utils.getLocation(repoObjects[i][1], repoObjects[i][2], ""));
			}
		}
	}	
	/**
	 * Get location of object by its name
	 * */
	public By getLocation(String locationName){
		return this.locationMap.get(locationName);
	}
}
