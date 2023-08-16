package com.EBanking.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentReports generateExtentReport() {
		String projectPath = System.getProperty("user.dir");
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(projectPath + "/Extent Report/MyReport.html");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("E-Banking Project");
		sparkReport.config().setDocumentTitle("E-Banking");
		extentReports.attachReporter(sparkReport);

		extentReports.setSystemInfo("Application Url", PropertiesReading.getProperties("Url"));
		extentReports.setSystemInfo("BroserName", PropertiesReading.getProperties("Browser"));
		extentReports.setSystemInfo("Java Version", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Executed By", "Ketan Chavan");
		return extentReports;

	}

}
