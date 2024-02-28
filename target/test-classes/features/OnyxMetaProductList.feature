Feature: Onyx meta product list

@ProductRefineCount
Scenario: User selects/clicks Product list
	Given User is loggedin to the Onyx Meta and is on Product list page 
	When User calls "getRefineProductCount" with "Get" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	Then Validate data using resource "getRefineProductCount"
	
	
@ProductRefine
Scenario: User selects/clicks Product list
	Given User is loggedin successfully into Onyx Meta and is on Product list section
	When User calls "getRefineProducts" with "Get" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	Then Validate data using resource "getRefineProducts"
	
@AllQueuedTask
Scenario: User selects/clicks Product list
	Given User is loggedin successfully into Onyx Meta and is on Product list section
	When User calls "allQueuedTasks" with "Get" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	Then Validate data using resource "allQueuedTasks"