package com.EBanking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage {
	@FindBy(id = "sp_payee")
	private WebElement payeeBankName;

	@FindBy(id = "sp_account")
	private WebElement account;

	@FindBy(id = "sp_amount")
	private WebElement amount;

	@FindBy(id = "sp_date")
	private WebElement date;

	@FindBy(id = "sp_description")
	private WebElement description;

	@FindBy(id = "pay_saved_payees")
	private WebElement pay;

	@FindBy(xpath = "//span[contains(text(),\"The payment was successfully submitted.\")]")
	private WebElement paySuccessMsg;

	@FindBy(linkText = "Add New Payee")
	private WebElement newPayee;

	@FindBy(id = "np_new_payee_name")
	private WebElement payName;

	@FindBy(id = "np_new_payee_address")
	private WebElement payeeAddress;

	@FindBy(id = "np_new_payee_account")
	private WebElement newPayeeActNo;

	@FindBy(id = "np_new_payee_details")
	private WebElement payeeDetails;

	@FindBy(id = "add_new_payee")
	private WebElement addpayeeButton;

	@FindBy(xpath = "//div[@id=\"alert_content\"]")
	private WebElement successfullAddNewPayee;

	@FindBy(linkText = "Purchase Foreign Currency")
	private WebElement pForeignCurrency;

	@FindBy(id = "pc_currency")
	private WebElement country;

	@FindBy(id = "pc_amount")
	private WebElement cAmount;

	@FindBy(xpath = "(//label[@class=\"radio inline\"])[3]")
	private WebElement cButton;

	@FindBy(id = "pc_calculate_costs")
	private WebElement calAmount;

	@FindBy(id = "pc_conversion_amount")
	private WebElement conAmount;

	@FindBy(xpath = "//input[@id=\"purchase_cash\"]")
	private WebElement convert;

	@FindBy(id = "alert_content")
	private WebElement conText;

	public void purForeignCurrencybutton() {
		pForeignCurrency.click();
	}

	public void purchessForeginCurrencyFullFunctionality(String cCurrency, String fCAmount) {
		purForeignCurrencybutton();
		selectCountry(cCurrency);
		enterAmountToChange(fCAmount);
		calCurrencyButton();
		calculateCost();
		convertAmmount();
	}

	public String conSuccsesText() {
		String text = conText.getText();
		return text;
	}

	public void purchesForainCurrency() {
		pForeignCurrency.click();
	}

	public void selectCountry(String cName) {
		Select select = new Select(country);
		select.selectByVisibleText(cName);
	}

	public void enterAmountToChange(String amtTochenge) {
		cAmount.sendKeys("700");
	}

	public void calCurrencyButton() {
		cButton.click();

	}

	public void calculateCost() {
		calAmount.click();
	}

	public String getCalculatedAmount() {
		String s = conAmount.getText();
		return s;
	}

	public void convertAmmount() {
		convert.click();
	}

	public void selectBankName(String bName) {
		Select select = new Select(payeeBankName);
		select.selectByVisibleText(bName);
	}

	public void selectAccount(String baccount) {
		Select select = new Select(account);
		select.selectByVisibleText(baccount);
	}

	public void enterAmount(String amt) {
		amount.sendKeys(amt);
	}

	public void selectDateBox(String pDate) {
		date.sendKeys(pDate);
	}

	public void payeeDescription(String desc) {
		description.sendKeys(desc);
	}

	public void clickOnPay() {
		pay.click();
	}

	public String paySuccessfullyText() {
		String text = paySuccessMsg.getText();
		return text;
	}

	public void payBillsfullyFunctionality(String pBankName, String pAccount, String pAmmount, String pDate,
			String pDesc) {
		selectBankName(pBankName);
		selectAccount(pAccount);
		enterAmount(pAmmount);
		selectDateBox(pDate);
		payeeDescription(pDesc);
		clickOnPay();

	}

	public void addNewPayeeClick() {
		newPayee.click();
	}

	public void addNewName(String pName) {
		payName.sendKeys(pName);
	}

	public void addNewPayeeAddresss(String addreess) {
		payeeAddress.sendKeys(addreess);
	}

	public void addNewPayeeAccountNo(String acNo) {
		newPayeeActNo.sendKeys(acNo);
	}

	public void addNewPayeeDetails(String details) {
		payeeDetails.sendKeys(details);
	}

	public void clickOnPayeeButton() {
		addpayeeButton.click();
	}

	public String actualTextOfsuccefullyAddedNewPayee() {
		String text = successfullAddNewPayee.getText();
		return text;
	}

	public void addNewPayeeFullFuctionality(String newPName, String newPAddress, String newPAccountNo,
			String newPDetails) {
		addNewPayeeClick();
		addNewName(newPName);
		addNewPayeeAddresss(newPAddress);
		addNewPayeeAccountNo(newPAccountNo);
		addNewPayeeDetails(newPDetails);
		clickOnPayeeButton();

	}

}
