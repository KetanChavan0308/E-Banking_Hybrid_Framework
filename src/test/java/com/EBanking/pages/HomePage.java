package com.EBanking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(xpath = "//button[@id=\"signin_button\"]")
	WebElement signUp;

	@FindBy(xpath = "(//h4[text()=\"Online Banking\"])[1]")
	WebElement onlineBankingText;

	@FindBy(xpath = "(//h4[text()=\"Online Banking\"])[1]")
	private WebElement clickOnlineBanking;

	public void signUp() {
		signUp.click();

	}

	public void ClickOnlineBanking() {
		clickOnlineBanking.click();
	}

	public String gettext() {
		String text = onlineBankingText.getText();
		return text;
	}

}
