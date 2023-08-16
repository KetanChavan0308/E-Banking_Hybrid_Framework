package com.EBanking.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.EBanking.baseclass.BaseClass;
import com.EBanking.commons.Commons;
import com.EBanking.constants.Constants;
import com.EBanking.pages.HomePage;
import com.EBanking.pages.LoginPage;
import com.EBanking.utils.PropertiesReading;

public class LoginTest extends BaseClass {
	@Test(priority = 1, dataProvider = "Data Supplier")
	public void loginWithValidCredential(String username, String password) {
		HomePage homePage = PageFactory.initElements(Constants.driver, HomePage.class);
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		loginPage.loginFuctunality(username, password);
		Constants.driver.navigate().back();
		assertEquals(homePage.gettext(), PropertiesReading.getTestData("loginSuccessExpectedText"));

	}

	@DataProvider(name = "Data Supplier")
	public Object[][] getData() {
		Object[][] data = { { PropertiesReading.getProperties("validUsername"),
				PropertiesReading.getProperties("validPassword") } };
		return data;

	}

	@Test(priority = 2)
	public void loginWithinvalidCredential() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		loginPage.loginFuctunality(PropertiesReading.getTestData("InvalidUsername"),
				PropertiesReading.getTestData("InvalidPassword"));
		assertEquals(loginPage.getunsuccesfullText(), PropertiesReading.getTestData("loginUnSuccessExpectedText"));

	}

	@Test(priority = 3)
	public void loginWithNoCredential() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		loginPage.enterLoginButton();
		assertEquals(loginPage.getunsuccesfullText(), PropertiesReading.getTestData("loginUnSuccessExpectedText"));

	}

	@Test(priority = 4)
	public void loginWithOnlyUserName() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		loginPage.username(PropertiesReading.getProperties("validUsername"));
		loginPage.enterLoginButton();
		assertEquals(loginPage.getunsuccesfullText(), PropertiesReading.getTestData("loginUnSuccessExpectedText"));

	}

	@Test(priority = 5)
	public void loginWithOnlyPassword() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		loginPage.password(PropertiesReading.getProperties("validPassword"));
		loginPage.enterLoginButton();
		assertEquals(loginPage.getunsuccesfullText(), PropertiesReading.getTestData("loginUnSuccessExpectedText"));

	}

	@Test(priority = 6)
	public void loginWithAllFields() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		HomePage homePage = PageFactory.initElements(Constants.driver, HomePage.class);
		loginPage.username(PropertiesReading.getProperties("validUsername"));
		loginPage.password(PropertiesReading.getProperties("validPassword"));
		loginPage.selectCheckBox();
		loginPage.enterLoginButton();
		Constants.driver.navigate().back();
		assertEquals(homePage.gettext(), PropertiesReading.getTestData("loginSuccessExpectedText"));

	}

	@Test(priority = 7)
	public void forgetPasswordOptionAvailableOrNot() {
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		assertEquals(loginPage.forgetPassText(), PropertiesReading.getTestData("ForgetPasswordExpectedtext"));
	}
}
