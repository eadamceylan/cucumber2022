@grid_feature
Feature: grid_feature
  @grid_chrome
  Scenario: TC01_running_on_chrome
    Given user is on the application_URL with chrome
    And verify the title of the page is "Blue Rental Cars | Cheap, Hygienic, VIP Car Hire"
    Then close the remote driver


    @grid_firefox
    Scenario: TC02_running_on_firefox
      Given user is on the application_URL with firefox
      And verify the title of the page is "Blue Rental Cars | Cheap, Hygienic, VIP Car Hire"
      Then close the remote driver

