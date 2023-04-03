package final_project;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class class_Test extends parameter {

//	//Sign-Up test 
	@Test(priority = 1)
	public void Sign_UP() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://magento.softwaretestingboard.com/");


		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
		Thread.sleep(3000);

		String Actual_Result = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul")).getText();

		Boolean expected = Actual_Result.contains("Welcome");
		myAssert.assertEquals(expected, true);
		myAssert.assertAll();
//sign in and check if you sign in correct
	}

//	//search bar test random value and print the value in the console
	@Test(priority = 2)
	public void Search_Bar() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://magento.softwaretestingboard.com/");
		String[] data = { "Jacket", "t-shirt", "jeans for men", "jeans for women", "pants" };
		Random rand = new Random();
		int RandomNumber = rand.nextInt(5);
		String sendData = data[RandomNumber];
		driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(sendData);
		Thread.sleep(2000);

		System.out.println(sendData);

	}
//adding items and add the color and the size randomly
	@Test(priority = 3)
	public void add_Items() throws InterruptedException {
		Random rand = new Random();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//item 1
		driver.get("https://magento.softwaretestingboard.com/radiant-tee.html#");
		Thread.sleep(2000);

		List<WebElement> size = driver.findElements(By.className("swatch-option"));
		size.get(rand.nextInt(1, 5)).click();
		Thread.sleep(3000);
		List<WebElement> color = driver.findElements(By.className("color"));
		color.get(rand.nextInt(1, 3)).click();

		driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("3");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();

		// item 2
		driver.get("https://magento.softwaretestingboard.com/breathe-easy-tank.html");
		Thread.sleep(2000);
		List<WebElement> size2 = driver.findElements(By.className("swatch-option"));
		size2.get(rand.nextInt(1, 5)).click();
		Thread.sleep(4000);
		List<WebElement> color2 = driver.findElements(By.className("color"));
		color2.get(rand.nextInt(1, 3)).click();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
		Thread.sleep(2000);

		// item 3
		driver.get("https://magento.softwaretestingboard.com/argus-all-weather-tank.html");
		Thread.sleep(2000);
		List<WebElement> size3 = driver.findElements(By.className("swatch-option"));
		size3.get(rand.nextInt(1, 5)).click();
		driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-52\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("4");
		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
		Thread.sleep(1000);

		// item 4
		driver.get("https://magento.softwaretestingboard.com/hero-hoodie.html");

		Thread.sleep(2000);
		List<WebElement> size4 = driver.findElements(By.className("swatch-option"));
		size4.get(rand.nextInt(1, 5)).click();
		Thread.sleep(2000);
		List<WebElement> color4 = driver.findElements(By.className("color"));
		color4.get(rand.nextInt(1, 3)).click();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();

//	//item 5
//	driver.get("https://magento.softwaretestingboard.com/fusion-backpack.html");
//	driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
//	driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("5");
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr/td[1]/input")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
		//check if the price are correct
		Thread.sleep(4000);
		String finalPrice = driver
				.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[4]/td/strong/span")).getText();
		String ExpectedPrice = "$253.20";
		myAssert.assertEquals(finalPrice, ExpectedPrice);
		myAssert.assertAll();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div/div/a/span")).click();

	}
//reOrder the items
	@Test(priority = 4)
	public void reOrder() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://magento.softwaretestingboard.com/customer/account/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/a[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div/div/a")).click();

		Thread.sleep(2000);
	}
//check if the final price after reOrder is correct
	@Test(priority = 5)
	public void Check_Price() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/customer/account/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a")).click();
		String price1 = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[4]")).getText();
		String price2 = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[2]/td[4]")).getText();
		String price3 = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[3]/td[4]")).getText();
		String price4 = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[4]/td[4]")).getText();
		String price5 = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[5]/td[4]")).getText();
		String expected_Result = "$253.20";
		if (price1 == expected_Result && price2 == expected_Result && price3 == expected_Result
				&& price4 == expected_Result && price5 == expected_Result) {

			myAssert.assertEquals(price1, expected_Result, "Number 1");
			myAssert.assertEquals(price2, expected_Result, "Number 2");
			myAssert.assertEquals(price3, expected_Result, "Number 3");
			myAssert.assertEquals(price4, expected_Result, "Number 4");
			myAssert.assertEquals(price5, expected_Result, "Number 5");
		}
		myAssert.assertAll();
	}
}
