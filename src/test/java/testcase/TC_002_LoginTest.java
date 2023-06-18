package testcase;

import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.LoginPage;
import testbase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	
	@Test
	public void test_login()
	{
		logger.info("Login stated");
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("cliked on account button");
		hp.clickLogin();
		logger.info("cliked on login button");
		LoginPage lp=new LoginPage(driver);
		lp.usernmae(rb.getString("username"));
		lp.password(rb.getString("password"));
		lp.login();
	}
}