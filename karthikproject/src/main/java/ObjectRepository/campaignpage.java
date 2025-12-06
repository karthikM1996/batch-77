package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class campaignpage {

	WebDriver driver;
	public campaignpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignName")
	private WebElement campnametf;
	
	@FindBy(name = "campaignStatus")
	private WebElement campstatusTF;
	
	@FindBy(name = "targetSize")
	private WebElement targetTF;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement dateTF;
	
	@FindBy(xpath =  "//button[text()='Create Campaign']")
	private WebElement submitbtn;

	
	public WebElement getSubmitbtn() {
		return submitbtn;
	}	

	public WebElement getCampnametf() {
		return campnametf;
	}

	public WebElement getCampstatusTF() {
		return campstatusTF;
	}

	public WebElement getTargetTF() {
		return targetTF;
	}

	public WebElement getDateTF() {
		return dateTF;
	}
}
