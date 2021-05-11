package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPage {

	public static WebElement element = null;

	public static WebElement searchBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		return element;
	}

	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
		return element;
	}

	public static WebElement addToCartButton(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#add-to-cart-button"));
		return element;
	}

	public static WebElement checkoutButton(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#attach-sidesheet-checkout-button > span > input"));
		return element;
	}

	public static WebElement signInEmail(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ap_email"));
		return element;
	}

	public static WebElement SignInContinueButton(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#continue"));
		return element;
	}

	public static WebElement SignInSubmitButton(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#signInSubmit"));
		return element;
	}

}
