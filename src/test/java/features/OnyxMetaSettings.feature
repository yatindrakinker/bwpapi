Feature: Onyx meta Settings Section

@getAccountPixelsAPI
Scenario: User opens settings section
	Given User is loggedin to the Onyx Meta and is on Settings page 
	When User calls "getAccountPixels" with "Get" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	Then Validate data using resource "getAccountPixels"

@getConfigAPI
Scenario: User opens settings section
	Given User is loggedin to the Onyx Meta and is on Settings page and shopId 
	When User calls "getConfig" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	Then Validate data using resource "getConfig"

@getDisconnectedAccountAPI	
Scenario: User opens settings section
	Given User is loggedin to the Onyx Meta and is on Settings page 
	When User calls "getDisconnectedAccount" with "Get" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	Then Validate data using resource "getDisconnectedAccount"

@resetpasswordAPI
Scenario Outline: User successfully changes his password
	Given User is loggedin to the Onyx Meta and is on accounts section in Settings page with email "<email>" old_password "<old_password>" new_password "<new_password>" confirm_password "<confirm_password>"
	When User calls "resetpassword" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	And "message" in response body is "Password updated successfully" 
	
	Examples:
	|email						|old_password	|new_password	|confirm_password	|
	|iamyatindrathephenom@gmail	|Yatindra@123	|Yatindra@1234	|Yatindra@1234		|
	|iamyatindrathephenom@gmail	|Yatindra@1234	|Yatindra@1234	|Yatindra@1234		|
	|iamyatindrathephenom@gmail	|Yatindra@1234	|Yatindra@123	|Yatindra@123		|


Scenario Outline: User try to changes his password with wrong old password
	Given User is loggedin to the Onyx Meta and is on accounts section in Settings page with email "<email>" old_password "<old_password>" new_password "<new_password>" confirm_password "<confirm_password>"
	When User calls "resetpassword" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
#	And "code" in response body is "password_not_matched" 
#	And "message" in response body is "Old Password not matched" 
	
	Examples:
	|email						|old_password	|new_password	|confirm_password	|
	|iamyatindrathephenom@gmail	|Yatindra@12345	|Yatindra@1234	|Yatindra@1234		|
	|iamyatindrathephenom@gmail	|Yatindra@12	|Yatindra@123	|Yatindra@1234		|

	
Scenario Outline: User try to changes his password with different new_password and confirm_password
	Given User is loggedin to the Onyx Meta and is on accounts section in Settings page with email "<email>" old_password "<old_password>" new_password "<new_password>" confirm_password "<confirm_password>"
	When User calls "resetpassword" with "Post" http request 
	Then The API call got success with status code 200 
#	And "success" in response body is "false" 
#	And "message" in response body is "Confirm password not matched with new password!" 
	
	Examples:
	|email						|old_password	|new_password	|confirm_password	|
	|iamyatindrathephenom@gmail	|Yatindra@123	|Yatindra@1234	|Yatindra@123		|
	|iamyatindrathephenom@gmail	|Yatindra@123	|Yatindra@123	|Yatindra@1234		|
	
		
Scenario Outline: User try to changes his password without following password standard
	Given User is loggedin to the Onyx Meta and is on accounts section in Settings page with email "<email>" old_password "<old_password>" new_password "<new_password>" confirm_password "<confirm_password>"
	When User calls "resetpassword" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
#	And "message" in response body is "Password is too weak!" 
	
	Examples:
	|email						|old_password	|new_password		|confirm_password	|
	|iamyatindrathephenom@gmail	|Yatindra@123	|Yatindra@			|Yatindra@			|	
	|iamyatindrathephenom@gmail	|Yatindra@123	|Yatindra			|Yatindra			|
	|iamyatindrathephenom@gmail	|Yatindra@123	|YATINDRA			|YATINDRA			|
	|iamyatindrathephenom@gmail	|Yatindra@123	|yatindrakinker		|yatindrakinker		|
	|iamyatindrathephenom@gmail	|Yatindra@123	|yatindrakinker12	|yatindrakinker12	|
	|iamyatindrathephenom@gmail	|Yatindra@123	|yatindrakinker12@	|yatindrakinker12@	|
	|iamyatindrathephenom@gmail	|Yatindra@123	|yatindrakinker@@	|yatindrakinker@@	|
	|iamyatindrathephenom@gmail	|Yatindra@123	|12345678			|12345678			|
	|iamyatindrathephenom@gmail	|Yatindra@123	|!@#$%^&*			|!@#$%^&*			|
	|iamyatindrathephenom@gmail	|Yatindra@123	|        			|        			|
	
	
@updateInvalidPixel
Scenario Outline: User changes his pixelId that does not exist
	Given User is loggedin to the Onyx Meta and is on accounts section in Settings page with pixelId "<pixelId>"
	When User calls "updatePixel" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
#	And "message" in response body is "Pixel updated Successfully." 
	Then get all data using "initCampaign" api
	And "success" in response body is "true" 

	Examples:
	|pixelId	|
	|abc		|
	|123		|
	|!@#		|
	
@updatePixelWithNoValue
Scenario Outline: User changes his pixelId with empty or whitespaces value
	Given User is loggedin to the Onyx Meta and is on accounts section in Settings page with pixelId "<pixelId>"
	When User calls "updatePixel" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
#	And "message" in response body is "Pixel id is Required" 
	And "message" in response body is "Token is not valid anymore" 

	Examples:
	|pixelId	|
	|			|
	
@updatePixelWithInvalidShopId
Scenario Outline: User changes his pixelId with invalid shopId
	Given User is loggedin to the Onyx Meta and is on accounts section in Settings page with shopId "<shopId>"
	When User calls "updatePixel" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
#	And "message" in response body is "Failed to update Pixel!" 
	And "message" in response body is "Token is not valid anymore" 

	Examples:
	|shopId		|
	|abc		|
	
@updatePixelWithInvalidShopId
Scenario Outline: User changes his pixelId with shopId is empty
	Given User is loggedin to the Onyx Meta and is on accounts section in Settings page with shopId "<shopId>"
	When User calls "updatePixel" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
#	And "message" in response body is "Shop Id is Required" 
	And "message" in response body is "Token is not valid anymore" 

	Examples:
	|shopId		|
	|			|
	
	
@updateValidPixel
Scenario: User changes his pixelId 
	Given User is loggedin to the Onyx Meta and is on accounts section in Settings page 
	When User calls "updatePixel" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
#	And "message" in response body is "Pixel updated Successfully." 
	Then get all data using "initCampaign" api
	And "success" in response body is "true" 
	
@createCustomAudience
Scenario: User creates custom audience (retargeting case)
	Given User is loggedin to the Onyx Meta and is on accounts section in Settings page 
	When User calls "createCustomAudience" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	Then Validate data using resource "createCustomAudience"
	
@ChangeBrandName
Scenario Outline: User changes his brand name 
	Given User is loggedin to the Onyx Meta and is on general details in Settings page with brandName "<brandName>"
	When User calls "saveConfig" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	And "message" in response body is "Config updated" 
	
	Examples:
	|brandName	|
	|Kinker		|

@getConfig	
Scenario: User opens settings section
	Given User is loggedin to the Onyx Meta and is on Settings page and shopId 
	When User calls "getConfig" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	Then Validate data using resource "getConfig"	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	