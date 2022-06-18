@hooks_feature
Feature: customer_login

  Scenario Outline: login_customer_profile_testing
    Given user is on the login page
    And user login dropdown
    And user sends username "<username>"
    And user sends password "<password>"
    When user clicks on login button
    And test case fails
    #    I do this test step on purpose, I am trying to check the method in Hooks
    #    It should get screenshot when test fails
    Examples: customer credentials
      | username                     | password |
      | customer@bluerentalcars.com  | 12345    |
