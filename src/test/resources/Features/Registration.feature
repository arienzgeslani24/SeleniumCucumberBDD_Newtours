Feature: Registration

  @sanity1
  Scenario: Successful Login with Valid Credentials
    Given User Launch Edge browser
    When User opens URL "https://demo.guru99.com/test/newtours/"
    When User click on Register link
    Then Page Title should be "Register: Mercury Tours"
    When User enter customer info
    And click on Submit button
    Then User can view confirmation message "sign-in"
    And close browser

