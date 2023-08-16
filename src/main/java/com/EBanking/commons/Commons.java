package com.EBanking.commons;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.EBanking.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Commons {
	public static void setBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			Constants.driver = WebDriverManager.chromedriver().create();
			break;
		case "Firefox":
			Constants.driver = WebDriverManager.firefoxdriver().create();
			break;

		case "Safari":
			Constants.driver = WebDriverManager.safaridriver().create();
			break;

		case "Edge":
			Constants.driver = WebDriverManager.edgedriver().create();
			break;

		default:
			System.out.println("Invalid Browser Name:-" + browserName);
			break;
		}

	}

	public static void setWindowMaximize() {
		Constants.driver.manage().window().maximize();
	}

	public static void setImplicitWait(int time) {
		Constants.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public static void launchUrl(String Url) {
		Constants.driver.get(Url);
	}

	public static void closeBrowser() {
		Constants.driver.close();
	}

	public static void quite() {
		Constants.driver.quit();
	}

	public static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		switch (locatorType) {
		case "id":
			element = Constants.driver.findElement(By.id(locatorValue));
			break;

		case "name":
			element = Constants.driver.findElement(By.name(locatorValue));
			;

		case "className":
			element = Constants.driver.findElement(By.className(locatorValue));
			break;

		case "xpath":
			element = Constants.driver.findElement(By.xpath(locatorValue));
			break;

		case "tagName":
			element = Constants.driver.findElement(By.tagName(locatorValue));
			break;

		case "linkText":
			element = Constants.driver.findElement(By.linkText(locatorValue));
			break;

		case "partialLinkText":
			element = Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;

		case "cssSelector":
			element = Constants.driver.findElement(By.cssSelector(locatorValue));
			break;

		default:
			System.out.println("Invalid Locator:-" + locatorType);
			break;

		}
		return element;
	}

	public static WebElement getWebElements(String locatorType, String locatorValue) {
		WebElement elements = null;
		switch (locatorType) {
		case "id":
			elements = Constants.driver.findElement(By.id(locatorValue));
			break;

		case "name":
			elements = Constants.driver.findElement(By.name(locatorValue));

		case "className":
			elements = Constants.driver.findElement(By.className(locatorValue));
			break;

		case "xpath":
			elements = Constants.driver.findElement(By.xpath(locatorValue));
			break;

		case "tagName":
			elements = Constants.driver.findElement(By.tagName(locatorValue));
			break;

		case "linkText":
			elements = Constants.driver.findElement(By.linkText(locatorValue));
			break;

		case "partialLinkText":
			elements = Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;

		case "cssSelector":
			elements = Constants.driver.findElement(By.cssSelector(locatorValue));
			break;

		default:
			System.out.println("Invalid Locator:-" + locatorType);
			break;

		}
		return elements;
	}

	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public static void clickOnWebelement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public static String getWebElementText(String locatorType, String locatorValue) {
		String text = Commons.getWebElement(locatorType, locatorValue).getText();

		return text;

	}

	public static void scrollUpAndDown(int pixel) {
		JavascriptExecutor jse = (JavascriptExecutor) Constants.driver;
		jse.executeScript("window.scrollBy(0," + pixel + ")");

	}

	public static String timeStampUsernameGenerator() {
		Date date = new Date();
		String uname = date.toString().replace("_", "").substring(11, 18).replace(":", "");
		return "Selnium" + uname;

	}

	public static String timeStampAccountNoGeneerator() {
		Date date = new Date();
		String AccountNo = date.toString().replace("_", "").substring(11, 18).replace(":", "");
		return " 971803178"+AccountNo;
	}

	public static void pageBackword() {
		Constants.driver.navigate().back();
	}

	public static void dropDown(String locatorType, String locatorValue, String textToEnter) {
		Select select = new Select(Commons.getWebElement(locatorType, locatorValue));
		select.selectByVisibleText(textToEnter);
	}
}
