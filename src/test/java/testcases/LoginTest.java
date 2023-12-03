package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.learnautomation.base.BaseClass;
import com.learnautomation.dataProvider.DataProviders;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;

public class LoginTest extends BaseClass
{
	@Test(dataProvider = "TestData",dataProviderClass = DataProviders.class)
	public void validLogin(String uname,String pass)
	{
		LoginPage login=new LoginPage(driver);
		
		login.loginOption();
	
		HomePage homePage=login.loginToApplication(uname,pass);
		
		Assert.assertTrue(homePage.isManageDisplayed());
		
		homePage.signOutFromApplication();
	
		Assert.assertTrue(login.isSignInDisplayed());
	}
	
	
}
