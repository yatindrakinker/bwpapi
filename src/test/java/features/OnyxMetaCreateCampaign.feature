Feature: Onyx Meta Create Campaign 

Scenario Outline: 
	User selects Prospective Audience and selects valid search while creating a campaign 
	Given User is successfully loggedin to the app and getAudience payload with query "<query>" 
	When User calls "getAudience" with "get" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	And Validate size of data in response is not zero using "getAudience" api 
	
	Examples: 
		|query			|
		|cricket		|
		
Scenario Outline: 
	User selects Prospective Audience and selects invalid search while creating a campaign 
	Given User is successfully loggedin to the app and getAudience payload with query "<query>" 
	When User calls "getAudience" with "get" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	And Validate size of data in response is zero using "getAudience" api 
	
	Examples: 
		|query			|
		|qwertyu		|
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method 
	Given User is successfully loggedin to the app and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	#	And "message" in response body is "Failed to create Campaign!" 
	And "message" in response body is "Add a valid payment method to your ad account." 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|
		|New Year Sale	|01/25/2023	|02/25/2023	|123			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and Start date is past date
	Given User is successfully loggedin to the app and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	And "message" in response body is "Start Date should be today or a future date." 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|
		|New Year Sale	|01/25/2022	|02/25/2023	|123			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and campaign name is missing
	Given User is successfully loggedin to the app and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	#	And "message" in response body is "Failed to create Campaign!" 
	And "message" in response body is "Add a valid payment method to your ad account." 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|
		|				|01/30/2023	|12/12/2023	|123			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|
		
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and Ad Text is missing
	Given User is successfully loggedin to the app and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	And "message" in response body is "Ad Text is Required. " 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText		|minAge		|maxAge		|gender		|type		|
		|New Year Sale	|01/30/2023	|12/12/2023	|123			|			|18			|	65		|	All		|dynamic	|
		
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and End date is past date
	Given User is successfully loggedin to the app and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	And "message" in response body is "End Date should be a future date, not today or past date." 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|
		|New Year Sale	|12/01/2025	|01/05/2020	|123			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|
		
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and End date is missing
	Given User is successfully loggedin to the app and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	#	And "message" in response body is "Failed to create Campaign!" 
	And "message" in response body is "Start Date should be today or a future date" 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|
		|New Year Sale	|01/01/2023	|			|123			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and daily budget is less than $5
	Given User is successfully loggedin to the app and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	And "message" in response body is "Minimum budget amount should be $5 ." 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|
		|New Year Sale	|12/01/2025	|			|-1				|Biggest sale of new year	|18			|	65		|	All		|dynamic	|
		|New Year Sale	|12/01/2025	|			|1				|Biggest sale of new year	|18			|	65		|	All		|dynamic	|
		|New Year Sale	|12/01/2025	|			|4.99			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and daily budget is missing
	Given User is successfully loggedin to the app and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	And "message" in response body is "budget is Required. , Minimum budget amount should be $5 ." 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|
		|New Year Sale	|12/01/2025	|			|				|Biggest sale of new year	|18			|	65		|	All		|dynamic	|
		|New Year Sale	|12/01/2025	|			|0				|Biggest sale of new year	|18			|	65		|	All		|dynamic	|
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and minimum age is less than 18 or invalid
	Given User is successfully loggedin to the app and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	And "message" in response body is "Minimum age should be 18 or above." 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|
		|New Year Sale	|12/01/2025	|			|111			|Biggest sale of new year	|-01		|	65		|	All		|dynamic	|
		#		|New Year Sale	|12/01/2025	|			|111			|Biggest sale of new year	|0			|	65		|	All		|dynamic	|
		|New Year Sale	|12/01/2025	|			|111			|Biggest sale of new year	|17			|	65		|	All		|dynamic	|
		#		|New Year Sale	|12/01/2025	|			|111			|Biggest sale of new year	|			|	65		|	All		|dynamic	|
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and maximum age is less than 18 and minimum age
	Given User is successfully loggedin to the app and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	And "message" in response body is "Minimum age should be 18 or above." 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|
		|New Year Sale	|12/01/2025	|			|111			|Biggest sale of new year	|17			|00			|	All		|dynamic	|
		
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and enters invalid shopId in Integer
	Given User is successfully loggedin to the app and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" "<shopId>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
#	And "message" in response body is "Please Reconnect Account!" 
	And "message" in response body is "Something went wrong" 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|shopId		|
		|New Year Sale	|12/25/2022	|01/05/2023	|123			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|123		|
		|New Year Sale	|12/25/2022	|01/05/2023	|123			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|123456		|
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and enters invalid shopId in String
	Given User is successfully loggedin to the app and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" "<shopId>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	And "message" in response body is "Form Token is Required" 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|shopId		|
		|New Year Sale	|12/25/2022	|01/05/2023	|123			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|abc		|
		|New Year Sale	|12/25/2022	|01/05/2023	|123			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|			|
		|New Year Sale	|12/25/2022	|01/05/2023	|123			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|@799abc	|
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and form_token is missing
	Given User is successfully loggedin to the app and form_token is missing and create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>" "<type>" "<minAge>" "<maxAge>" "<gender>" "<form_token>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	And "message" in response body is "Form Token is Required" 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|form_token	|
		|New Year Sale	|12/25/2022	|01/05/2023	|123			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|			|
		
Scenario Outline: 
	User wants to create a campaign but he does not have added payment method and form_token is invalid
	Given User is successfully loggedin to the app and and form_token is invalid create campaign payload is given "<campaignName>" "<startDate>" "<endDate>" "<dailyBudget>" "<adText>"  "<minAge>" "<maxAge>" "<gender>" "<type>" "<form_token>" 
	When User calls "publishCampaignAPI" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	And "message" in response body is "Failed to create Campaign!" 
	
	Examples: 
		|campaignName	|startDate	|endDate	|dailyBudget	|adText						|minAge		|maxAge		|gender		|type		|form_token	|
		|New Year Sale	|12/25/2022	|01/05/2023	|123			|Biggest sale of new year	|18			|	65		|	All		|dynamic	|123		|
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		