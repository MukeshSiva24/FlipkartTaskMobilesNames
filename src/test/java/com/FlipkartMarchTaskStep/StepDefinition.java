package com.FlipkartMarchTaskStep;

import java.io.IOException;

import com.FlipkartMarchTaskBase.BaseClass;
import com.FlipkartMarchTaskPojo.ObjectRepository;

import io.cucumber.java.en.When;

public class StepDefinition {
	
	BaseClass base=BaseClass.getInstance();
	ObjectRepository locate= new ObjectRepository();
	
	
	

	@When("Launch the Application {string}")
	public void launch_the_application(String url) {
	   
	  base.launchApplication(url);
	}

	@When("Click the SearchBar")
	public void click_the_search_bar() {
		base.sendAndEnter(locate.getNameEnter(), "new Mobile 5g", 0);
		
	    
	}

	@When("Enter Mobile Names in Excel")
	public void enter_mobile_names_in_excel() throws IOException {
	    base.multiExcelOutput("C:\\Users\\MUKESH\\eclipse-workspace\\com.FlipkartMarchTask\\target\\Mukesh.xls", locate.getTakeMobileNames());
	}


}
