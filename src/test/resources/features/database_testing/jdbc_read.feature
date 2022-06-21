Feature: database_read_feature
  @db_customer_ssn
  Scenario: TC_read_customer_ssn_information
    Given user connects to the database
    And user gets the "*" from "tp_customer" table
    And user reads all of the "ssn" column data
    Then close the database connection