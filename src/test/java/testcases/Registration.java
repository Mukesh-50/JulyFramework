package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataProvider.DataProviders;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.RegistrationPage;

public class Registration extends BaseClass{
	
	@Test(dataProvider = "TestDataForRegistration",dataProviderClass = DataProviders.class)
	public void createUser(String name,String email,String pass,String interest,String gender,String state,String hobbies) 
	{
		
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.loginOption();
		
		loginPage.clickOnSignInLink();
		
		RegistrationPage register=new RegistrationPage(driver);
		
		register.registerUser(name, email, pass, interest, gender, state, hobbies);
		
		boolean status=register.signUpMsg();
		
		Assert.assertTrue(status,"Registration Failed");
		
	}

}
