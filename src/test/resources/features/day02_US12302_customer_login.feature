@customer_login
Feature: customer_login
  Scenario Outline: login_customer_profile_testing

    Given user is on the login page
    And user login dropdown
    And user sends username "<username>"
    And user sends password "<password>"
    When user clicks on login button
    Then capture the screenshot
    Then close the application



    Examples: customer credentials
    |username                     |password|
    |customer@bluerentalcars.com  |12345   |
    |customer1@bluerentalcars.com |12346   |
    |customer2@bluerentalcars.com |12347   |
    |customer3@bluerentalcars.com |12348   |