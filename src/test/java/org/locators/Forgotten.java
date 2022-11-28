package org.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Help.BaseClass;

public class Forgotten extends BaseClass{
	
	public Forgotten() {
		PageFactory.initElements(d, this);
	}
	
	@FindAll({
		@FindBy (xpath="//a[text()='Forgotten password?']"),
		@FindBy(partialLinkText="https://www.facebook.com/recover/initiate/?privacy_mutation_token=ey")
		
	})private WebElement forgot;
	
	@FindAll({
		@FindBy (name="email"),
		@FindBy(xpath="//input[@type='text']")
		
	})private WebElement eamil;
	
	@FindAll({
		@FindBy (xpath="//button[@type='submit']"),
		@FindBy(xpath="//button[text()='Search']")
		
	})private WebElement eamilbutton;

	public WebElement getForgot() {
		return forgot;
	}

	public WebElement getEamil() {
		return eamil;
	}

	public WebElement getEamilbutton() {
		return eamilbutton;
	}
	
	

}
