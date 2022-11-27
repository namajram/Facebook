package org.loc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Help.BaseClass;

public class Create extends BaseClass {
	
	public Create() {
		PageFactory.initElements(d, this);
	}
	
	@FindAll({
		@FindBy(xpath="//input[@name='firstname']"),
		@FindBy(xpath="(//input[@type='text'])[2]"),
		@FindBy(xpath="(//input[@placeholder='First name'])")
	
	}) private WebElement first;
	
	

	
	@FindAll({
		@FindBy(xpath="//input[@name='lastname']"),
		@FindBy(xpath="(//input[@type='text'])[3]")
		
	}) private WebElement last;
	
	

	
	@FindAll({
		@FindBy(name="reg_email__"),
		@FindBy(xpath="(//input[@type='text'])[4]")
		
	}) private WebElement phone;
	
	


	public WebElement getFirst() {
		return first;
	}




	public WebElement getLast() {
		return last;
	}




	public WebElement getPhone() {
		return phone;
	}




	public WebElement getPasswd() {
		return passwd;
	}




	public WebElement getButton() {
		return button;
	}

	@FindAll({
		@FindBy(id="password_step_input"),
		@FindBy(xpath="(//input[@type='password'])[2]")
		
	}) private WebElement passwd;
	
	
	

	@FindAll({
		@FindBy(xpath="(//a[@role='button'])[2]"),
		@FindBy(xpath="//a[text()='Create New Account']")
	}) private WebElement button;


	
	}


