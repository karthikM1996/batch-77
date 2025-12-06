package karthikproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.Homepage;
import ObjectRepository.campaignpage;
import ObjectRepository.loginpage;
import genericutility.ExcelUtility;
import genericutility.JavaUtility;
import genericutility.PropertiesUtility;
import genericutility.WebdriverUtility;

public class mm {
	
	public static void main(String[] args) throws IOException {
		
		PropertiesUtility putil=new PropertiesUtility();
		 ExcelUtility eutil=new ExcelUtility();
		 JavaUtility jutil=new JavaUtility();
		 WebdriverUtility wutil=new WebdriverUtility();
		 
		 
		 String BROWSER = putil.toReadTheDataFromPropertiesfile("Browser");
		 String URL = putil.toReadTheDataFromPropertiesfile("Url");
		 String USERNAME = putil.toReadTheDataFromPropertiesfile("Username");
		 String PASSWORD = putil.toReadTheDataFromPropertiesfile("Password");
		 
		
		 
	/*	FileInputStream fis=new FileInputStream("D:\\karthik_workspace\\karthikproject\\src\\test\\resources\\commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("Url");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");*/
		
		
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
		
		/*FileInputStream f=new FileInputStream("D:\\karthik_workspace\\karthikproject\\src\\test\\resources\\kscript.xls.xlsx");
	     Workbook wb = WorkbookFactory.create(f);
	     String cpname = wb.getSheet("campaign").getRow(1).getCell(0).getStringCellValue();
	     String cpstatus = wb.getSheet("campaign").getRow(1).getCell(1).getStringCellValue();
	     String targetsize = wb.getSheet("campaign").getRow(1).getCell(2).getStringCellValue();*/
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.manage().window().maximize();
		 driver.get(URL);
		 
		 //to read data from properties file
		 
		 loginpage lp=new loginpage(driver);
		 lp.getUN().sendKeys(USERNAME);
		 lp.getPSW().sendKeys(PASSWORD);
		 lp.getLoginbtn().click();
		 
		/* driver.findElement(By.id("username")).sendKeys(USERNAME);
		 driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		 driver.findElement(By.cssSelector("button[type='submit']")).click();*/
		 
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
		 
		 
		 
		/* driver.findElement(By.name("campaignName")).sendKeys(cpname);
		 driver.findElement(By.name("campaignStatus")).sendKeys(cpstatus);
		
		 WebElement target = driver.findElement(By.name("targetSize"));
		 target.clear();
		 target.sendKeys(targetsize);
		 
		 Date d=new Date();
		 SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
		 String current = sim.format(d);
		 Calendar cal = sim.getCalendar();
		 cal.add(cal.DAY_OF_MONTH, 2);
		 String requiredate = sim.format(cal.getTime());
		 System.out.println(requiredate);
		 
		 
		 driver.findElement(By.name("expectedCloseDate")).sendKeys(requiredate);*/
		 
		 Thread.sleep(2000);
		 WebElement tostmgs = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--error']"));
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.visibilityOf(tostmgs));
		 Thread.sleep(2000);
		 hp.getClostostmsg().click();
		 /*driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		 WebElement tostmgs = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--error']"));
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.visibilityOf(tostmgs));
		 driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();*/
		
		
	     WebElement icon = hp.getUseicon();
		 wutil.movetoelement(driver,icon  );
		hp.getLogoutbtn().click();
		/* driver.findElement(By.className("user-icon")).click();
		 WebElement logoutbtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
		 Actions a=new Actions(driver);
		 a.moveToElement(logoutbtn).click().perform();*/
	}
	}



