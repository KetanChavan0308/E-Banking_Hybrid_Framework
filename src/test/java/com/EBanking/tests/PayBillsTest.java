package com.EBanking.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.EBanking.baseclass.BaseClass;
import com.EBanking.commons.Commons;
import com.EBanking.constants.Constants;
import com.EBanking.pages.*;
import com.EBanking.utils.PropertiesReading;

public class PayBillsTest extends BaseClass {
	@Test(priority = 1)
	public void MakePaymensOfChecking() {
		HomePage homePage = PageFactory.initElements(Constants.driver, HomePage.class);
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		OnlineBankingPage olBanking = PageFactory.initElements(Constants.driver, OnlineBankingPage.class);
		PayBillsPage payBillsPage = PageFactory.initElements(Constants.driver, PayBillsPage.class);
		loginPage.username(PropertiesReading.getProperties("validUsername"));
		loginPage.password(PropertiesReading.getProperties("validPassword"));
		loginPage.enterLoginButton();
		Constants.driver.navigate().back();
		assertEquals(homePage.gettext(), PropertiesReading.getTestData("loginSuccessExpectedText"));
		olBanking.clickOnOnlineBanking();
		olBanking.clickOnPayBills();
		payBillsPage.selectBankName("Bank of America");
		payBillsPage.selectAccount("Checking");
		payBillsPage.enterAmount("7000");
		payBillsPage.selectDateBox("2023-08-15");

		payBillsPage.payeeDescription("Remaining Payment");
		payBillsPage.clickOnPay();

		assertEquals(payBillsPage.paySuccessfullyText(),
				PropertiesReading.getTestData("PaymentSuccesfullExpectedText"));
	}

	@Test(priority = 2)
	public void MakePaymensOfLoan() {
		HomePage homePage = PageFactory.initElements(Constants.driver, HomePage.class);
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		OnlineBankingPage olBanking = PageFactory.initElements(Constants.driver, OnlineBankingPage.class);
		PayBillsPage payBillsPage = PageFactory.initElements(Constants.driver, PayBillsPage.class);
		loginPage.username(PropertiesReading.getProperties("validUsername"));
		loginPage.password(PropertiesReading.getProperties("validPassword"));
		loginPage.enterLoginButton();
		Constants.driver.navigate().back();
		assertEquals(homePage.gettext(), PropertiesReading.getTestData("loginSuccessExpectedText"));
		olBanking.clickOnOnlineBanking();
		olBanking.clickOnPayBills();
		payBillsPage.payBillsfullyFunctionality("Wells Fargo", "Loan", "7568", "2023-08-19", "Remaining  Lone Payment");
		assertEquals(payBillsPage.paySuccessfullyText(),
				PropertiesReading.getTestData("PaymentSuccesfullExpectedText"));

	}

	@Test(priority = 3)
	public void MakePaymentOfCreditCard() {

		HomePage homePage = PageFactory.initElements(Constants.driver, HomePage.class);
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		OnlineBankingPage olBanking = PageFactory.initElements(Constants.driver, OnlineBankingPage.class);
		PayBillsPage payBillsPage = PageFactory.initElements(Constants.driver, PayBillsPage.class);
		loginPage.username(PropertiesReading.getProperties("validUsername"));
		loginPage.password(PropertiesReading.getProperties("validPassword"));
		loginPage.enterLoginButton();
		Constants.driver.navigate().back();
		assertEquals(homePage.gettext(), PropertiesReading.getTestData("loginSuccessExpectedText"));
		olBanking.clickOnOnlineBanking();
		olBanking.clickOnPayBills();
		payBillsPage.payBillsfullyFunctionality("Apple", "Credit Card", "896", "2023-0715", "Credit Card Payment");

		assertEquals(payBillsPage.paySuccessfullyText(),
				PropertiesReading.getTestData("PaymentSuccesfullExpectedText"));

	}

	@Test(priority = 4)
	public void addNewPayees() {

		HomePage homePage = PageFactory.initElements(Constants.driver, HomePage.class);
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		OnlineBankingPage olBanking = PageFactory.initElements(Constants.driver, OnlineBankingPage.class);
		PayBillsPage payBillsPage = PageFactory.initElements(Constants.driver, PayBillsPage.class);
		loginPage.username(PropertiesReading.getProperties("validUsername"));
		loginPage.password(PropertiesReading.getProperties("validPassword"));
		loginPage.enterLoginButton();
		Constants.driver.navigate().back();
		assertEquals(homePage.gettext(), PropertiesReading.getTestData("loginSuccessExpectedText"));
		olBanking.clickOnOnlineBanking();
		olBanking.clickOnPayBills();

		payBillsPage.addNewPayeeFullFuctionality("Bajjaj", "Pune Maharashtra", Commons.timeStampAccountNoGeneerator(),
				"Finace Company");
		assertEquals(payBillsPage.actualTextOfsuccefullyAddedNewPayee(),
				payBillsPage.actualTextOfsuccefullyAddedNewPayee());

	}

	@Test(priority = 5)
	public void purchaseForeignCurrency() {
		HomePage homePage = PageFactory.initElements(Constants.driver, HomePage.class);
		LoginPage loginPage = PageFactory.initElements(Constants.driver, LoginPage.class);
		OnlineBankingPage olBanking = PageFactory.initElements(Constants.driver, OnlineBankingPage.class);
		PayBillsPage payBillsPage = PageFactory.initElements(Constants.driver, PayBillsPage.class);
		loginPage.username(PropertiesReading.getProperties("validUsername"));
		loginPage.password(PropertiesReading.getProperties("validPassword"));
		loginPage.enterLoginButton();
		Constants.driver.navigate().back();
		assertEquals(homePage.gettext(), PropertiesReading.getTestData("loginSuccessExpectedText"));
		olBanking.clickOnOnlineBanking();
		olBanking.clickOnPayBills();

		payBillsPage.purchessForeginCurrencyFullFunctionality("Japan (yen)", "700");

		assertEquals(payBillsPage.conSuccsesText(),
				PropertiesReading.getTestData("ForeginCurrencySuccessfullExpectedText"));
	}
}
