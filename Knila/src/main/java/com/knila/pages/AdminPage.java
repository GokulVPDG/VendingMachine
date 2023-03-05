package com.knila.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.knila.utility.SeleniumCommands;

public class AdminPage extends SeleniumCommands {
	
	@FindBy(xpath = "(//a[@class='btn btn-default btn-lg button app big align-self-center'])[3]")
	private WebElement listbox;

	public WebElement getListbox() {
		return listbox;
	}

	public void setListbox(WebElement listbox) {
		this.listbox = listbox;
	}
	

	public AdminPage() {
		PageFactory.initElements(driver, this);
	}

	
	

}
