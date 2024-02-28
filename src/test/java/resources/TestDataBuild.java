package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.ConfigPojo;
import pojo.DataPojo;
import pojo.OnboardingCreateUserSerialization;
import pojo.UserPojo;
import stepDefinition.StepDefinitionLogin;

public class TestDataBuild {

	public OnboardingCreateUserSerialization createNewUser(String email, String password, String confirmPassword,
			String key, String value, String groupCode) {
		OnboardingCreateUserSerialization ocs = new OnboardingCreateUserSerialization();
		ocs.setTarget_marketplace("eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9");
		UserPojo user = new UserPojo();
		user.setEmail(email);
		user.setNew_password(password);
		user.setConfirm_password(confirmPassword);
		ConfigPojo config = new ConfigPojo();
		config.setKey(key);
		config.setValue(value);
		config.setGroup_code(groupCode);
		List<ConfigPojo> configList = new ArrayList<>();
		configList.add(config);
		DataPojo data = new DataPojo();
		data.setUser(user);
		data.setConfig(configList);
		ocs.setData(data);
		return ocs;

	}

	public String isEmailExist(String email) {
		return "{\n" + "    \"data\":{\n" + "        \"email\":\"" + email + "\"\n" + "    }\n" + "}";
	}

	public String loginPayload(String email, String password) {
		return "{\n" + "    \"email\":\"" + email + "\",\n" + "    \"password\":\"" + password + "\"\n" + "}";
	}

	public String overallAllGetStepsPayload() {
		return "{\n" + "  \"target_marketplace\": \"eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9\",\n"
				+ "  \"path\": \"/App/User/Step\",\n" + "  \"target\": {\n" + "    \"marketplace\": \"facebook\"\n"
				+ "  },\n" + "  \"source\": {\n" + "    \"marketplace\": \"onyx\"\n" + "  },\n"
				+ "  \"app_tag\": \"bwp_meta\"\n" + "}";
	}

	public String createWebHookPayload() {
		return "{\n" + "    \"target_marketplace\" : \"eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9\"\n" + "}";
	}

	public String getConfigPayload(String shopId) {
		return "{\n" + "  \"target_marketplace\": \"eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9\",\n"
				+ "  \"source\": {\n" + "    \"shopId\": \"" + shopId + "\",\n" + "    \"marketplace\": \"onyx\"\n"
				+ "  },\n" + "  \"key\": [\n" + "    \"brand\"\n" + "  ],\n" + "  \"group_code\": [\n"
				+ "    \"bwp-product\"\n" + "  ]\n" + "}";
	}

	public String passwordResetPayload(String email, String old_password, String new_password,
			String confirm_password) {
		return "{\n" + "  \"target_marketplace\": \"eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9\",\n"
				+ "  \"email\": \"" + email + "\",\n" + "  \"old_password\": \"" + old_password + "\",\n"
				+ "  \"new_password\": \"" + new_password + "\",\n" + "  \"confirm_password\": \"" + confirm_password
				+ "\"\n" + "}";
	}

	public String updatePixelPayload(String shopId, String pixelId) {
		return "{\n" + "  \"target_marketplace\": \"eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9\",\n"
				+ "  \"shop_id\": \"" + shopId + "\",\n" + "  \"pixel\": \"" + pixelId + "\"\n" + "}";
	}

	public String updateBrandNamePayload(String shopId, String brandName) {
		return "{\n" + "  \"target_marketplace\": \"eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9\",\n"
				+ "  \"source\": {\n" + "    \"shopId\": \"" + shopId + "\",\n" + "    \"marketplace\": \"onyx\"\n"
				+ "  },\n" + "  \"data\": [\n" + "    {\n" + "      \"group_code\": \"bwp-product\",\n"
				+ "      \"data\": {\n" + "        \"brand\": \"" + brandName + "\"\n" + "      }\n" + "    }\n"
				+ "  ]\n" + "}";
	}

	public String allSearchPayload() {
		return "{\n" + "  \"marketplace\": \"meta\",\n" + "  \"limit\": 5\n" + "}";
	}

	public String querySearchPayload(String keyword) {
		return "{\n" + "    \"marketplace\": \"meta\",\n" + "    \"keyword\":\"" + keyword + "\",\n"
				+ "    \"exact\":true,\n" + "    \"limit\": 1\n" + "}";
	}

