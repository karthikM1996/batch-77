package Baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.Homepage;
import ObjectRepository.loginpage;
import genericutility.ExcelUtility;
import genericutility.JavaUtility;
import genericutility.PropertiesUtility;
import genericutility.WebdriverUtility;

public class Baseclass {

	public WebDriver driver=null;
	public static WebDriver sdriver;
	
	PropertiesUtility putil=new PropertiesUtility();
	 ExcelUtility eutil=new ExcelUtility();
	 JavaUtility jutil=new JavaUtility();
	 WebdriverUtility wutil=new WebdriverUtility();
	 
	 loginpage lp=new loginpage(driver);
	
	@BeforeSuite
	  public void beforeSuite() 
	  {
		System.out.println("connect to db");
	  }
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("pre condition");
	}
	
	 @BeforeClass
	  public void beforeClass() throws Exception 
	 {
		 String BROWSER = putil.toReadTheDataFromPropertiesfile("Browser");
		
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
			
			sdriver=driver;
			
			
			System.out.println("browser launched");
	  }

		  
		  @BeforeMethod
		  public void beforeMethod() throws Exception 
		  {
			 
				 String URL = putil.toReadTheDataFromPropertiesfile("Url");
				 String USERNAME = putil.toReadTheDataFromPropertiesfile("Username");
				 String PASSWORD = putil.toReadTheDataFromPropertiesfile("Password");
				
				 driver.get(URL);
				 loginpage lp=new loginpage(driver);
				 lp.getUN().sendKeys(USERNAME);
				 lp.getPSW().sendKeys(PASSWORD);
				 lp.getLoginbtn().click();
				 System.out.println("login");
		  }

		  @AfterMethod
		  public void afterMethod() 
		  {
			  Homepage hp=new Homepage(driver);
			  WebElement icon = hp.getUseicon();
			  wutil.movetoelement(driver,icon  );
			  hp.getLogoutbtn().click();
			  System.out.println("logout");
				
		  }

		  

		  @AfterClass
		  public void afterClass() 
		  {
			  driver.quit();
			  System.out.println("closing browser");
		  }

		  @AfterTest
		  public void aftertest()
		  {
			  System.out.println("post condition");
		  }

		  @AfterSuite
		  public void afterSuite() {
			  System.out.println("close db");
		  }

		}


