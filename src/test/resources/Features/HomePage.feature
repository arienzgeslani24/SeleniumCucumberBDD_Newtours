Feature: HomePage

@HomePageTest
Scenario: Successful Launching of the Application
	Given User Launch Edge browser
	When User opens URL "https://demo.guru99.com/test/newtours/"
	Then Page Title should be "Welcome: Mercury Tours"
	And close browser
