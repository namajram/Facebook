package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.locators.Create;
import org.locators.Forgotten;
import org.locators.Login;

import com.Help.BaseClass;

public class Authenticate extends BaseClass {

	@Test(groups = { "login" })
	private void when_invalid_password_valid_Username_throwerror() throws Exception {
		chromeBrowser();
		urlLaunch("https://www.facebook.com/");
		Login l = new Login();

		passValues(l.getUser(), readExcel("Details", "Login", 2, 0));
		passValues(l.getPass(), readExcel("Details", "Login", 2, 1));
		click(l.getlogin());
		Thread.sleep(3000);
		SoftAssert s = new SoftAssert();
		s.assertTrue(d.getCurrentUrl().contains("privacy_mutation_token"), "valid password");

	}

	@Test(groups = { "login" })
	private void user_enters__invalid_password_invalid_Username_throwerror() throws Exception {
		edgeBrower();
		urlLaunch("https://www.facebook.com/");
		Login l = new Login();

		passValues(l.getUser(), "8754612");
		passValues(l.getPass(), readExcel("Details", "Login", 1, 1));
		click(l.getlogin());
		Thread.sleep(3000);
		SoftAssert s = new SoftAssert();
		s.assertTrue(d.getCurrentUrl().contains("privacy_mutation_token"), "valid password");
	}

	@Test(groups = { "login" })
	private void user_enters__empty_password_and_Username() throws InterruptedException {
		chromeBrowser();
		urlLaunch("https://www.facebook.com/");
		Login l = new Login();

		click(l.getlogin());
		Thread.sleep(3000);
		SoftAssert s = new SoftAssert();
		s.assertTrue(d.getCurrentUrl().contains("privacy_mutation_token"), "valid password");
	}

	@Test(groups = { "forgot" })
	private void user_enters__forgotpassword_invalid_email() throws Exception {
		chromeBrowser();
		urlLaunch("https://www.facebook.com/");
		Forgotten f = new Forgotten();

		click(f.getForgot());
		passValues(f.getEamil(), readExcel("Details", "Login", 1, 1));
		click(f.getEamilbutton());
		Thread.sleep(3000);
		SoftAssert s = new SoftAssert();
		s.assertTrue(d.getCurrentUrl().contains("login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0"),
				"valid password");
	}

	@Test(groups = { "forgot" })
	private void user_enters__forgotpassword_invalid_phone() throws Exception {
		edgeBrower();
		urlLaunch("https://www.facebook.com/");
		Forgotten f = new Forgotten();

		click(f.getForgot());
		passValues(f.getEamil(), readExcel("Details", "Login", 2, 4));
		click(f.getEamilbutton());
		Thread.sleep(2000);
		SoftAssert s = new SoftAssert();
		s.assertTrue(d.getCurrentUrl().contains("login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0"),
				"valid password");
	}

	@Test(groups = { "create" })
	private void user__createnewaccount() throws Exception {
		chromeBrowser();
		urlLaunch("https://www.facebook.com/");
		Create c = new Create();

		click(c.getButton());
		Thread.sleep(2000);
		passValues(c.getFirstname(), readExcel("Details", "Login", 1, 2));
		passValues(c.getLastname(), readExcel("Details", "Login", 2, 2));
		passValues(c.getPassword(), readExcel("Details", "Login", 2, 1));
		passValues(c.getPhone(), readExcel("Details", "Login", 2, 4));
		selectByValue(c.getDay(), "24");
		selectByValue(c.getMonth(), "7");
		selectByValue(c.getYear(), "1996");
		click(c.getMale());

	}

}
