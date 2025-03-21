package demo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.openqa.selenium.support.ui.WebDriverWait;
import demo.WebUI;

public class TestLogin extends BaseTest {
	
	@Test
	 public void loginFail() {
		

		    String expectedTitle = "Mật khẩu không đúng";
		   
	        driver.get("https://crm.ommani.vn/");
	        driver.findElement(By.xpath("//div[@class='content-signup__btn']/a")).click();
	        driver.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='input-group']/input")).sendKeys("0923452345");
	        driver.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='form-group'][2]//input")).sendKeys("1233441234");
	        driver.findElement(By.xpath("//div[@class='form_login bg-white']//button")).click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//	        WebUI.sleep(5);
//	        WebUI.waitForElementClickable(driver, By.xpath("//div[@class='card_restaurant mb-1']/input[@type='radio']"), 3);
//	        driver.findElement(By.xpath("//div[@class='card_restaurant mb-1']/input[@type='radio']")).click();
//	        WebUI.waitForPageLoaded(driver);
	        WebElement messageElement = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id("2"))
	            );

	            // Lấy text từ message
	            String messageText = messageElement.getText();
	        assertEquals(messageText,expectedTitle);
	    }
	@Test
	public void logSuccess() {
		 String expectedTitle = "OmmaniX";
        driver.get("https://crm.ommani.vn/");
        driver.findElement(By.xpath("//div[@class='content-signup__btn']/a")).click();
        driver.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='input-group']/input")).sendKeys("0923452345");
        driver.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='form-group'][2]//input")).sendKeys("12341234");
        driver.findElement(By.xpath("//div[@class='form_login bg-white']//button")).click();
//        WebUI.sleep(5);
//        WebUI.waitForElementClickable(driver, By.xpath("//div[@class='card_restaurant mb-1']/input[@type='radio']"), 3);
//        driver.findElement(By.xpath("//div[@class='card_restaurant mb-1']/input[@type='radio']")).click();
//        WebUI.waitForPageLoaded(driver);
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle,expectedTitle);
    }
	public void logWithWrongPass() {
		 String expectedTitle = "OmmaniX";
       driver.get("https://crm.ommani.vn/");
       driver.findElement(By.xpath("//div[@class='content-signup__btn']/a")).click();
       driver.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='input-group']/input")).sendKeys("0923452345");
       driver.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='form-group'][2]//input")).sendKeys("12341234");
       driver.findElement(By.xpath("//div[@class='form_login bg-white']//button")).click();
//       WebUI.sleep(5);
//       WebUI.waitForElementClickable(driver, By.xpath("//div[@class='card_restaurant mb-1']/input[@type='radio']"), 3);
//       driver.findElement(By.xpath("//div[@class='card_restaurant mb-1']/input[@type='radio']")).click();
//       WebUI.waitForPageLoaded(driver);
       String actualTitle = driver.getTitle();
       assertEquals(actualTitle,expectedTitle);
   }
	public void logWithPass() {
		 String expectedTitle = "OmmaniX";
      driver.get("https://crm.ommani.vn/");
      driver.findElement(By.xpath("//div[@class='content-signup__btn']/a")).click();
      driver.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='input-group']/input")).sendKeys("0923452345");
      driver.findElement(By.xpath("//div[@class='form_login bg-white']//div[@class='form-group'][2]//input")).sendKeys("12341234");
      driver.findElement(By.xpath("//div[@class='form_login bg-white']//button")).click();
//      WebUI.sleep(5);
//      WebUI.waitForElementClickable(driver, By.xpath("//div[@class='card_restaurant mb-1']/input[@type='radio']"), 3);
//      driver.findElement(By.xpath("//div[@class='card_restaurant mb-1']/input[@type='radio']")).click();
//      WebUI.waitForPageLoaded(driver);
      String actualTitle = driver.getTitle();
      assertEquals(actualTitle,expectedTitle);
  }


