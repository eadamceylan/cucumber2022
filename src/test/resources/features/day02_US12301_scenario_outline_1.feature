@scenario_outline_1
Feature: day02_US12301_scenario_outline_1

  Background: opening_google_page
    Given user is on the google page

  Scenario Outline: TC_Google_search_Test
    When user search for "<value>" on google
    Then verify the page title contains "<value>"
    Then close the application

    Examples: test_data
      | value    |
      | mercedes |
      | apple    |
      | teapot   |
      | bmw      |

    # CTRL + Alt + L = organize the pipeline
    # Scenario Outline: is used to run same scenario multiple times with different data
    # Example keyword is used for sending different test data
    # Scenario Outline is used for DDT (Data Driven Testing) This is similar with testing excel sheet
