@excel_feature
Feature: FE35678_log_in_with_different_credentials

  @admin_excel_login
  Scenario: TC_login_with_admin
    Given user login with excel as "admin"
    Then capture the screenshot
    Then close the application

  @customer_excel_login
  Scenario: TC_login_with_customer
    Given user login with excel as "customer"
    Then capture the screenshot
    Then close the application