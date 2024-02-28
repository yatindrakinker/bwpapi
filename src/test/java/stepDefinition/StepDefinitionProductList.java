package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pojo.AllQueuedTasksPojo;
import pojo.AllQueuedTasksPojoData;
import pojo.AllQueuedTasksPojoDataRows;
import pojo.CreateCustomAudiencePojo;
import pojo.CreateCustomAudiencePojoAudience;
import pojo.GetAccountPixelPojo;
import pojo.GetAccountPixelPojoData;
import pojo.GetConfigPojo;
import pojo.GetConfigPojoData;
import pojo.GetRefineProductCountPojo;
import pojo.GetRefineProductCountPojoQuery;
import pojo.GetRefineProductCountPojoQueryMatch;
import pojo.GetRefineProductsPojo;
import pojo.GetRefineProductsPojoData;
import pojo.GetRefineProductsPojoDataRows;
import pojo.GetRefineProductsPojoDataRowsId;
import pojo.GetRefineProductsPojoDataRowsItems;
import pojo.SearchPojo;
import pojo.SearchPojoData;
import pojo.SearchPojoDataMeta;
import resources.BaseClass;
import resources.Utilities;

public class StepDefinitionProductList extends Utilities {

	BaseClass baseClassObj;
	public static String pixelId;

	public StepDefinitionProductList(BaseClass baseClassObj) {
		this.baseClassObj = baseClassObj;
	}

//	Requset for getRefineProductCount 

	@Given("User is loggedin to the Onyx Meta and is on Product list page")
	public void user_is_loggedin_to_the_onyx_meta_and_is_on_product_list_page() throws IOException {
		baseClassObj.requestSpec = given().spec(requestSpecification())
				.queryParam("target_marketplace", "eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9")
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "facebook").header("Authorization", BaseClass.token);
	}

