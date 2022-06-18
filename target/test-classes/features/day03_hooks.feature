@hooks_feature
Feature: customer_login
  Scenario Outline: login_customer_profile_testing

    Given user is on the login page
    And user login dropdown
    And user sends username "<username>"
    And user sends password "<password>"
    When user clicks on login button
    And test case fails
    Then close the application



    Examples: customer credentials
      |username                     |password|
      |customer@bluerentalcars.com  |12345   |