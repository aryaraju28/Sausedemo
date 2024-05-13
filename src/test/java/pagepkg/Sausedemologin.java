package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sausedemologin {
	WebDriver driver;
	//locate login button
	@FindBy(id =  "login-button")
	WebElement loginbutton;
	//locate email id
	@FindBy(name = "user-name")
	WebElement emailIdfield;
	// paswd
	@FindBy(name = "password")
	WebElement pswd;
	public Sausedemologin (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//click login button
	public void clickLoginBtn() {
		loginbutton.click();
	}
	
	public void setvalues(String UN,String PWD) {
		emailIdfield.sendKeys(UN);
		pswd.sendKeys(PWD);
		
	}
	
}
