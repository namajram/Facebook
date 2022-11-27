package org.loc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Help.BaseClass;

public class Login extends BaseClass {
	public Login() {
		PageFactory.initElements(d, this);
	}
@FindAll({
	@FindBy(id="email"),
	@FindBy(name="email")
}) private WebElement user;

public WebElement getUser() {
	return user;
}


@FindAll({
	@FindBy(id="pass"),
	@FindBy(name="pass")
}) private WebElement pass;

public WebElement getPass() {
	return pass;
}
@FindAll({
	@FindBy(xpath="//button[@type='submit']"),
	@FindBy(name="login")
}) private WebElement login;

public WebElement getlogin() {
	return login;
}
@FindAll({
	@FindBy(name="username"),
	@FindBy(xpath="//input[@name='username']")
})private  WebElement username;

@FindAll({
	@FindBy(xpath="(//input[@type='text'])[2]"),
	@FindBy(id="full_name")
	
})private  WebElement fullname;
@FindAll({
	@FindBy(xpath="(//input[@type='text'])[3]"),
	@FindBy(id="email_add")
})private  WebElement email;
public static WebDriver getD() {
	return d;
}
public WebElement getUsername() {
	return username;
}
public WebElement getFullname() {
	return fullname;
}
public WebElement getEmail() {
	return email;
}


}
