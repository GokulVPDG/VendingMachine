package com.knila.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.knila.utility.SeleniumCommands;

public class LoginPage extends SeleniumCommands {

	
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement txtUserName;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement txtUserPass;
	
	@FindBy(xpath = "//li[@id='Isolation Ward']")
	private WebElement btnLocation;
	
	@FindBy(xpath = "//input[@id='loginButton']")
	private WebElement btnLogin;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(WebElement txtUserName) {
		this.txtUserName = txtUserName;
	}

	public WebElement getTxtUserPass() {
		return txtUserPass;
	}

	public void setTxtUserPass(WebElement txtUserPass) {
		this.txtUserPass = txtUserPass;
	}

	public WebElement getBtnLocation() {
		return btnLocation;
	}

	public void setBtnLocation(WebElement btnLocation) {
		this.btnLocation = btnLocation;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(WebElement btnLogin) {
		this.btnLogin = btnLogin;
	}
	
	
public LoginPage() {
	PageFactory.initElements(driver, this);
}


	




	






	
}