//	    private String CUSTOMER_NAME = "CMC Global";
//	    private String WEBSITE = "https://cmcglobal.com.vn/vi/home-vi/";

	   @Test 
	    public void addCustomer() {
	        loginPerfexCRM();
	        WebUI.waitForElementPresent(driver, By.xpath("//div[@class='d-flex justify-content-start align-items-center gap-8px']//img"), 12);
	        driver.findElement(By.xpath("//div[@class='d-flex justify-content-start align-items-center gap-8px']//img")).click();
	        driver.findElement(By.xpath("//*[@id=\":r0:\"]/div/div/div/div[2]/div[5]/a")).click();
	        WebUI.waitForPageLoaded(driver);
	        WebUI.sleep(1);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div[1]/div[1]/div/div/div[4]/button")).click();
	        driver.findElement(By.xpath("//*[@id=\"add_edit_product\"]/div/div/div[2]/div[1]/div[1]/div/label[1]"));
	        driver.findElement(By.xpath("//*[@id=\"add_edit_product\"]/div/div/div[2]/div[1]/div[2]/div/label[2]"));
	        WebUI.sleep(1);
	        driver.findElement(By.xpath("//*[@id=\"add_edit_product\"]/div/div/div[2]/div[2]/div[1]/span/input")).sendKeys("testnn");
	        driver.findElement(By.xpath("//*[@id=\"add_edit_product\"]/div/div/div[2]/div[7]/button")).click();
	        //Kiểm tra Save thành công chuyển hướng đến trang Customer Details
//	        Assert.assertTrue(WebUI.checkElementExist(driver, By.xpath("//a[normalize-space()='Customer Details']")), "Can not navigate to Customer Details page.");
	        
//	        driver.findElement(By.id("company")).sendKeys(CUSTOMER_NAME);
//	        driver.findElement(By.id("vat")).sendKeys("10");
//	        driver.findElement(By.id("phonenumber")).sendKeys("0123456789");
//	        driver.findElement(By.id("website")).sendKeys(WEBSITE);
//	        WebUI.sleep(1);
//	        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
//	        WebUI.sleep(1);
//	        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']")).sendKeys("Gold", Keys.ENTER);
//	        WebUI.sleep(1);
//	        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
//	        WebUI.sleep(1);
//	        driver.findElement(By.id("address")).sendKeys("Viet Nam");
//	        driver.findElement(By.id("city")).sendKeys("Can Tho");
//	        driver.findElement(By.id("state")).sendKeys("Can Tho");
//	        driver.findElement(By.id("zip")).sendKeys("92000");
//	        WebUI.sleep(1);
//	        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div")).click();
//	        WebUI.sleep(1);
//	        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']")).sendKeys("Vietnam", Keys.ENTER);
//	        WebUI.sleep(1);
//	        driver.findElement(By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']")).click();
//	        WebUI.waitForPageLoaded(driver);
//	        //Kiểm tra Save thành công chuyển hướng đến trang Customer Details
//	        Assert.assertTrue(WebUI.checkElementExist(driver, By.xpath("//a[normalize-space()='Customer Details']")), "Can not navigate to Customer Details page.");
//
//	        verifyCustomerAdded();
	    }

//	    public void verifyCustomerAdded() {
//	        //Click mở trang Customers lại
//	        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
//	        WebUI.waitForPageLoaded(driver);
//	        //Search tên customer vừa add
//	        driver.findElement(By.xpath("//input[@class='form-control input-sm']")).sendKeys(CUSTOMER_NAME);
//	        WebUI.sleep(1);
//	        WebUI.waitForPageLoaded(driver);
//	        WebUI.waitForElementVisible(driver, By.xpath("//tbody/tr[1]/td[3]/a"), 10);
//	        //Get Text cột customer name
//	        String getCustomerName = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a")).getText();
//	        System.out.println(getCustomerName);
//	        //Verify equals với data input
//	        Assert.assertEquals(getCustomerName, CUSTOMER_NAME, "FAILED. Customer Name not match.");
//	    }
}
