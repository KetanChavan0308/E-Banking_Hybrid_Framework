package com.EBanking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlineBankingPage {
	@FindBy(xpath = "//strong[contains(text(),\"Online Banking\")]")
	private WebElement onlineBanking;

	@FindBy(id = "pay_bills_link")
	private WebElement payBills;

	public void clickOnOnlineBanking() {
		onlineBanking.click();
	}

	public void clickOnPayBills() {
		payBills.click();
	}

}
