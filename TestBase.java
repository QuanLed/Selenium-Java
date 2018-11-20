package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public WebDriver driver;
	public void initBrowser(){
		System.setProperty("webdriver.chrome.driver", "E:\\AutoTestLotteria\\browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.lotteria.vn/");
		driver.manage().window().maximize();
	}
	public void scrollEndPage(){
		JavascriptExecutor end = (JavascriptExecutor) driver;
		end.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}
