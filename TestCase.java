package tests;

import org.openqa.selenium.WebDriver;

import core.TestBase;

public class TestCase {
	protected TestBase q;
	protected String dataFile;
	protected String dataSheet;
	public TestCase(){
		q = new TestBase();
	}
	public TestCase(WebDriver driver){
		this();
		q.driver = driver;
	}
	public void openBrowser(){
		q.initBrowser();
	}
	public void closeBrowser(){
		q.driver.close();
	}
}
