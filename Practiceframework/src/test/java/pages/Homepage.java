package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Basetest;


public class Homepage extends Basetest{

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	public WebElement myaccount;

	@FindBy(linkText = "Register")

	public WebElement register;

	@FindBy(linkText="Login")

	public WebElement login;
	
	@FindBy(xpath="//h1[contains(text(),'Register Account')]")
	WebElement RegisterAccount;
	
	@FindBy(xpath="//h2[contains(text(),'New Customer')]")
	WebElement Newcustomer;

	public Homepage() {

		PageFactory.initElements(driver, this);
	}

	public void clickonmyaccount() {
		myaccount.click();
		
	}
	
	public boolean verifymyaccountlabel() {
		return myaccount.isDisplayed();

	}

	public Registerpage clickonregister() {

		register.click();

		return new Registerpage();

	}

	public boolean verifyregisterbutton() {

		
		return register.isDisplayed();
	}

	public boolean loginbuttonlabel() {
		return login.isDisplayed();

	}

	
	
	public Loginpage clickonlogin() {

		login.click();

		return new Loginpage();

	}
	 public String validatingregisterpage() {
	  return RegisterAccount.getText();
			 
		 
	 }

	 public String validatingloginpage() {
		  return Newcustomer.getText();
	 
}}
	


