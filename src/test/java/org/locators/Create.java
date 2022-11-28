package org.locators;

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
		@FindBy(name="firstname")
	
	}) private WebElement firstname;
	
	

	
	@FindAll({
		@FindBy(xpath="//input[@name='lastname']"),
		@FindBy(xpath="(//input[@type='text'])[3]"),
		@FindBy(name="lastname")
		
	}) private WebElement lastname;
	
	

	
	@FindAll({
		@FindBy(name="reg_email__"),
		@FindBy(xpath="(//input[@type=\"text\"])[4]"),
		@FindBy(xpath="//input[@name='reg_email__']")
		
	}) private WebElement phone;
	
	


	
	@FindAll({
		@FindBy(id="password_step_input"),
		@FindBy(xpath="(//input[@type='password'])[2]"),
		@FindBy(name="reg_passwd__"),
		@FindBy(xpath="//input[@id='password_step_input']"),
		@FindBy(xpath="//input[@name='reg_passwd__']")
		
	}) private WebElement password;
	
	@FindAll({
		@FindBy(xpath="//label[text()='Male']"),
		@FindBy(xpath="(//input[@name='sex'])[2]"),
		@FindBy(xpath="(//input[@type='radio'])[2]")
		
	}) private WebElement male;
	
	@FindAll({
		@FindBy(xpath="//label[text()='Female']"),
		@FindBy(xpath="(//input[@name='sex'])[1]"),
		@FindBy(xpath="(//input[@type='radio'])[1]")
		
	}) private WebElement female;
	
	@FindAll({
		@FindBy(xpath="//select[@title='Day']"),
		@FindBy(xpath="//select[@name='birthday_day']"),
		@FindBy(xpath="//select[@aria-label='Day']"),
		@FindBy(id="day"),
		@FindBy(xpath="//select[@id='day']")
		
	}) private WebElement day;

	@FindAll({
		@FindBy(xpath="//select[@aria-label='Month']"),
		@FindBy(xpath="//select[@name='birthday_month']"),
		@FindBy(xpath="//select[@title='Month']"),
		@FindBy(id="month"),
		@FindBy(xpath="//select[@id='month']")
		
	}) private WebElement month;
	

	@FindAll({
		@FindBy(xpath="//select[@name='birthday_year']"),
		@FindBy(xpath="//select[@aria-label='Year']"),
		@FindBy(xpath="//select[@title='Year']"),
		@FindBy(id="year"),
		@FindBy(xpath="//select[@id='year']")
		
	}) private WebElement year;
	
	@FindAll({
		@FindBy(xpath="(//input[@type='text'])[5]]"),
		@FindBy(xpath="(//input[@data-type='text'])[6]"),
		@FindBy(xpath="//input[@name='reg_email_confirmation__']"),
		@FindBy(xpath="//input[@id='u_2_j_/D']")
		
	}) private WebElement reemail;
	
	
	public WebElement getReemail() {
		return reemail;
	}


	public WebElement getFirstname() {
		return firstname;
	}


	public WebElement getLastname() {
		return lastname;
	}


	public WebElement getPhone() {
		return phone;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getMale() {
		return male;
	}


	public WebElement getFemale() {
		return female;
	}


	public WebElement getDay() {
		return day;
	}


	public WebElement getMonth() {
		return month;
	}


	public WebElement getYear() {
		return year;
	}


	public WebElement getButton() {
		return button;
	}

	@FindAll({
		@FindBy(xpath="(//a[@role='button'])[2]"),
		@FindBy(xpath="//a[text()='Create New Account']")
	}) private WebElement button;


	
	}


