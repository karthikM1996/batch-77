package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	WebDriver driver;
	public loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	public WebElement UN;
	
	@FindBy(id = "inputPassword")
	public WebElement PSW;
	
	public WebElement getPSW() {
		return PSW;
	}

	@FindBy(css = "button[type='submit']")
	public WebElement loginbtn;

	public WebElement getUN() {
		return UN;
	}


	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
}
