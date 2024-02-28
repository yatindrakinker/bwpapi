Feature: Onboarding/Create new user

@GetToken
Scenario: User hits the url to get the token
	Given Onboarding url
	When User hits the url the access token is generated in new url
	Then User after extracting token from url used it to register himself.

@alreadyRegisteredEmail
Scenario Outline: User tries to create new user that is already registered.
	Given Create new user page with "<email>"
	When User calls "isEmailExist" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "false" 
	And "message" in response body is "Email already exists."
	
	Examples:
				|email							|
				|iamyatindrathephenom@gmail.com	|

@RegisteringWithInvalidEmail
Scenario Outline: User tries to create new user with invalid email address.
	Given Create new user page with "<email>"
	When User calls "isEmailExist" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	And "message" in response body is "New Email Address."
	
	Examples:
				|email							|
				|iamyatindra@gmail.com			|
				|iamyatindra@jmail.com			|
				|iamyatindra					|
				|123456							|
				|!@#$							|
				|								|

@RegisterWithNewAndValidEmail
Scenario Outline: User tries to create new user that is already created.
	Given Create new user page with "<email>"
	When User calls "isEmailExist" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	And "message" in response body is "New Email Address."
	Then "otpMail" api is hit with "Get" http request
	And The API call got success with status code 200 
	And "success" in response body is "true" 
	And "message" in response body is "One-time Passcode sent successfully!"
	
	Examples:
				|email							|
				|yatindrakinker@cedcommerce.com	|
				
@CreateUserAPI
Scenario Outline: User have validated his account by OTP
	Given createUser payload with email "<email>" newPassword "<new_password>" confirm_password "<confirm_password>" brand_name "<brand_name>"
	When User calls "isEmailExist" with "Post" http request 
	Then The API call got success with status code 200 
	And "success" in response body is "true" 
	And "message" in response body is "New Email Address."
	
	Examples:
				|email									|new_password	|confirm_password	|brand_name		|key	|value	|
				|abhishekkumarbhartiya@cedcommerce.com 	|Abhishek@123	|Abhishek@123		|yatindra		|brand	|Kinker	|
				