//	Requset for getRefineProducts 

	@Given("User is loggedin successfully into Onyx Meta and is on Product list section")
	public void user_is_loggedin_successfully_into_onyx_meta_and_is_on_product_list_section() throws IOException {
		baseClassObj.requestSpec = given().spec(requestSpecification())
				.queryParam("target_marketplace", "eyJtYXJrZXRwbGFjZSI6ImFsbCIsInNob3BfaWQiOm51bGx9")
				.header("ced-source-id", StepDefinitionLogin.shopIdFacebook_cedSourceId)
				.header("ced-source-name", "onyx").header("ced-target-id", StepDefinitionLogin.shopIdOnyx_cedTargetId)
				.header("ced-target-name", "facebook").header("Authorization", BaseClass.token);
		holdScript(3);
	}

	@Then("Validate data using resource {string}")
	public void validate_data_using_resource(String resource) {

		if (resource.equals("getRefineProductCount")) {
			
//			Validating content-type should be application/json
			if(baseClassObj.response.header("Content-Type").equals("application/json")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}

//				GET REFINED PRODUCTS COUNT API
			GetRefineProductCountPojo getRefineProductCountPojo = baseClassObj.response
					.as(GetRefineProductCountPojo.class);
			
			
			List<GetRefineProductCountPojoQuery> getRefineProductCountPojoQuery = getRefineProductCountPojo.getQuery();
			GetRefineProductCountPojoQueryMatch getRefineProductCountPojoQueryMatch = getRefineProductCountPojoQuery
					.get(0).get$match();

//					Validate Target ShopID 

			if (getRefineProductCountPojoQueryMatch.getTarget_shop_id()
					.equals(StepDefinitionLogin.shopIdOnyx_cedTargetId)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

//					Validate Source ShopID 

			if (getRefineProductCountPojoQueryMatch.getSource_shop_id()
					.equals(StepDefinitionLogin.shopIdFacebook_cedSourceId)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

//					Validate Source getUserId

			if (!getRefineProductCountPojoQueryMatch.getUser_id().equals("")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

		if (resource.equals("getRefineProducts")) {
//			Validating content-type should be application/json
			if(baseClassObj.response.header("Content-Type").equals("application/json")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
			GetRefineProductsPojo getRefineProductsPojo = baseClassObj.response.as(GetRefineProductsPojo.class);
			GetRefineProductsPojoData getRefineProductsPojoData = getRefineProductsPojo.getData();

//			Current page
			getRefineProductsPojoData.getCurrent_count();

//			Total pages that contains products
			getRefineProductsPojoData.getTotalPageRead();

//			Validate if products are shown on single page then there will be no next/previous page
			if ((getRefineProductsPojoData.getTotalPageRead() == 1) && (getRefineProductsPojoData.getNext() == null)
					&& (getRefineProductsPojoData.getPrev() == null)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

//			Validating Rows

			List<GetRefineProductsPojoDataRows> getRefineProductsPojoDataRows = getRefineProductsPojoData.getRows();
			GetRefineProductsPojoDataRows item = getRefineProductsPojoDataRows.get(0);
//			for(GetRefineProductsPojoDataRows item: getRefineProductsPojoDataRows) {
			System.out.println("item.getContainer_id() = " + item.getContainer_id());
			System.out.println("item.getSource_shop_id() = " + item.getSource_shop_id());
			System.out.println("item.getSource_product_id() =  " + item.getSource_product_id());
			GetRefineProductsPojoDataRowsId getRefineProductsPojoDataRowsId = item.get_id();
			System.out.println(
					"getRefineProductsPojoDataRowsId.get$oid() = " + getRefineProductsPojoDataRowsId.get$oid());
//				List<GetRefineProductsPojoDataRowsAppCodes> appCodesList= item.getApp_codes();
//				for(GetRefineProductsPojoDataRowsAppCodes appCode : appCodesList) {
//					System.out.println(appCode);
//				}
//				System.out.println(item.getApp_codes().get(0));
			System.out.println(item.getBrand());
			System.out.println(item.getCreated_at());
			System.out.println(item.getMain_image());
			System.out.println(item.getTarget_product_id());
			System.out.println(item.getTitle());
			System.out.println(item.getType());

			System.out.println(item.getTags());
			try {
				System.out.println(item.getVariant_attributes().get(0));
			} catch (IndexOutOfBoundsException e) {

			}

//				Product details
			List<GetRefineProductsPojoDataRowsItems> productList = item.getItems();
			for (GetRefineProductsPojoDataRowsItems product : productList) {

				System.out.println("product.getShop_id() = " + product.getShop_id());
//					Product id is mandatory
				if ((!product.getSource_product_id().equals("")) || (!product.getSource_product_id().equals(null)
						|| (!product.getSource_product_id().equals(" ")))) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

				System.out.println("product.getSource_product_id = " + product.getSource_product_id());
				System.out.println("product.getTitle = " + product.getTitle());
				System.out.println("product.getSku = " + product.getSku());
				System.out.println("product.getQuantity = " + product.getQuantity());
				System.out.println("product.getPrice = " + product.getPrice());
				System.out.println("product.getTarget_marketplace = " + product.getTarget_marketplace());
			}

//			}

		}

		if (resource.equals("allQueuedTasks")) {
			
//			Validating content-type should be application/json
			if(baseClassObj.response.header("Content-Type").equals("application/json")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}

			AllQueuedTasksPojo allQueuedTasksPojo = baseClassObj.response.as(AllQueuedTasksPojo.class);
			AllQueuedTasksPojoData allQueuedTasksPojoData = allQueuedTasksPojo.getData();
			System.out.println("total products = " + allQueuedTasksPojoData.getCount());
			List<AllQueuedTasksPojoDataRows> rows = allQueuedTasksPojoData.getRows();
			for (AllQueuedTasksPojoDataRows product : rows) {
				System.out.println("product.getUser_id = " + product.getUser_id());
				System.out.println("product.getShop_id = " + product.getShop_id());

//				Validating target shopId
				if (product.getShop_id().equals(StepDefinitionLogin.shopIdOnyx_cedTargetId)) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

//				Validating Market place
				System.out.println("product.getMarketplace = " + product.getMarketplace());
				if (product.getMarketplace().equals("meta")) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

//				Validating App Tag
				System.out.println("product.getAppTag = " + product.getAppTag());
				if (product.getAppTag().equals("bwp_meta")) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

//				Validating App Tag
				System.out.println("product.getProcess_code = " + product.getProcess_code());
				if (product.getProcess_code().equals("product_upload")) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

			}
		}

//		getAccountPixels SETTINGS PAGE API AUTOMATION STARTS HERE

		if (resource.equals("getAccountPixels")) {
			
//			Validating content-type should be application/json
			if(baseClassObj.response.header("Content-Type").equals("application/json")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}

			GetAccountPixelPojo getAccountPixelPojo = baseClassObj.response.as(GetAccountPixelPojo.class);
			List<GetAccountPixelPojoData> dataList = getAccountPixelPojo.getData();
			pixelId = dataList.get(0).getId();
			System.out.println("pixelId = " + pixelId);

			if (dataList.size() > 0) {
				for (GetAccountPixelPojoData data : dataList) {
					System.out.println("pixel id = " + data.getId());
					System.out.println("name = " + data.getName());
					System.out.println("isEnable_automatic_matching = " + data.isEnable_automatic_matching());
				}
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

		if (resource.equals("createCustomAudience")) {

			CreateCustomAudiencePojo createCustomAudiencePojo = baseClassObj.response
					.as(CreateCustomAudiencePojo.class);
			CreateCustomAudiencePojoAudience audience = createCustomAudiencePojo.getAudience();
			try {
				System.out.println(" audience.get_23852465303750620() = " + audience.get_23852465303750620());
				System.out.println(" .get_23852465304300620() = " + audience.get_23852465304300620());
			} catch (Exception e) {

			}
		}

//		GET CONFIG DATA

		if (resource.equals("getConfig")) {
			
//			Validating content-type should be application/json
			if(baseClassObj.response.header("Content-Type").equals("application/json")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
			GetConfigPojo getConfigPojo = baseClassObj.response.as(GetConfigPojo.class);
			List<GetConfigPojoData> dataList = getConfigPojo.getData();
			if (dataList.size() > 0) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

//		SEARCH CAMPAIGN API ==> ALL CAMPAIGNS
		if (resource.equals("search")) {
			
//			Validating content-type should be application/json
			if(baseClassObj.response.header("Content-Type").equals("application/json")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
			SearchPojo searchPojo = baseClassObj.response.as(SearchPojo.class);
			SearchPojoData searchPojoData = searchPojo.getData();
			SearchPojoDataMeta searchPojoDataMeta = searchPojoData.getMeta();
			if (searchPojoDataMeta.getAccount().getData().size() > 0) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

			if (searchPojoDataMeta.getCampaign().getData().size() > 0) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

			if (searchPojoDataMeta.getGeneral().getData().size() > 0) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

			if (searchPojoDataMeta.getProduct().getData().size() > 0) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

	}
}
