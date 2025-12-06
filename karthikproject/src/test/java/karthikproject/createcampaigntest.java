package karthikproject;

import java.io.IOException;


import org.apache.commons.collections4.ListUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Baseclass.Baseclass;
import Listeners.Listenerimplementation;
import ObjectRepository.Homepage;
import ObjectRepository.campaignpage;
import ObjectRepository.loginpage;
import genericutility.ExcelUtility;
import genericutility.JavaUtility;
import genericutility.PropertiesUtility;
import genericutility.WebdriverUtility;
import lombok.experimental.UtilityClass;
import Baseclass.Baseclass;
import org.testng.annotations.Listeners;
 

@Listeners(Listenerimplementation.class)
public class createcampaigntest extends Baseclass {
	
	@Test
	public void Createcampgin() throws Exception {
	
	PropertiesUtility putil=new PropertiesUtility();
	 ExcelUtility eutil=new ExcelUtility();
	 JavaUtility jutil=new JavaUtility();
	 WebdriverUtility wutil=new WebdriverUtility();

	
	String campname = eutil.toReadDataFromExcel("campaign", 1, 0);
	String campstatus = eutil.toReadDataFromExcel("campaign", 1, 1);
	String targetsize = eutil.toReadDataFromExcel("campaign", 1, 2);
	
	
	 wutil.waituntilpageload(driver);
	 wutil.maximizewindow(driver);
	
	 
	 
	 //to read data from properties file
	 

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
	 String actual = hp.getTostmsg().getText();
	 Assert.assertEquals(actual,"failure");
	 hp.getClostostmsg().click();
	}	
	
}

