package com.FlipkartMarchTaskStep;

import com.FlipkartMarchTaskBase.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	BaseClass base=BaseClass.getInstance();
	
	
	@Before
	public void method() {
		base.browserLaunch();
		
	}
	
	@After
	public void methods() {
		base.browserClose();
	}

}
