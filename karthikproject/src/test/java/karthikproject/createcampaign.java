package karthikproject;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.Homepage;
import ObjectRepository.campaignpage;
import ObjectRepository.loginpage;
import genericutility.ExcelUtility;
import genericutility.JavaUtility;
import genericutility.PropertiesUtility;
import genericutility.WebdriverUtility;

public class createcampaign {
 public static void main(String[] args) throws Exception {
	 
	 
	 PropertiesUtility putil=new PropertiesUtility();
	 ExcelUtility eutil=new ExcelUtility();
	 JavaUtility jutil=new JavaUtility();
	 WebdriverUtility wutil=new WebdriverUtility();
	 
	 
	 String BROWSER = putil.toReadTheDataFromPropertiesfile("Browser");
	 String URL = putil.toReadTheDataFromPropertiesfile("Url");
	 String USERNAME = putil.toReadTheDataFromPropertiesfile("Username");
	 String PASSWORD = putil.toReadTheDataFromPropertiesfile("Password");

	
	String campname = eutil.toReadDataFromExcel("campaign", 1, 0);
	String campstatus = eutil.toReadDataFromExcel("campaign", 1, 1);
	String targetsize = eutil.toReadDataFromExcel("campaign", 1, 2);
	
	
	WebDriver driver=null;
	if(BROWSER.equals("Edge"))
	{
	 driver=new EdgeDriver();
	}
	else if (BROWSER.equals("Chrome"))
	{
		driver=new ChromeDriver();
	}
	else if (BROWSER.equals("Firefox"))
	{
	 driver=new FirefoxDriver();
	}

	 wutil.waituntilpageload(driver);
	 wutil.maximizewindow(driver);
	 driver.get(URL);
	 
	 //to read data from properties file
	 
	 loginpage lp=new loginpage(driver);
	 lp.getUN().sendKeys(USERNAME);
	 lp.getPSW().sendKeys(PASSWORD);
	 lp.getLoginbtn().click();

	 Homepage hp=new Homepage(driver);
	 hp.getCreatecampbtn().click();
	 
	 // to read the data from excel
	 campaignpage cp=new campaignpage(driver);
	 cp.getCampnametf().sendKeys(campname);
	 cp.getCampstatusTF().sendKeys(campstatus);
	 cp.getTargetTF().sendKeys(targetsize);
	 String required = jutil.togetrequiredate(2);
	 cp.getDateTF().sendKeys(required);
	 cp.getSubmitbtn().click();

	
	 wutil.waituntilcondition(driver,hp.getTostmsg());
	 hp.getClostostmsg().click();
	 
	
     WebElement icon = hp.getUseicon();
	 wutil.movetoelement(driver,icon  );
	 hp.getLogoutbtn().click();
	
}
}
