package com.test;


import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;



import org.loc.Login;

import com.Help.BaseClass;

public class Authenticate extends BaseClass {
	
	@Test(groups= {"smoke"})
	private void when_invalid_password_valid_Username_throwerror() throws  Exception  {
		chromeBrowser();
		urlLaunch("https://www.facebook.com/");
    Login l=new Login();
    Thread.sleep(3000);
    passValues(l.getUser(),readExcel("Details", "Login", 2, 0) );
    passValues(l.getPass(), readExcel("Details", "Login", 2, 1));
    click1(l.getlogin());
   
    assertTrue(d.getCurrentUrl().contains("privacy_mutation_token"),"valid password" );
    

	}
	
}
