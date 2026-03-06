package pratice;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericutilities.ExcelUtility;
import genericutilities.JavaUtility;
import genericutilities.WebdriverUtility;

public class logintoproject {

	public static void main(String[] args) throws Exception {
		
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("Url");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");
		
		WebDriver driver=null;
		if(BROWSER.contains("Edge"))
		{
			 driver=new EdgeDriver();
		}
		
	/*	FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestScrpitData.xls.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("campaign");
		 Row name = sheet.getRow(1);
		 String campname = name.getCell(2).getStringCellValue();
		 String status = name.getCell(3).getStringCellValue();
		 String target1 = name.getCell(4).getStringCellValue();*/
		
		ExcelUtility eutil=new ExcelUtility();
		String campname = eutil.ToReadDataFromExcel("campaign", 1, 2);
		String status = eutil.ToReadDataFromExcel("campaign", 1, 3);
		String target1 = eutil.ToReadDataFromExcel("campaign", 1, 4);
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		
	    
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
      	driver.findElement(By.name("campaignName")).sendKeys(campname);
		driver.findElement(By.name("campaignStatus")).sendKeys(status);
		WebElement target = driver.findElement(By.name("targetSize"));
		target.clear();
		target.sendKeys(target1);
		
		
		/*Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd_MM_yyyy");
		String currentdate = sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String expdate = sim.format(cal.getTime());*/
		
		JavaUtility jutil=new JavaUtility();
		String expdate = jutil.TogetExpectedDate(30);
		
		
		driver.findElement(By.name("expectedCloseDate")).sendKeys(expdate);
		Thread.sleep(2000);
		
	

		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		WebElement tostmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(tostmsg));
		String tost = tostmsg.getText();
		if(tost.contains("successfully"))
		{
			System.out.println("created");
		}
		else
		{
			System.out.println("not created");
		}
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		
		WebElement usericon = driver.findElement(By.className("user-icon"));
		WebdriverUtility wutil=new WebdriverUtility();
		//Actions act=new Actions(driver);
		//act.moveToElement(usericon).perform();
		wutil.tomouseover(driver,usericon);
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		//act.moveToElement(logout).click().perform();
		wutil.tomouseover(driver,logout).click();
		System.out.println("hi");
		driver.quit();
		
		
	}
}
