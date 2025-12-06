package Listeners;

import java.util.Base64;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Baseclass.Baseclass;

public class Listenerimplementation implements ISuiteListener,ITestListener {
	
	
	ExtentSparkReporter spark;
	 ExtentReports report;
	 ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		Reporter.log("configuration",true);
		
	    Date d=new Date();
	    String newdate = d.toString().replace(" ","_").replace(":","_");
	    spark=new ExtentSparkReporter("./Advancereport/report_"+newdate+".html");
	    spark.config().setDocumentTitle("karthikproject report");
	    spark.config().setReportName("karthik report");
	    
	    report=new ExtentReports();
	    report.attachReporter(spark);
	    
	    
		
	}

	@Override
	public void onFinish(ISuite suite) {
		
		report.flush();
		Reporter.log("backup",true);
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	    test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,"===="+result.getMethod().getMethodName()+"==execution started====");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.INFO,"===="+result.getMethod().getMethodName()+"==success====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testname = result.getMethod().getMethodName();
		Date d=new Date();
	    String newdate = d.toString().replace(" ","_").replace(":","_");
	    
	   TakesScreenshot st=(TakesScreenshot) Baseclass.sdriver;
	   String temp = st.getScreenshotAs(OutputType.BASE64);
	   test.addScreenCaptureFromBase64String(temp,testname+newdate);
	   test.log(Status.INFO,"===="+result.getMethod().getMethodName()+"==failure====");
	   
	    
	    
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.INFO,"===="+result.getMethod().getMethodName()+"==skipped====");
		
	}

	
	
	

}
