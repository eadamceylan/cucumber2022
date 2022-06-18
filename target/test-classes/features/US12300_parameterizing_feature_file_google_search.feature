@parameterization1
Feature: US12300_parameterizing_feature_file_google_search

  Background: user_is_on_the_google_home_page
    Given user is on the google page

   Scenario: TC01_mercedes_Search
     When user search for "mercedes" on google
     Then verify the page title contains "mercedes"
     And close the application

  Scenario: TC02_tesla_Search
    When user search for "tesla" on google
    Then verify the page title contains "tesla"
    And close the application

  Scenario: TC03_lexus_Search
    When user search for "lexus" on google
    Then verify the page title contains "lexus"
    And close the application

  Scenario: TC04_toros_Search
    When user search for "toros" on google
    Then verify the page title contains "toros"
    And close the application

  Scenario: TC05_broadway_Search
    When user search for "broadway" on google
    Then verify the page title contains "broadway"
    And close the application