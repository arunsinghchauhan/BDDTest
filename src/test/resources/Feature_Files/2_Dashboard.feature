Feature: 2. Dashboard Features

@Dashboard
Scenario: Create a new user
	Given I verify page title is "framework | Home"
	When I select link "Add user"
	Then I Enter "First name" as "Arun"
	Then I Enter the "Last name" as "Chauhan"
	Then I Enter mailid "Email address" as "test1@gmail.com"
	Then I Enter username "Username" as "arunchauhan008"
	Then I Enter password "Password" as "Temp@123"
	Then I Enter a "description" as "Hey, User you have to provide your skills over here....."
	Then I Click "Add user"
	
	Then I Navigate to goto dropdown 
	