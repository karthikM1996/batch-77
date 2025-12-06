package genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public void movetoelement(WebDriver driver, WebElement element)
	{
	Actions a=new Actions(driver);
	 a.moveToElement(element).click().perform();
}
	public void waituntilpageload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void waituntilcondition(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void screenshot(WebDriver driver,String filename) throws Exception
	{
		TakesScreenshot s=(TakesScreenshot) driver;
		File temp = s.getScreenshotAs(OutputType.FILE);
		File perm=new File("./screenshot/"+filename+".png");
		FileUtils.copyFile(temp, perm);
	}
	
	
}
