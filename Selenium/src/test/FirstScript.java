package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AmazonPage;

public class FirstScript {

	public WebDriver driver;

	@BeforeTest
	public void checkWebsiteLaunch() {

		String baseUrl = "https://amazon.com/";
		String webDriverPath = "/Library/Selenium/chromedriver";

		System.setProperty("webdriver.chrome.driver", webDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

	}

	@Test
	public void CheckHomepageTitle() {

		// Verifying the title is correct
		String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String title = driver.getTitle();

		Assert.assertEquals(title, expectedTitle);

	}

	@Test
	public void addingItemToCart() throws InterruptedException {

		// Adding an item to the shopping cart
		JavascriptExecutor js = (JavascriptExecutor) driver;

		AmazonPage.searchBox(driver).sendKeys("Apple Magic Keyboard");

		AmazonPage.searchButton(driver).click();

		js.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.partialLinkText("Apple Magic Keyboard (Wireless, Rechargable)")).click();

		Thread.sleep(2000);

		AmazonPage.addToCartButton(driver).click();

		Thread.sleep(2000);

		AmazonPage.checkoutButton(driver).click();

		AmazonPage.signInEmail(driver).sendKeys("Jeanm.seda@hotmail.com");

		AmazonPage.SignInContinueButton(driver).click();

		Thread.sleep(5000);

		AmazonPage.SignInSubmitButton(driver).click();

		Thread.sleep(5000);

	}

	@AfterTest
	public void WebsiteExit() {
		// closing the browser
		driver.quit();

	}

}
