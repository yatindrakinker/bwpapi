package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pojo.GetAudiencePojo;
import pojo.GetAudiencePojoData;
import resources.BaseClass;
import resources.TestDataBuild;
import resources.Utilities;

public class StepDefinitionCreateCampaign extends Utilities {

	TestDataBuild testDataBuild = new TestDataBuild();

	BaseClass baseClass;

	public StepDefinitionCreateCampaign(BaseClass baseClass) {
		this.baseClass = baseClass;
	}

//	User wants to target those persons who showed their interest in query that he searched for. Eg. => CRICKET

	@Given("Validate size of data in response is  not zero using {string} api")
	public void validate_size_of_data_in_response_is_not_zero_using(String interest) throws IOException {
		baseClass.requestSpec = given().spec(requestSpecification()).queryParam("query", interest)
				.queryParam("shop_id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "facebook").header("Authorization", BaseClass.token);
	}

	@Then("Validate size of data in response is not zero using {string} api")
	public void validate_size_of_data_in_response_is_not_zero_using_api(String resource) {

		if (resource.equals("getAudience")) {
			GetAudiencePojo getAudiencePojo = baseClass.response.as(GetAudiencePojo.class);
			List<GetAudiencePojoData> data = getAudiencePojo.getData();
			System.out.println("data.size() = " + data.size());
			if (data.size() > 0) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
	}

	@Given("User is successfully loggedin to the app and getAudience payload with query {string}")
	public void user_is_successfully_loggedin_to_the_app_and_get_audience_payload_with_query(String interest)
			throws IOException {
		baseClass.requestSpec = given().spec(requestSpecification()).queryParam("query", interest)
				.queryParam("shop_id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "facebook").header("Authorization", BaseClass.token);
	}

	@Then("Validate size of data in response is zero using {string} api")
	public void validate_size_of_data_in_response_is_zero_using_api(String resource) {

		if (resource.equals("getAudience")) {
			GetAudiencePojo getAudiencePojo = baseClass.response.as(GetAudiencePojo.class);
			List<GetAudiencePojoData> data = getAudiencePojo.getData();
			System.out.println("data.size() = " + data.size());
			if (data.size() == 0) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

	}

	@Given("User is successfully loggedin to the app and create campaign payload is given {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_is_successfully_loggedin_to_the_app_and_create_campaign_payload_is_given(String campaignName,
			String startDate, String endDate, String dailyBudget, String adText, String typeTragetAudience,
			String minAge, String maxAge, String gender) throws IOException {
		baseClass.requestSpec = given().spec(requestSpecification())
				.body(testDataBuild.createCampaignPayload(campaignName, startDate, endDate, dailyBudget, adText,
						typeTragetAudience, minAge, maxAge, gender))
				.queryParam("shop_id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "facebook").header("Authorization", BaseClass.token);
	}

	@Given("User is successfully loggedin to the app and create campaign payload is given {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_is_successfully_loggedin_to_the_app_and_create_campaign_payload_is_given(String campaignName,
			String startDate, String endDate, String dailyBudget, String adText, String typeTragetAudience,
			String minAge, String maxAge, String gender, String shopId) throws IOException {
		baseClass.requestSpec = given().spec(requestSpecification())
				.body(testDataBuild.createCampaignPayloadWithInvalidShopId(campaignName, startDate, endDate,
						dailyBudget, adText, typeTragetAudience, minAge, maxAge, gender, shopId))
				.queryParam("shop_id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "facebook").header("Authorization", BaseClass.token);
	}

	@Given("User is successfully loggedin to the app and form_token is missing and create campaign payload is given {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_is_successfully_loggedin_to_the_app_and_form_token_is_missing_and_create_campaign_payload_is_given(
			String campaignName, String startDate, String endDate, String dailyBudget, String adText,
			String typeTragetAudience, String minAge, String maxAge, String gender, String form_token)
			throws IOException {
		baseClass.requestSpec = given().spec(requestSpecification())
				.body(testDataBuild.createCampaignPayloadWithInvalidForm_Token(campaignName, startDate, endDate,
						dailyBudget, adText, minAge, maxAge, gender, StepDefinitionLogin.shopIdOnyx_cedTargetId, typeTragetAudience, form_token))
				.queryParam("shop_id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "facebook").header("Authorization", BaseClass.token);

	}

//	@Given("User is successfully loggedin to the app and and form_token is invalid create campaign payload is given {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
//	public void user_is_successfully_loggedin_to_the_app_and_and_form_token_is_invalid_create_campaign_payload_is_given(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

}
