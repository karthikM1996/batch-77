package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement Createcampbtn;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement Createcampsubbtn;
	
	@FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--error']")
	private WebElement Tostmsg;
	
	@FindBy(xpath = "//button[contains(@class,'Toastify__close-button')]")
	private WebElement clostostmsg;


	@FindBy(className =  "user-icon")
	private WebElement Useicon;
	
	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement Logoutbtn;
	

	public WebElement getCreatecampbtn() {
		return Createcampbtn;
	}

	public WebElement getCreatecampsubbtn() {
		return Createcampsubbtn;
	}

	public WebElement getTostmsg() {
		return Tostmsg;
	}


	public WebElement getClostostmsg() {
		return clostostmsg;
	}


	public WebElement getUseicon() {
		return Useicon;
	}

	public WebElement getLogoutbtn() {
		return Logoutbtn;
	}

	
	
	
}
