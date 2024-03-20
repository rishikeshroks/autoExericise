package amazonExample;

import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.By;

public class LoginApp extends BaseTest {

	// Test the login feature
	@Test
	public void verifyLoginFeature() throws Exception {

		driver.findElement(By.id("Email")).clear();

		Thread.sleep(1000);

		driver.findElement(By.id("Email")).sendKeys(conf.getAdminUser());

		driver.findElement(By.id("Password")).clear();

		Thread.sleep(1000);
		driver.findElement(By.id("Password")).sendKeys(conf.getAdminPass());
		driver.findElement(By.cssSelector(".button-1")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".nav-item:nth-child(4) .right")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".menu-is-opening .nav-item:nth-child(1) > .nav-link")).click();

		// Add new customer
		driver.findElement(By.linkText("Add new")).click();
		driver.findElement(By.id("Email")).click();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		driver.findElement(By.id("Email")).sendKeys("Testuser" + randomInt + "@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("admin123");
		driver.findElement(By.id("FirstName")).sendKeys("Testuser" + randomInt);
		driver.findElement(By.id("LastName")).sendKeys("LastName" + randomInt);
		driver.findElement(By.id("Gender_Male")).click();
		driver.findElement(By.id("DateOfBirth")).sendKeys("3/20/2024");
		driver.findElement(By.id("Company")).sendKeys("Incedo");
		String CurEmail = "Testuser" + randomInt + "@gmail.com";
		driver.findElement(By.name("save")).click();

		// Verify the success alert
		String alertMessage = driver.findElement(By.cssSelector(".alert")).getText();
		System.out.println(CurEmail + alertMessage);
		

		// Search the Customer
		driver.findElement(By.id("SearchEmail")).sendKeys(CurEmail);
		driver.findElement(By.id("search-customers")).click();

	}

}