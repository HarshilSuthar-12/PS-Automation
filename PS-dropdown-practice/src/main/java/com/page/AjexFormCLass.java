package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjexFormCLass {

	public AjexFormCLass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//li[@class='tree-branch']//a[@href='#'][normalize-space()='Input Forms']")
	private WebElement inputForm;
	
	@FindBy (xpath = "//li[@class='tree-branch']//ul//li//a[normalize-space()='Ajax Form Submit']")
	private WebElement formSubmit;
	
	@FindBy (id = "title")
	private WebElement titleEle;
	
	@FindBy (id = "description")
	private WebElement descriptionEle;
	
	@FindBy (id = "btn-submit")
	private WebElement btnSubmit;
	
	@FindBy (id = "submit-control")
	private WebElement submitControl;
	
	public void inputForm() {
		inputForm.click();
		System.out.println(inputForm.getText());
		formSubmit.click();
		System.out.println(formSubmit.getText());
	}
	
	public void fillInformation(String name, String commment) {
		titleEle.sendKeys(name);
		System.out.println("Name");
		descriptionEle.sendKeys(commment);
		System.out.println("Comment");
	}
	
	public void btnSubmit() {
		btnSubmit.click();
		System.out.println("Button");
		System.out.println(submitControl.getText());
	}
}
