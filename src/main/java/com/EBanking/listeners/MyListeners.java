package com.EBanking.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.EBanking.constants.Constants;
import com.EBanking.utils.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener {

	ExtentReports extentReports;
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + " started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getName() + " got successfully executed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot shot = (TakesScreenshot) Constants.driver;
		String projectPath = System.getProperty("user.dir");
		File file = shot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(projectPath + "/Screenshots/" + result.getName() + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		extentTest.addScreenCaptureFromPath(projectPath + "/Screenshots/" + result.getName() + ".png");
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName() + " got failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() + " got skipped");
	}

	@Override
	public void onStart(ITestContext context) {

		extentReports = ExtentReport.generateExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

}
