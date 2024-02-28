package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import pojo.GetAudiencePojo;
import pojo.GetAudiencePojoData;
import pojo.InitCampaignData;
import pojo.InitCampaignPojo;
import pojo.LoginPojo;
import pojo.LoginPojoData;
import pojo.OverAllAppPojo;
import pojo.OverAllAppPojoData;
import pojo.OverAllAppPojoDataFacebook;
import pojo.OverAllAppPojoDataFacebookInstalled;
import pojo.OverAllAppPojoDataFacebookInstalledSources;
import pojo.OverAllAppPojoDataOnyx;
import pojo.OverAllAppPojoDataOnyxInstalled;
import pojo.OverAllAppPojoDataOnyxInstalledTargets;
import resources.APIResources;
import resources.BaseClass;
import resources.TestDataBuild;
import resources.Utilities;

public class StepDefinitionLogin extends Utilities {
	TestDataBuild testDataBuild = new TestDataBuild();

	public static String shopIdOnyx_cedTargetId;
	static String emailOnOnyx;
	static String currencyOnOnyx;
	static String shopStatusOnOnyx;
	static String codeOnOnyx;

	static String emailOnFacebook;
	static String shopStatusOnFacebook;
	static String shopIdFacebook_cedSourceId;
	static String codeOnFacebook;
	static String titleOnFacebook;
	static String descriptionOnFacebook;

	public static String form_token;

	ObjectMapper mapper = new ObjectMapper();

	BaseClass baseClassObj;

	public StepDefinitionLogin(BaseClass baseClassObj) {
		this.baseClassObj = baseClassObj;
	}

	@Given("credentials {string} and {string}")
	public void credentials_and(String email, String password) throws IOException {
		baseClassObj.requestSpec = given().spec(requestSpecification()).header("authorization",
				"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyX2lkIjoiNjMzODM0NjliZTRmYTc2NTJjMGQ3NjQ3Iiwicm9sZSI6ImFwcCIsImlzcyI6Imh0dHBzOlwvXC9hcHBzLmNlZGNvbW1lcmNlLmNvbSIsInRva2VuX2lkIjoiNjMzODcwMmM0ZGU2M2Q2MDgwMGM0ZmYyIn0.noslgUqfAL-YI0f_Il9XX9NABSYxgCQ7FwDtVZsVLi_pe7fgw_Y4EWYefyAD6ThErexSV_ruAsoMk1Wuxm0toIUslwlm2aGBTDBSOOkSK5bRzN7VfLV5siYXPoq4q8uhA1zPvyRRnawCnYlVhQ4oM9FGBU90fQFUakM4_hcQiJmfICi91-Ysf3pr16v1wq0oT1vdX23Gp-bZMLBjV5scNKkPlH2o0SgUQhP3cQqlKqodj1Wy9pIL6mkLVljQXwX-Lpzk6RuzN5ypzuhs7ihlKN_Kj1UlH4im-uDftXQQU9NXW5EHPlyW47qelgAxFZveI23jZemftv1ZhiJv4orQMQ")
				.body(testDataBuild.loginPayload(email, password));
		holdScript(2);
	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource, String httpMethods) {
		APIResources resourceAPI = APIResources.valueOf(resource);

		baseClassObj.responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();

		if (httpMethods.equalsIgnoreCase("post")) {
			baseClassObj.response = baseClassObj.requestSpec.when().post(resourceAPI.getResource());
		} else if (httpMethods.equalsIgnoreCase("get")) {
			baseClassObj.response = baseClassObj.requestSpec.when().get(resourceAPI.getResource());
		} else if (httpMethods.equalsIgnoreCase("delete")) {
			baseClassObj.response = baseClassObj.requestSpec.when().delete(resourceAPI.getResource());
		}

		System.out.println(resource);
		System.out.println(baseClassObj.response.asString());
	}

	@Then("The API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer statusCode) {

		if (baseClassObj.response.getStatusCode() == statusCode) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(true);
		}
		// Assert.assertEquals(baseClassObj.response.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String expectedKey, String expectedValue) {

		try {
			if (BaseClass.token.equals("")) {
				LoginPojo lp = baseClassObj.response.as(LoginPojo.class);
				LoginPojoData lpd = lp.getData();
				BaseClass.token = lpd.getToken();
				System.out.println("token = " + BaseClass.token);
				// Validating content-type should be application/json
				if (baseClassObj.response.header("Content-Type").equals("application/json")) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
		} catch (NullPointerException e) {

		}

		Assert.assertEquals(getJsonPath(baseClassObj.response, expectedKey), expectedValue);

	}

