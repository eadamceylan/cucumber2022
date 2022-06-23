@reserve_car_2
Feature:US_8_user should be able to reserve a car
  User should be able to reserve a car as customer service profile

  Scenario Outline: US_8_reserve_car_as_a_customer
    Given user is on the login page
    And user login dropdown
    And user sends username "<username>"
    And user sends password "<password>"
    When user clicks on login button
    #user logged in as a customer
    And user select a car "<car>"
    And user enters pickup place "<pick_up_place>"
    And user enters dropoff place "<drop_off_place>"
    And user enters pickup date "<pickup_date>"
    And user enters pickup time "<pickup_time>"
    And user enters dropoff date "<dropoff_date>"
    And user enters dropoff time "<dropoff_time>"
    And click continue reservation
    And verify complete reservation screen pops up
    And enter credit card "<card_number>"
    And enter credit card name on card "<card_name>"
    And enter expire date "<expire_date>" and cvc "<CVC>"
    And checks the aggreement
    And click complete reservation
    And verify Reservation created successfully pop up
    And navigated to Reservations screen
    And verify the last reservation is created
    When you click on the last reservation
    Then verify that reservation detail page is displayed
    And verify the table has the following fields:Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age
    And click on back to reservations
    And verify Reservations page is displayed
    And click on Home link
    Then verify the home page is displayed



    Examples:
      | username                    | password | car         | pick_up_place | drop_off_place | pickup_date | pickup_time | dropoff_date | dropoff_time | card_number      | card_name | expire_date | CVC |
      | customer@bluerentalcars.com | 12345    | Ford Fiesta | London        | London         | 01.02.2021  | 14:00       | 01.03.2021   | 14:00        | 1234123412341234 | AAAA      | 0523        | 123 |