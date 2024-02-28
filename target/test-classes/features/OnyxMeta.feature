Feature: Onyx Meta 


@LoginWithValidCredentials
Scenario Outline: Successful Login with Valid credentials 
	Given credentials "<email>" and "<password>" 
	When User calls "loginAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	And get all data using "overAllAppAll" api
	Examples: 
		|email					   	     |password    |
		|iamyatindrathephenom@gmail.com  |Yatindra@123|
		
@LoginWithInvalidCredentials
Scenario Outline:: Unsuccessful Login with invalid entries 
	Given credentials "<email>" and "<password>" 
	When User calls "loginAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	And "code" in response body is "invalid_data" 
	And "message" in response body is "Invalid username or password"
	
	
	Examples: 
		|email					   	   		|password    |
		|yatindrathephenom@gmail.com     	|Yatindra@123|
		|yatindra@gmail.com     			|Yatindra    |
	
	
@GetAll
Scenario: Get overall steps
	Given OverAll payload
	When User calls "overallAllGetSteps" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	Then get all data using "campaignSyncAccountStatus" api
	And "message" in response body is "Shop Updated Successfuly" 

	
@CreateWebhook
Scenario: Create webhook is working properly
	Given Create webhook payload and target_marketplace
	When User calls "createWebhook" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	And "message" in response body is "Registering Webhooks ..." 
	Then get all data using "initCampaign" api
	And "success" in response body is "true" 
	Then get all data using "getCampaigns" api
	And "success" in response body is "true" 
	Then get all data using "allNotifications" api
	And "success" in response body is "true" 
	
