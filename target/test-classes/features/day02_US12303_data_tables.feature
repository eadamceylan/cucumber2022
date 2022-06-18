@admin_login
Feature: admin_login
  Scenario: login_with_admin_profile
#Do i have reusable step definition??? Yes
#  admin@bluerentalcars.com
    Given user is on the login page
    And user login dropdown
    And user enters admin_username and admin_password
    |admin_id                 |admin_pass|
    |admin@bluerentalcars.com |12345     |
    When user clicks on login button
    Then verify the login is successful
    Then close the application

