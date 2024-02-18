package com.test;

import java.time.Duration;

import org.testng.annotations.Test;

import com.main.BaseClass;
import com.page.Constant;
import com.page.DropDownClass;
import com.page.PropertyReader;

public class TestDropDown extends BaseClass {

	@Test
	public void testDropDOwn() throws InterruptedException {
		DropDownClass dropDownClass = new DropDownClass(driver);
		PropertyReader propertyReader = new PropertyReader();
		driver.get(propertyReader.readProperty(Constant.URL));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		dropDownClass.selectDemo();
		Thread.sleep(2000);
		dropDownClass.selectedValue();
		Thread.sleep(2000);
	}
	
}
