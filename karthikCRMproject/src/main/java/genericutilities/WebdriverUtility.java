package genericutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebdriverUtility {

	public WebElement tomouseover(WebDriver driver,WebElement target)
	{
		Actions act=new Actions(driver);
		act.moveToElement(target).perform();
		return target;
		
	}
}
