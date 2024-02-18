package com.test;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.main.BaseClass;
import com.page.AjexFormCLass;
import com.page.Constant;
import com.page.DropDownClass;
import com.page.PropertyReader;

public class TestDropDown extends BaseClass {

	@Test
	public void testDropDOwn() throws InterruptedException {
		DropDownClass dropDownClass = new DropDownClass(driver);
		AjexFormCLass ajexFormCLass = new AjexFormCLass(driver);
		PropertyReader propertyReader = new PropertyReader();
		driver.get(propertyReader.readProperty(Constant.URL));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		dropDownClass.selectDemo();
		Thread.sleep(1000);
		dropDownClass.selectedValue();
		Thread.sleep(1000);
		ajexFormCLass.inputForm();
		Thread.sleep(1000);
		String name = propertyReader.readProperty(Constant.NAME);
		String comment = propertyReader.readProperty(Constant.DESCRIPTION);
		ajexFormCLass.fillInformation(name, comment);
		Thread.sleep(1000);
		ajexFormCLass.btnSubmit();
		Thread.sleep(5000);
	}
	
}
