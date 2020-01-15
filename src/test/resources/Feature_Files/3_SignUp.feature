Feature: 3. Signup feature

@SignUp
Scenario: To signup a new user account
    Given I Launch Application URL
	When I Click on link "Sign up"
	Then I Select text "Domain name" as "testing12435"
	Then I Select text "Email" as "test@gmail.com"
	Then I Select text "Name" as "Arun"
	Then I Select text "Username" as "Arun008"
	Then I Select text "Password" as "Qait"
	Then I Click on terms of service checkbox
	Then I Click on create account button