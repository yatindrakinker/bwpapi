Feature: Onyx meta Help and FAQ section

Scenario: User is searching for queries 
	Given User is loggedin to the Onyx Meta and is on Help or FAQ page 
	When User calls "search" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	Then Validate data using resource "search"
	
	
#Scenario Outline: User is searching for valid query 
#	Given User is loggedin to the Onyx Meta and is on Help or FAQ page and searches for "<Keyword>"
#	When User calls "search" with "Post" http request 
#	Then The API call got success with status code 200 
#	And "success" in response body is "true" 
#	Then Validate data using resource "search"
#	
#	Examples:
#	|Keyword									|
#	|How do I set up conversion tracking?		|
#	