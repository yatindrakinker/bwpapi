package stepDefinition;
import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import resources.BaseClass;
import resources.Utilities;

/*
 * Hooks are used in cucumber to run a particular a particular test case.
 * To run that test case we need to also execute those testcases that are required.
 * To run standalone test case we use tags to run specific or groups of test cases.
 * For example:- To hit any api user must have a authorization token that is generated when user successfully loggedin to the app.
 * So to successfully hit any api token is mandatory hence before any api I have loggedIn and the used token to move further.
 
  */

public class Hooks extends Utilities{
	
	BaseClass baseClassObj;

	public Hooks(BaseClass baseClassObj) {
		this.baseClassObj = baseClassObj;
	}
	
	
	@Before("@GetAll")
	public void loginUser() throws IOException {
//		need token to move further
//		1=> Create object of class to access the method of StepDefinitionLogin class.
		StepDefinitionLogin sdl = new StepDefinitionLogin(baseClassObj);
		sdl.credentials_and(getGlobalValue("email"), getGlobalValue("password"));
		sdl.user_calls_with_post_http_request("loginAPI", "post");
		if(BaseClass.token.equals("")) {
			sdl.in_response_body_is("success", "true");
		}
		sdl.get_all_data_using_api("overAllAppAll");
	}
	
	@Before("@CreateWebhook")
	public void beforeCreateWebHookScenario() throws IOException {
		StepDefinitionLogin sdl = new StepDefinitionLogin(baseClassObj);
		sdl.credentials_and(getGlobalValue("email"), getGlobalValue("password"));
		sdl.user_calls_with_post_http_request("loginAPI", "post");
		if(BaseClass.token.equals("")) {
			sdl.in_response_body_is("success", "true");
		}
		sdl.get_all_data_using_api("overAllAppAll");
		
	}
	
//	User calls getAccountPixelsAPI to get all pixel ID's
//	Before this the user must login
	
	@Before("@getAccountPixelsAPI")
	public void runGetAccountPixelsAPIScenario() throws IOException {
		loginUser();
	}
	
	@After("@getAccountPixelsAPI")
	public void validatePixelData() {
		StepDefinitionLogin sdl = new StepDefinitionLogin(baseClassObj);
		sdl.the_api_call_got_success_with_status_code(200);
		StepDefinitionProductList sdpl= new StepDefinitionProductList(baseClassObj);
		sdpl.validate_data_using_resource("getAccountPixels");
	}
	

	@Before("@getConfigAPI")
	public void runGetConfigAPI() throws IOException {
		loginUser();
	}
	
	@After("@getConfigAPI")
	public void validateGetConfigAPIData() {
		StepDefinitionLogin sdl = new StepDefinitionLogin(baseClassObj);
		sdl.the_api_call_got_success_with_status_code(200);
		StepDefinitionProductList sdpl= new StepDefinitionProductList(baseClassObj);
		sdpl.validate_data_using_resource("getConfig");
	}
	
	
//	User calls getDisconnectedAccountAPI to get all disconnected accounts if there any
//	Before this the user must login to the app
	
	@Before("@getDisconnectedAccountAPI")
	public void runGetDisconnectedAccountAPI() throws IOException {
		loginUser();
	}
	
	@After("@getDisconnectedAccountAPI")
	public void validateDisconnectedAccountAPI() {
		StepDefinitionLogin sdl = new StepDefinitionLogin(baseClassObj);
		sdl.the_api_call_got_success_with_status_code(200);
		StepDefinitionProductList sdpl= new StepDefinitionProductList(baseClassObj);
		sdpl.validate_data_using_resource("getDisconnectedAccount");
	}
	
//	User calls resetpasswordAPI to change his password
//	Before this the user must login to the app
	
	@Before("@resetpasswordAPI")
	public void runResetPasswordAPI() throws IOException {
		loginUser();
	}
	
//	User calls updatePixelAPI to update his account pixel
//	Before this the user must login to the app
	
	@Before("@updateValidPixel")
	public void runUpdatePixelAPI() throws IOException {
		StepDefinitionLogin sdl = new StepDefinitionLogin(baseClassObj);
		StepDefinitionProductList sdpl= new StepDefinitionProductList(baseClassObj);
		StepDefinitionSettings sds = new StepDefinitionSettings(baseClassObj);
		loginUser();
		sds.user_is_loggedin_to_the_onyx_meta_and_is_on_settings_page();
		sdl.user_calls_with_post_http_request("getAccountPixels", "get");
		sdpl.validate_data_using_resource("getAccountPixels");
	}
	
	@After("@updateValidPixel")
	public void validateUpdateValidPixelResponse() throws IOException {
		StepDefinitionLogin sdl = new StepDefinitionLogin(baseClassObj);
		sdl.the_api_call_got_success_with_status_code(200);
		sdl.in_response_body_is("success", "true");
	}
	
	@Before("@createCustomAudience")
	public void runCreateCustomaudience() throws IOException {
		loginUser();
	}
	
	@Before("@ChangeBrandName")
	public void runChangeBrandName() throws IOException {
		loginUser();
	}
	
	@Before("@getConfig")
	public void runGetConfig() throws IOException {
		loginUser();
	}
}
