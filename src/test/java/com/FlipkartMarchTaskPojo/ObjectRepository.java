package com.FlipkartMarchTaskPojo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FlipkartMarchTaskBase.BaseClass;


public class ObjectRepository {
	
BaseClass base=BaseClass.getInstance();
	
	public ObjectRepository() {
		PageFactory.initElements(base.driver, this);
	}
	
	
	@FindBy(xpath = "//input[@placeholder=\"Search for Products, Brands and More\"]")
	private WebElement nameEnter;
	
	@FindBy(xpath = "//span[@class=\"_1lRcqv\"]/parent::div/parent::div/div[@class=\"_4rR01T\"]")
	private List<WebElement> takeMobileNames;

	public BaseClass getBase() {
		return base;
	}

	public WebElement getNameEnter() {
		return nameEnter;
	}

	public List<WebElement> getTakeMobileNames() {
		return takeMobileNames;
	}
	
	

}