	public String createCampaignPayload(String campaignName, String startDate, String endDate, String dailyBudget,
			String adText, String typeTragetAudience, String minAge, String maxAge, String gender) {

		return "{\n" + "  \"target_marketplace\": \"eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9\",\n"
				+ "  \"shop_id\": " + StepDefinitionLogin.shopIdOnyx_cedTargetId + ",\n"
				+ "  \"call_to_action\": \"SHOP_NOW\",\n" + "  \"form_token\": \"" + StepDefinitionLogin.form_token
				+ "\",\n" + "  \"website_url\": \"https://amazon.com\",\n" + "  \"locations\": [\n" + "    {\n"
				+ "      \"key\": \"US\",\n" + "      \"name\": \"United States\",\n" + "      \"type\": \"country\",\n"
				+ "      \"country_code\": \"US\",\n" + "      \"country_name\": \"United States\",\n"
				+ "      \"supports_region\": true,\n" + "      \"supports_city\": true\n" + "    }\n" + "  ],\n"
				+ "  \"status\": \"ACTIVE\",\n" + "  \"name\": \"" + campaignName + "\",\n" + "  \"budget\": \""
				+ dailyBudget + "\",\n" + "  \"primary_text\": \"" + adText + "\",\n" + "  \"platforms\": [\n"
				+ "    \"facebook\"\n" + "  ],\n" + "  \"start_date\": \"" + startDate + "\",\n" + "  \"end_date\": \""
				+ endDate + "\",\n" + "  \"type\": \"" + typeTragetAudience + "\",\n" + "  \"min_age\": \"" + minAge
				+ "\",\n" + "  \"max_age\": \"" + maxAge + "\",\n" + "  \"gender\": \"" + gender + "\",\n"
				+ "  \"expansion\": 0,\n" + "  \"interests\": [\n" + "    {\n" + "      \"id\": \"6002988344794\",\n"
				+ "      \"name\": \"Cricket (sport)\",\n" + "      \"type\": \"interests\",\n" + "      \"path\": [\n"
				+ "        \"Interests\",\n" + "        \"Additional interests\",\n" + "        \"Cricket (sport)\"\n"
				+ "      ],\n" + "      \"audience_size_lower_bound\": 256639447,\n"
				+ "      \"audience_size_upper_bound\": 301807990\n" + "    }\n" + "  ],\n" + "  \"demographics\": [\n"
				+ "    {\n" + "      \"id\": \"417581974963808\",\n" + "      \"name\": \"Cricket Wireless\",\n"
				+ "      \"type\": \"work_employers\",\n" + "      \"path\": [\n" + "        \"Demographics\",\n"
				+ "        \"Work\",\n" + "        \"Employers\",\n" + "        \"Cricket Wireless\"\n" + "      ],\n"
				+ "      \"audience_size_lower_bound\": 19876,\n" + "      \"audience_size_upper_bound\": 23375\n"
				+ "    }\n" + "  ],\n" + "  \"behaviors\": []\n" + "}";

	}
	
	public String createCampaignPayloadWithInvalidShopId(String campaignName, String startDate, String endDate, String dailyBudget,
			String adText, String typeTragetAudience, String minAge, String maxAge, String gender, String shopId) {

		return "{\n" + "  \"target_marketplace\": \"eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9\",\n"
				+ "  \"shop_id\": " + shopId + ",\n"
				+ "  \"call_to_action\": \"SHOP_NOW\",\n" + "  \"form_token\": \"" + StepDefinitionLogin.form_token
				+ "\",\n" + "  \"website_url\": \"https://amazon.com\",\n" + "  \"locations\": [\n" + "    {\n"
				+ "      \"key\": \"US\",\n" + "      \"name\": \"United States\",\n" + "      \"type\": \"country\",\n"
				+ "      \"country_code\": \"US\",\n" + "      \"country_name\": \"United States\",\n"
				+ "      \"supports_region\": true,\n" + "      \"supports_city\": true\n" + "    }\n" + "  ],\n"
				+ "  \"status\": \"ACTIVE\",\n" + "  \"name\": \"" + campaignName + "\",\n" + "  \"budget\": \""
				+ dailyBudget + "\",\n" + "  \"primary_text\": \"" + adText + "\",\n" + "  \"platforms\": [\n"
				+ "    \"facebook\"\n" + "  ],\n" + "  \"start_date\": \"" + startDate + "\",\n" + "  \"end_date\": \""
				+ endDate + "\",\n" + "  \"type\": \"" + typeTragetAudience + "\",\n" + "  \"min_age\": \"" + minAge
				+ "\",\n" + "  \"max_age\": \"" + maxAge + "\",\n" + "  \"gender\": \"" + gender + "\",\n"
				+ "  \"expansion\": 0,\n" + "  \"interests\": [\n" + "    {\n" + "      \"id\": \"6002988344794\",\n"
				+ "      \"name\": \"Cricket (sport)\",\n" + "      \"type\": \"interests\",\n" + "      \"path\": [\n"
				+ "        \"Interests\",\n" + "        \"Additional interests\",\n" + "        \"Cricket (sport)\"\n"
				+ "      ],\n" + "      \"audience_size_lower_bound\": 256639447,\n"
				+ "      \"audience_size_upper_bound\": 301807990\n" + "    }\n" + "  ],\n" + "  \"demographics\": [\n"
				+ "    {\n" + "      \"id\": \"417581974963808\",\n" + "      \"name\": \"Cricket Wireless\",\n"
				+ "      \"type\": \"work_employers\",\n" + "      \"path\": [\n" + "        \"Demographics\",\n"
				+ "        \"Work\",\n" + "        \"Employers\",\n" + "        \"Cricket Wireless\"\n" + "      ],\n"
				+ "      \"audience_size_lower_bound\": 19876,\n" + "      \"audience_size_upper_bound\": 23375\n"
				+ "    }\n" + "  ],\n" + "  \"behaviors\": []\n" + "}";

	}
	

