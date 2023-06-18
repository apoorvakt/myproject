package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.LoginPage;
import testbase.BaseClass;
import utility.DataProviders;



public class TC_003_LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)

	public void test_LoginDDT(String email, String pwd, String exp) {
		logger.info(" Starting TC_003_LoginDataDrivenTest ");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.usernmae(email);
			lp.password(pwd);
			lp.login();

		}
		
		catch (Exception e) {
			Assert.fail();
		}
	}}

	