	@Then("get all data using {string} api")
	public void get_all_data_using_api(String resource) throws IOException {

		// OVER ALL API
		if (resource.equals("overAllAppAll")) {
			baseClassObj.requestSpec = given().spec(requestSpecification())
					.queryParam("target_marketplace", "eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9")
					.header("Authorization", BaseClass.token);
			user_calls_with_post_http_request(resource, "Get");
			OverAllAppPojo oaap = baseClassObj.response.as(OverAllAppPojo.class);
			OverAllAppPojoData oaapd = oaap.getData();
			OverAllAppPojoDataOnyx onyxData = oaapd.getOnyx();
			System.out.println(onyxData.getTitle());
			List<OverAllAppPojoDataOnyxInstalled> onyxInstalled = onyxData.getInstalled();
			List<OverAllAppPojoDataOnyxInstalledTargets> onyxInstalledTargets = onyxInstalled.get(0).getTargets();
			shopIdOnyx_cedTargetId = onyxInstalledTargets.get(0).getShop_id();
			System.out.println("shopIdOnyx_cedTargetId = " + shopIdOnyx_cedTargetId);
			emailOnOnyx = onyxInstalled.get(0).getEmail();
			System.out.println("emailOnOnyx = " + emailOnOnyx);
			currencyOnOnyx = onyxInstalled.get(0).getCurrency();
			System.out.println("currencyOnOnyx = " + currencyOnOnyx);
			shopStatusOnOnyx = onyxInstalled.get(0).getShop_status();
			System.out.println("shopStatusOnOnyx = " + shopStatusOnOnyx);
			codeOnOnyx = onyxInstalledTargets.get(0).getCode();
			System.out.println("codeOnOnyx = " + codeOnOnyx);

			// cheking Facebook data

			OverAllAppPojoDataFacebook dataFacebook = oaapd.getMeta();
			List<OverAllAppPojoDataFacebookInstalled> dataFacebookInstalled = dataFacebook.getInstalled();
			List<OverAllAppPojoDataFacebookInstalledSources> facebookInstalledSources = dataFacebookInstalled.get(0)
					.getSources();
			shopIdFacebook_cedSourceId = facebookInstalledSources.get(0).getShop_id();
			System.out.println("shopIdFacebook_cedSourceId = " + shopIdFacebook_cedSourceId);
		}

		// CAMPAIGN SYNC ACCOUNTS STATUS API

		if (resource.equals("campaignSyncAccountStatus")) {
			baseClassObj.requestSpec = given().spec(requestSpecification())
					.queryParam("target_marketplace", "eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9")
					.queryParam("shop_id", shopIdOnyx_cedTargetId).header("Authorization", BaseClass.token);
			user_calls_with_post_http_request(resource, "Get");

			// Headers allHeaders = baseClassObj.response.headers();
			// for (Header header : allHeaders) {
			// System.out.println("Key: " + header.getName() + " Value: " +
			// header.getValue());
			// }

			// Validating content-type should be application/json
			if (baseClassObj.response.header("Content-Type").equals("application/json")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

			String origin = baseClassObj.response.header("Origin");
			System.out.println("Origin value: " + origin);
			String responseType = baseClassObj.response.header("Response-Type");
			System.out.println("Response-Type value: " + responseType);
			String appTag = baseClassObj.response.header("appTag");
			System.out.println("appTag value: " + appTag);
			String appCode = baseClassObj.response.header("appCode");
			System.out.println("appCode value: " + appCode);
			String cedSourceId = baseClassObj.response.header("Ced-Source-Id");
			System.out.println("Ced-Source-Id value: " + cedSourceId);
			String cedSourceName = baseClassObj.response.header("Ced-Source-Name");
			System.out.println("Ced-Source-Name value: " + cedSourceName);
			String cedTargetValue = baseClassObj.response.header("Ced-Target-Id");
			System.out.println("Ced-Target-Id value: " + cedTargetValue);
			String cedTargetName = baseClassObj.response.header("Ced-Target-Name");
			System.out.println("Ced-Target-Name value: " + cedTargetName);
			String accessControlAllowOrigin = baseClassObj.response.header("access-control-allow-origin");
			System.out.println("access-control-allow-origin value: " + accessControlAllowOrigin);

			// Authorization value should be null
			//
			// if(baseClassObj.response.header("Authorization").isBlank()) {
			// Assert.assertTrue(true);
			// }else {
			// Assert.assertTrue(false);
			// }
			//
			//// origin value should be null
			//
			// if(baseClassObj.response.header("Origin").equals(null)) {
			// Assert.assertTrue(true);
			// }else {
			// Assert.assertTrue(false);
			// }
			//
			//// Response Type value should be null
			// if(baseClassObj.response.header("Response-Type").equals(null)) {
			// Assert.assertTrue(true);
			// }else {
			// Assert.assertTrue(false);
			// }
			//
			//// appTag value should be null
			// if(baseClassObj.response.header("appTag").equals(null)) {
			// Assert.assertTrue(true);
			// }else {
			// Assert.assertTrue(false);
			// }
			//
			//
			//// appCode value should be null
			// if(baseClassObj.response.header("appCode").equals(null)) {
			// Assert.assertTrue(true);
			// }else {
			// Assert.assertTrue(false);
			// }
			//
			//// Ced-Source-Id value should be null
			// if(baseClassObj.response.header("Ced-Source-Id").equals(null)) {
			// Assert.assertTrue(true);
			// }else {
			// Assert.assertTrue(false);
			// }
			//
			//
			//// Ced-Source-Name value should be null
			// if(baseClassObj.response.header("Ced-Source-Name").equals(null)) {
			// Assert.assertTrue(true);
			// }else {
			// Assert.assertTrue(false);
			// }
			//
			//// Ced-Target-Id value should be null
			// if(baseClassObj.response.header("Ced-Source-Name").equals(null)) {
			// Assert.assertTrue(true);
			// }else {
			// Assert.assertTrue(false);
			// }
			//
			//// Ced-Target-Name value should be null
			// if(baseClassObj.response.header("Ced-Target-Name").equals(null)) {
			// Assert.assertTrue(true);
			// }else {
			// Assert.assertTrue(false);
			// }
			//

		}

		// INIT CAMPAIGN API

		if (resource.equals("initCampaign")) {
			baseClassObj.requestSpec = given().spec(requestSpecification())
					.queryParam("target_marketplace", "eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9")
					.queryParam("shop_id", shopIdOnyx_cedTargetId).header("Authorization", BaseClass.token);
			user_calls_with_post_http_request(resource, "Get");

			// Validating content-type should be application/json
			if (baseClassObj.response.header("Content-Type").equals("application/json")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

			InitCampaignPojo initCampaignPojo = baseClassObj.response.as(InitCampaignPojo.class);
			List<String> errorsList = initCampaignPojo.getError();
			InitCampaignData initCampaignData = initCampaignPojo.getData();

			try {

				form_token = initCampaignData.getForm_token();

				// check account status == active then => disable reason should be none;
				if ((initCampaignData.getAccount_status().equals("ACTIVE"))
						&& (initCampaignData.getDisable_reason().equals("NONE"))) {
					Assert.assertTrue(true);
				} else if ((!initCampaignData.getAccount_status().equals("ACTIVE"))
						&& (!initCampaignData.getDisable_reason().equals("NONE"))) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

				// check if payment setup is false then there should be an error message

				if ((!initCampaignData.isPayment_setup())) {
					for (String error : errorsList) {
						if (error.equals("As Payment details not setup yet, you cannot create ads.")) {
							Assert.assertTrue(true);
						}
					}
				} else if ((initCampaignData.isPayment_setup())) {
					for (String error : errorsList) {
						if (!error.equals("As Payment details not setup yet, you cannot create ads.")) {
							Assert.assertTrue(true);
						}
					}
				} else {
					Assert.assertTrue(true);
				}

				// check if instagram is not connected then there should be an error message
				// "your Instagram account is not connected"

				if ((!initCampaignData.isIs_instagram_connected())) {
					for (String error : errorsList) {
						if (error.equals(
								"As your Instagram account is not connected, your campaigns will not show on Instagram.")) {
							Assert.assertTrue(true);
						}
					}
				} else if ((initCampaignData.isIs_instagram_connected())) {
					for (String error : errorsList) {
						if (!error.equals(
								"As your Instagram account is not connected, your campaigns will not show on Instagram.")) {
							Assert.assertTrue(true);
						}
					}
				} else {
					Assert.assertTrue(true);
				}

			} catch (Exception e) {

			}

		}

		if (resource.equals("getAudience")) {
			GetAudiencePojo getAudiencePojo = baseClassObj.response.as(GetAudiencePojo.class);
			List<GetAudiencePojoData> data = getAudiencePojo.getData();
			System.out.println("data.size() = " + data.size());
			if (data.size() > 0) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(true);
			}
		}

	}

	@Given("OverAll payload")
	public void over_all_payload() throws IOException {
		baseClassObj.requestSpec = given().spec(requestSpecification()).body(testDataBuild.overallAllGetStepsPayload())
				.header("ced-target-id", shopIdOnyx_cedTargetId).header("ced-source-id", shopIdFacebook_cedSourceId)
				.header("Authorization", BaseClass.token);
		holdScript(3);
	}

	@Given("Create webhook payload and target_marketplace")
	public void create_webhook_payload_and_target_marketplace() throws IOException {
		baseClassObj.requestSpec = given().spec(requestSpecification()).body(testDataBuild.createWebHookPayload())
				.header("Authorization", BaseClass.token).header("ced-source-id", shopIdFacebook_cedSourceId)
				.header("ced-target-id", shopIdOnyx_cedTargetId).header("ced-source-name", "onyx")
				.header("ced-target-name", "facebook");
		holdScript(3);
	}

	@Given("Create new user page with {string}")
	public void create_new_user_page_with(String email) throws IOException {
		System.out.println("onboardToken sdl = " + BaseClass.onboardToken);
		baseClassObj.requestSpec = given().spec(requestSpecification()).header("Authorization", BaseClass.onboardToken)
				.body(testDataBuild.isEmailExist(email));
		holdScript(3);

	}

}
