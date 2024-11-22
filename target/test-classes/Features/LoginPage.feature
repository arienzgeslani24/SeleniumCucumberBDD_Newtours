Feature: Login

@sanity
Scenario: Successful Login with Valid Credentials
	Given User Launch Edge browser
	When User opens URL "https://demo.guru99.com/test/newtours/"
	And User enters Username as "autotest1" and Password as "autotest1"
	And Click on Submit
	Then Page Title should be "Login: Mercury Tours"
	When User click on Signoff link
	Then Page Title should be "Welcome: Mercury Tours"
	And close browser

@regression
Scenario Outline: Successful Login with Valid Credentials
	Given User Launch Edge browser
	When User opens URL "https://demo.guru99.com/test/newtours/"
	And User enters Username as "<username>" and Password as "<password>"
	And Click on Submit
	Then Page Title should be "Login: Mercury Tours"
	When User click on Signoff link
	Then Page Title should be "Welcome: Mercury Tours"
	And close browser

Examples:
		| username | password |
		| autotest1 | autotest1 |
		| autotest2 | autopass2 |
	
	