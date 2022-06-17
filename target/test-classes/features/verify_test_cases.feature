@Testautomation
Feature: Verify Test Cases
  Background:
    Given user launches the browser
    When user navigates to URL

  Scenario: TC_07_Test_Cases
    Then user verifies that home page is visible successfully
    And user clicks on Test Cases button
    Then user is navigated to test cases page successfully
    Then user closes the browser

  Scenario: TC_22_Add_Cart
    Then user scrolls to bottom of the page
    And user verifies RECOMMENDED ITEMS are visible
    And user clicks on Add To Cart button on Recommended product
    And user clicks on View Cart button
    And user verifies that product is displayed in the cart page