package com.EBanking.baseclass;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.EBanking.commons.Commons;
import com.EBanking.constants.Constants;
import com.EBanking.pages.HomePage;
import com.EBanking.utils.PropertiesReading;

public class BaseClass {
	@BeforeMethod
	public void setUp() throws InterruptedException {
		Commons.setBrowser(PropertiesReading.getProperties("Browser"));
		Commons.setWindowMaximize();
		Commons.setImplicitWait(10);
		Commons.launchUrl(PropertiesReading.getProperties("Url"));
		HomePage homepage = PageFactory.initElements(Constants.driver, HomePage.class);
		homepage.signUp();
	}

	@AfterMethod
	public void tearDown() {
		Commons.closeBrowser();
	}
}