	public String createCampaignPayloadWithInvalidForm_Token(String campaignName, String startDate, String endDate, String dailyBudget,
			String adText, String typeTragetAudience, String minAge, String maxAge, String gender, String shopId, String form_token) {

		return "{\n" + "  \"target_marketplace\": \"eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9\",\n"
				+ "  \"shop_id\": " + shopId + ",\n"
				+ "  \"call_to_action\": \"SHOP_NOW\",\n" + "  \"form_token\": \"" + form_token
				+ "\",\n" + "  \"website_url\": \"https://amazon.com\",\n" + "  \"locations\": [\n" + "    {\n"
				+ "      \"key\": \"US\",\n" + "      \"name\": \"United States\",\n" + "      \"type\": \"country\",\n"
				+ "      \"country_code\": \"US\",\n" + "      \"country_name\": \"United States\",\n"
				+ "      \"supports_region\": true,\n" + "      \"supports_city\": true\n" + "    }\n" + "  ],\n"
				+ "  \"status\": \"ACTIVE\",\n" + "  \"name\": \"" + campaignName + "\",\n" + "  \"budget\": \""
				+ dailyBudget + "\",\n" + "  \"primary_text\": \"" + adText + "\",\n" + "  \"platforms\": [\n"
				+ "    \"facebook\"\n" + "  ],\n" + "  \"start_date\": \"" + startDate + "\",\n" + "  \"end_date\": \""
				+ endDate + "\",\n" + "  \"type\": \"" + typeTragetAudience + "\",\n" + "  \"min_age\": \"" + minAge
				+ "\",\n" + "  \"max_age\": \"" + maxAge + "\",\n" + "  \"gender\": \"" + gender + "\",\n"
				+ "  \"expansion\": 0,\n" + "  \"interests\": [\n" + "    {\n" + "      \"id\": \"6002988344794\",\n"
				+ "      \"name\": \"Cricket (sport)\",\n" + "      \"type\": \"interests\",\n" + "      \"path\": [\n"
				+ "        \"Interests\",\n" + "        \"Additional interests\",\n" + "        \"Cricket (sport)\"\n"
				+ "      ],\n" + "      \"audience_size_lower_bound\": 256639447,\n"
				+ "      \"audience_size_upper_bound\": 301807990\n" + "    }\n" + "  ],\n" + "  \"demographics\": [\n"
				+ "    {\n" + "      \"id\": \"417581974963808\",\n" + "      \"name\": \"Cricket Wireless\",\n"
				+ "      \"type\": \"work_employers\",\n" + "      \"path\": [\n" + "        \"Demographics\",\n"
				+ "        \"Work\",\n" + "        \"Employers\",\n" + "        \"Cricket Wireless\"\n" + "      ],\n"
				+ "      \"audience_size_lower_bound\": 19876,\n" + "      \"audience_size_upper_bound\": 23375\n"
				+ "    }\n" + "  ],\n" + "  \"behaviors\": []\n" + "}";

	}

}
