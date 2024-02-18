package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownClass {

	public DropDownClass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "select-demo")
	private WebElement selectdemo;
	
	@FindBy (className = "selected-value")
	private WebElement selectedvalue;
	
	public void selectDemo() {
		Select select = new Select(selectdemo);
		select.selectByValue("Sunday");
		System.out.println("Sunday is clicked!!!");
	}
	
	public void selectedValue() {
		System.out.println("Selected Value: " + selectedvalue.getText());
	}
	
}
