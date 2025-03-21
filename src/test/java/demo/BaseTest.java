package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import demo.WebUI;

public class BaseTest {

	public WebDriver driver;
	public By by;

	@BeforeMethod
	public void createBrowser() throws Exception {
		System.out.println("Start Chrome browser from BaseTest...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Chờ đợi trang load xong (trong 40s)
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		// Gọi lại hàm startRecord
	}

	@AfterMethod
	public void closeBrowser() throws Exception {
		WebUI.sleep(2);
		System.out.println("Close browser from BaseTest...");
		driver.quit();
	}

}
