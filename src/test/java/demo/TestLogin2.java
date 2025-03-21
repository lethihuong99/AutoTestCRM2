package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class TestLogin2 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		// Khởi tạo WebDriver và WebDriverWait
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://crm.ommani.vn/");
		driver.findElement(By.xpath("//div[@class='content-signup__btn']/a")).click();

	}

	@AfterMethod
	public void tearDown() {
		// Đóng trình duyệt sau mỗi test case
		driver.quit();
	}

	// Hàm kiểm tra sự hiện diện của phần tử
	public boolean isElementDisplayed(By by) {
         try {
             WebElement element = driver.findElement(by);
             return element.isDisplayed();
         } catch (NoSuchElementException e) {
             return false;
         }
	}
	
	@Test
	public void testSuccess() {
		// Nhập tên đăng nhập đúng
		WebElement username = driver
				.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='input-group']/input"));
		username.clear();
		username.sendKeys("0923452345");

		// Nhập mật khẩu sai
		WebElement password = driver
				.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='form-group'][2]//input"));
		password.clear();
		password.sendKeys("12341234");

		// Click nút Login
		WebElement loginButton = driver.findElement(By.xpath("//div[@class='form_login bg-white']//button"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		boolean isElementPresent = isElementDisplayed(By.xpath("//*[@id='root']/div[1]/div/div[2]/div[1]/span[1]"));
		Assert.assertTrue(isElementPresent, "sai");

	}
	@DataProvider(name = "WrongPassWord")
	public Object[][] WrongPassWord() {
		return new Object[][] { 
			{ "0923452345", " 12345$ " },
			};
	}

	 @Test(dataProvider = "WrongPassWord")
	public void testWrongPassWord(String username, String password) {
		// Nhập tên đăng nhập đúng
		WebElement username1 = driver
				.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='input-group']/input"));
		username1.clear();
		username1.sendKeys(username);

		// Nhập mật khẩu sai
		WebElement password1 = driver
				.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='form-group'][2]//input"));
		password1.clear();
		password1.sendKeys(password);

		// Click nút Login
		WebElement loginButton = driver.findElement(By.xpath("//div[@class='form_login bg-white']//button"));
		loginButton.click();
		// Chờ và kiểm tra thông báo lỗi toàn cục (hiện rồi biến mất)
		try {
			WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("2")));
			String messageText = errorMessage.getText();
			System.out.println("Error Message: " + messageText);
			Assert.assertEquals(messageText, "Mật khẩu không đúng");
		} catch (Exception e) {
			Assert.fail("Không tìm thấy thông báo lỗi.");
		}
	}
	 @DataProvider(name = "WrongNumberCharacter")
		public Object[][] WrongNumberCharacter() {
			return new Object[][] { 
				{ "0923452345", "12345" },
				{ "0923452345", "1234561234561234561234561" },
				{ "0923452345", "" }
				};
		}

		 @Test(dataProvider = "WrongNumberCharacter")
		public void testWrongNumberCharacterPasWord(String username, String password) {
			// Nhập tên đăng nhập đúng
			WebElement username1 = driver
					.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='input-group']/input"));
			username1.clear();
			username1.sendKeys(username);

			// Nhập mật khẩu sai
			WebElement password1 = driver
					.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='form-group'][2]//input"));
			password1.clear();
			password1.sendKeys(password);

			// Click nút Login
			WebElement loginButton = driver.findElement(By.xpath("//div[@class='form_login bg-white']//button"));
			loginButton.click();
			// Chờ và kiểm tra thông báo lỗi toàn cục (hiện rồi biến mất)
			try {
				WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[1]/div/div[1]/div/form/div[2]/p")));
				String messageText = errorMessage.getText();
				System.out.println("Error Message: " + messageText);
				Assert.assertEquals(messageText, "Mật khẩu phải từ 6 đến 24 ký tự");
			} catch (Exception e) {
				Assert.fail("Không tìm thấy thông báo lỗi.");
			}
		}

	@Test
	public void testWrongUserName() {
		// Nhập tên đăng nhập đúng
		WebElement username1 = driver
				.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='input-group']/input"));
		username1.clear();
		username1.sendKeys("0923452349");

		// Nhập mật khẩu sai
		WebElement password1= driver.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='form-group'][2]//input"));
		password1.clear();
		password1.sendKeys("1234123");

		// Click nút Login
		WebElement loginButton = driver.findElement(By.xpath("//div[@class='form_login bg-white']//button"));
		loginButton.click();

		// Chờ và kiểm tra thông báo lỗi toàn cục (hiện rồi biến mất)
		try {
			WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("2")));
			String messageText = errorMessage.getText();
			System.out.println("Error Message: " + messageText);
			Assert.assertEquals(messageText, "Không tìm thấy user");
		} catch (Exception e) {
			Assert.fail("Không tìm thấy thông báo lỗi.");
		}
	}

	@Test
	public void testWrongFormatUser() {
		// Nhập tên đăng nhập đúng
		WebElement username1 = driver
				.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='input-group']/input"));
		username1.clear();
		username1.sendKeys("092345234$");

		// Nhập mật khẩu sai
		WebElement password1= driver.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='form-group'][2]//input"));
		password1.clear();
		password1.sendKeys("1234123");

		// Click nút Login
		WebElement loginButton = driver.findElement(By.xpath("//div[@class='form_login bg-white']//button"));
		loginButton.click();

		// Chờ và kiểm tra thông báo lỗi toàn cục (hiện rồi biến mất)
		try {
			WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
			String messageText = errorMessage.getText();
			System.out.println("Error Message: " + messageText);
			Assert.assertEquals(messageText, "Email/ Số điện thoại chưa đúng định dạng!");
		} catch (Exception e) {
			Assert.fail("Không tìm thấy thông báo lỗi.");
		}
	}



	
}
