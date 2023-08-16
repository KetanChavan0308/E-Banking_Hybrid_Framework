package com.EBanking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(id = "user_login")
	WebElement uname;

	@FindBy(id = "user_password")
	WebElement pass;

	@FindBy(xpath = "//input[@name=\"submit\"]")
	WebElement loginButton;

	@FindBy(xpath = "//div[contains(text(),\" Login and/or password are wrong.\")]")
	WebElement actualText;

	@FindBy(id = "user_remember_me")
	private WebElement checkbox;

	@FindBy(linkText = "Forgot your password ?")
	private WebElement fText;

	public void username(String username) {
		uname.sendKeys(username);

	}

	public void password(String pwd) {
		pass.sendKeys(pwd);
	}

	public void enterLoginButton() {
		loginButton.click();
	}

	public String getunsuccesfullText() {
		String text = actualText.getText();
		return text;

	}

	public void selectCheckBox() {
		checkbox.click();
	}

	public String forgetPassText() {
		String text = fText.getText();
		return text;

	}

	public void loginFuctunality(String username, String password) {
		username(username);
		password(password);
		enterLoginButton();

	}
}
