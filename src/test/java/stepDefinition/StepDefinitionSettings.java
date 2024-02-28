package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.cucumber.java.en.Given;
import resources.BaseClass;
import resources.TestDataBuild;
import resources.Utilities;

public class StepDefinitionSettings extends Utilities {

	TestDataBuild testDataBuild = new TestDataBuild();;
	BaseClass baseClassObj;

	public StepDefinitionSettings(BaseClass baseClassObj) {
		this.baseClassObj = baseClassObj;
	}

	@Given("User is loggedin to the Onyx Meta and is on Settings page")
	public void user_is_loggedin_to_the_onyx_meta_and_is_on_settings_page() throws IOException {
		baseClassObj.requestSpec = given().spec(requestSpecification())
				.queryParam("target_marketplace", "eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9")
				.queryParam("shop_id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "meta").header("Authorization", BaseClass.token);
		holdScript(3);
	}

	@Given("User is loggedin to the Onyx Meta and is on Settings page and shopId")
	public void user_is_loggedin_to_the_onyx_meta_and_is_on_settings_page_and_shop_id() throws IOException {

		baseClassObj.requestSpec = given().spec(requestSpecification())
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "meta").header("Authorization", BaseClass.token)
				.body(testDataBuild.getConfigPayload(StepDefinitionLogin.shopIdFacebook_cedSourceId));
		holdScript(3);

	}

	@Given("User is loggedin to the Onyx Meta and is on accounts section in Settings page with email {string} old_password {string} new_password {string} confirm_password {string}")
	public void user_is_loggedin_to_the_onyx_meta_and_is_on_accounts_section_in_settings_page_with_email_old_password_new_password_confirm_password(
			String email, String old_password, String new_password, String confirm_password) throws IOException {
		baseClassObj.requestSpec = given().spec(requestSpecification())
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "meta").header("Authorization", BaseClass.token)
				.body(testDataBuild.passwordResetPayload(email, old_password, new_password, confirm_password));
		holdScript(3);

	}

	@Given("User is loggedin to the Onyx Meta and is on accounts section in Settings page with pixelId {string}")
	public void user_is_loggedin_to_the_onyx_meta_and_is_on_accounts_section_in_settings_page_with_pixel_id(
			String pixelId) throws IOException {
		baseClassObj.requestSpec = given().spec(requestSpecification())
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "meta").header("Authorization", BaseClass.token)
				.body(testDataBuild.updatePixelPayload(StepDefinitionLogin.shopIdOnyx_cedTargetId, pixelId));
		holdScript(3);

	}

	@Given("User is loggedin to the Onyx Meta and is on accounts section in Settings page with shopId {string}")
	public void user_is_loggedin_to_the_onyx_meta_and_is_on_accounts_section_in_settings_page_with_shop_id(
			String shopId) throws IOException {
		baseClassObj.requestSpec = given().spec(requestSpecification())
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "meta").header("Authorization", BaseClass.token)
				.body(testDataBuild.updatePixelPayload(shopId, StepDefinitionProductList.pixelId));
		holdScript(1);

	}

	@Given("User is loggedin to the Onyx Meta and is on accounts section in Settings page")
	public void user_is_loggedin_to_the_onyx_meta_and_is_on_accounts_section_in_settings_page() throws IOException {
		baseClassObj.requestSpec = given().spec(requestSpecification())
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "meta").header("Authorization", BaseClass.token)
				.body(testDataBuild.updatePixelPayload(StepDefinitionLogin.shopIdOnyx_cedTargetId,
						StepDefinitionProductList.pixelId));
		
	}

	@Given("User is loggedin to the Onyx Meta and is on general details in Settings page with brandName {string}")
	public void user_is_loggedin_to_the_onyx_meta_and_is_on_general_details_in_settings_page_with_brand_name(
			String brandname) throws Throwable {
		baseClassObj.requestSpec = given().spec(requestSpecification())
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "meta").header("Authorization", BaseClass.token)
				.body(testDataBuild.updateBrandNamePayload(StepDefinitionLogin.shopIdFacebook_cedSourceId, brandname));
	}

}
