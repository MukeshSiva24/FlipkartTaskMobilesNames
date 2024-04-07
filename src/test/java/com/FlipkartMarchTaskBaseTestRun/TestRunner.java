package com.FlipkartMarchTaskBaseTestRun;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= "C:\\Users\\MUKESH\\eclipse-workspace\\com.FlipkartMarchTask\\src\\test\\resources\\MobileName.feature",
		glue = "com.FlipkartMarchTaskStep",
		tags = "@Smoke",
		plugin = {"html:target/index.html", "json:target/Report.json"},
		dryRun = false,
		monochrome = true
		)

public class TestRunner {
	
	

}
