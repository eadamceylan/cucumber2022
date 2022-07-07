#What is a feature file?
#Feature file is used for creating test scenarios/test cases
#Gherkin language is used in a feature file
#All feature files must start with Feature keyword
#Each feature file can ONLY have 1 Feature keyword
@google_search @test3
Feature: First Feature File
#  Scenario = Test Case = Test Scenario
#  Each scenario has Gherkin keyword : Given, And, When, Then, But, *
#  Given -> should be used at eth beginning as preconditions
#  Then -> should be used for verification steps. Then steps are used to describe an expected outcome, or result.
#  When -> should be used in the middle steps. When steps are used to describe an event, or an action.
#  And -> should be used in the middle steps
#  I can use more than one Scenario: in a feature file

  Background: opening_google_page
    Given user is on the google page

  Scenario: TC01_Iphone_Search
#  Each step must begin with a Gherkin keyword
    When user search for iPhone on google
    Then verify the page title contains iPhone
    And close the application

  @teapot_search
  Scenario: TC02_Teapot_Search
    When user search for TeaPot on google
    Then verify the page title contains TeaPot
    And close the application

   @smoke_test
  Scenario: TC03_Flower_Search
    When user search for Flower on google
    Then verify the page title contains Flower
    And close the application

   @smoke_test
  Scenario: TC04_BMW_Search
    When user search for BMW on google
    Then verify the page title contains BMW
    And close the application
#  1. created a new step
#  2. Run to generate missing step definition
#  QUESTIONS:
#  1. Does spelling important in FF and Step defs? YES
#  2. Does order of steps in Feature file matters? YES
#  Because tests are run from TOP to BUTTOM in the feature file
#  3. Does order of step definitions on step definitions folder matters? NO
#  Because the tests run based of the steps NOT BASED ON THE STEP DEFINITIONS





