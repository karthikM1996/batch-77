package pratice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class pra1 {

	public static void main(String[] args) {
		
	    System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	    driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	    driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
	    driver.findElement(By.name("organizationName")).sendKeys("karthik coaching center");
	    driver.findElement(By.name("title")).sendKeys("karthik");
	    driver.findElement(By.name("department")).sendKeys("Education");
	    driver.findElement(By.name("officePhone")).sendKeys("123456789");
	    driver.findElement(By.name("contactName")).sendKeys("karthik M");
	    driver.findElement(By.name("mobile")).sendKeys("1234");
	    driver.findElement(By.name("email")).sendKeys("mahadeva@karthik.gmail.com");
	    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    String mainwindow = driver.getWindowHandle();
	     Set<String> allwindow = driver.getWindowHandles();
	    for (String lv : allwindow) {
	    	
	    	if(!lv.contentEquals(mainwindow))
	    	{
	    		driver.switchTo().window(lv);
	    	}
			
		}
	    
	    WebElement id = driver.findElement(By.id("search-criteria"));
	    Select s=new Select(id);
	    s.selectByVisibleText("Campaign Name");
	    
	    driver.findElement(By.id("search-input")).sendKeys("karthik coaching center");
	    
	    
	}


	}

