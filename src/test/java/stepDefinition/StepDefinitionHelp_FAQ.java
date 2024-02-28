package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.cucumber.java.en.Given;
import resources.BaseClass;
import resources.TestDataBuild;
import resources.Utilities;

public class StepDefinitionHelp_FAQ extends Utilities{
	
	TestDataBuild testDataBuild = new TestDataBuild();
	
	BaseClass baseClass;
	public StepDefinitionHelp_FAQ(BaseClass baseClass) {
		this.baseClass = baseClass;
	}
	
	@Given("User is loggedin to the Onyx Meta and is on Help or FAQ page")
	public void user_is_loggedin_to_the_onyx_meta_and_is_on_help_or_faq_page() throws IOException {
	    baseClass.requestSpec = given().spec(requestSpecification()).body(testDataBuild.allSearchPayload());
	}

	@Given("User is loggedin to the Onyx Meta and is on Help or FAQ page and searches for {string}")
	public void user_is_loggedin_to_the_onyx_meta_and_is_on_help_or_faq_page_and_searches_for(String keyword) throws IOException {
	    baseClass.requestSpec = given().spec(requestSpecification()).body(testDataBuild.querySearchPayload(keyword));
	}


}
