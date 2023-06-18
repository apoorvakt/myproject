package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement password;
	
	
	@FindBy(linkText="Login")
	WebElement loginbtn;
	//Actions
	
	public void usernmae(String username)
	{
		email.sendKeys(username);
	}
	public void password(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void login()
	{
		loginbtn.click();
	}
}
