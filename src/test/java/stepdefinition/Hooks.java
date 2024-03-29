package stepdefinition;

import java.io.IOException;
import io.cucumber.java.Scenario;
import generics.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;

public class Hooks {

	TestContextSetup testcontextsetup;
	
	public Hooks(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
	}
	
	@After
	public void TearDown() throws IOException {
		testcontextsetup.base.WebDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario){
		if(scenario.isFailed()) {
			testcontextsetup.util.GetScreenShot(scenario.getName());
		}
	}
	
}
