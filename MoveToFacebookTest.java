package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MoveToFacebookTest {
	private static WebDriver driver;
	@DataProvider(name="ExpectedTitle")
	public static String[] credentials(){
		return new String[] {"quan","burger"};
	}
	
	@Test(dataProvider="ExpectedTitle")
	public void moveToFacebook(String searchData){
		System.setProperty("webdriver.chrome.driver", "E:\\AutoTestLotteria\\browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.lotteria.vn");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='top']/div/nav/ul/li[9]/a/i")).click();
		driver.findElement(By.xpath("//*[@id='search']/div/div/form/input[1]")).sendKeys(searchData);
		driver.findElement(By.xpath("//*[@id='search']/div/div/form/div/label[2]")).click();
		driver.findElement(By.xpath("//*[@id='search']/div/div/form/input[2]")).click();
	}
}
