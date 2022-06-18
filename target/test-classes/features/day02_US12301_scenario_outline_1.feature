@scenario_outline_1
Feature: day02_US12300_scenario_outline_1.feature

  Background: opening_google_page
    Given user is on the google page

  Scenario Outline: TC_Google_Search_Test

    When user search for "<value>" on google
    Then verify the page title contains "<value>"
    Then capture the screenshot
    Then close the application

#    shift+\  = |
    Examples: test_data
    |value|
    |mercedes|
    |tesla   |
    |lexus   |
    |bmw     |
    |apple   |
    |orange  |
    |capitals|
    |vacation|
    |best places to live|


#Scenario outline is used to run same scenario multiple times with different data
#Scenario Outline must be followed by Example keyword
#Examples keyword is used for passing test data
#Scenario Outline is used for DDT-Data Driven testing. This is similar to testing with excel sheet
#Sceario Outline makes feature files shorter and cleaner
